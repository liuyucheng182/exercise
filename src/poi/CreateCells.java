package poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateCells {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
   HSSFWorkbook wb=new HSSFWorkbook();
   HSSFSheet sheet=wb.createSheet("sheet1");
   HSSFRow row=sheet.createRow(0);
   HSSFCell cell=row.createCell(0);
   cell.setCellValue("你好吗");
   row.createCell(1).setCellValue("1");
   row.createCell(2).setCellValue(2.2);
   row.createCell(3).setCellValue(true);
   row.createCell(4).setCellValue(4);
   row.createCell(5).setCellValue("5");
   FileOutputStream fOut=new FileOutputStream("D:\\workbook4.xls");
   wb.write(fOut);
   fOut.close();
	}

}
