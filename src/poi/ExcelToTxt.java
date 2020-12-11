package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcelToTxt {

	Logger logger = LoggerFactory.getLogger(ExcelToTxt.class);
	public void test() throws Exception {
		FileWriter fw = new FileWriter("E:\\sqlldr\\01.txt", true);//文件续写
		fw.write("sfsdfasdfasdf\r\nasdfjaskdjl");//只能写英文
		fw.close();
		FileInputStream fis = new FileInputStream("E:\\sqlldr\\01.xlsx");
		List<List<String>> list = readExcel_xlsx(fis);
		for (List<String> list2 : list) {
			fw.write(list2.get(0));
			fw.write(" ");
		}
	}
	
	/**
     * 读取Excel后缀为xls的文件，返回一个集合，集合中对象为每一行的结果集。
     * （不包括第一行的此标题，即从表格第二行开始读取）
     *
     * @param inputStream
     * @return
     */
    public static List<List<String>> readExcel_xls(InputStream inputStream) {
        List<List<String>> result = new ArrayList<>();
        try {
            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = wb.getSheetAt(0); // 只读第一个 sheet
            wb.close();
            for (int i = 1, n = sheet.getLastRowNum(); i <= n; i++) { // excel中 第二行
                Row row = sheet.getRow(i);
                try {
                    if (!isOneCell(row)) {
                        return result;
                    }
                    List<String> list = parseExcel(row);
                    result.add(list);
                } catch (Exception e) {
                    throw new RuntimeException("第" + i + "行出错-->" + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件未找到！");
        } catch (IOException e) {
            throw new RuntimeException("读取文件失败，失败原因：" + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
        return result;
    }
    
    /**
     * 读取Excel后缀为xlsx的文件，返回一个集合，集合中对象为每一行的结果集。
     * （不包括第一行的此标题，即从表格第二行开始读取）
     *
     * @param inputStream
     * @return
     */
    public static List<List<String>> readExcel_xlsx(InputStream inputStream) {
        List<List<String>> result = new ArrayList<>();
        try {
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(0); // 只读第一个 sheet
            wb.close();
            for (int i = 1, n = sheet.getLastRowNum(); i <= n; i++) { // excel中 第二行
                Row row = sheet.getRow(i);
                try {
                    if (!isOneCell(row)) {
                        return result;
                    }
                    List<String> list = parseExcel(row);
                    result.add(list);
                } catch (Exception e) {
                    throw new RuntimeException("第" + i + "行出错-->" + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件未找到！");
        } catch (IOException e) {
            throw new RuntimeException("读取文件失败，失败原因：" + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
        return result;
    }
    
    /**
     * 校验读取每一行的第一列的值，是否有效
     */
    private static boolean isOneCell(Row row) {
        if (row != null && row.getCell(0) != null) {
            String cell0 = getCellValue(row.getCell(0));
            return StringUtils.isNotBlank(cell0);
        }
        return false;
    }
    
    /**
     * POI 读取 Excel 内容时按格式转换
     */
    public static String getCellValue(Cell cell) {
        // 当cell 为null 时的处理
        if (cell == null)
            return "";
        if (cell.getCellTypeEnum().equals(CellType.BLANK)) {
            return "";
        } else if (cell.getCellTypeEnum().equals(CellType.BOOLEAN)) {// boolean类型值
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {// 数字类型
            if (HSSFDateUtil.isCellDateFormatted(cell)) { // 日期必须要先判断为数字，否则出错
                Date d = cell.getDateCellValue();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.format(d);
            } else {
                String numStr = new DecimalFormat("0.00").format(cell.getNumericCellValue());
                int index = numStr.indexOf(".");
                if (index == -1) {
                    return numStr;
                } else {
                    return numStr.substring(0, index);
                }
            }

            //return numricDf.format(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }
    
    /**
     * 解析 Excel 按顺序将值放入集合
     *
     * @param row
     * @return
     */
    private static List<String> parseExcel(Row row) {

        List<String> list = new ArrayList<>();
        for (int j = 0, m = row.getLastCellNum(); j < m; j++) {
            Cell cell = row.getCell(j);
            String val = getCellValue(cell);
            list.add(val);
        }
        return list;
    }

}
