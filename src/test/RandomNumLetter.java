package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class RandomNumLetter {

	//数字+字母（不区分大小写），除去1、L、I、0、O；
	static String charStr = "23456789abcdefghjkmnpqrstuvwxyz";
	
	 /**
     * 生成随机数字和字母组合
     * 
     * @param length  生成随机数的长度
     * @return
     */
	public static String getCharAndNumr(int length) {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int charLength = charStr.length();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(charLength);
			buffer.append(charStr.charAt(index));
		}
		return buffer.toString();
	}

	public static void writeToExcel(Collection<String> collection) throws Exception {
		   HSSFWorkbook wb=new HSSFWorkbook();
		   HSSFSheet sheet=wb.createSheet("sheet1");
		   Iterator<String> it = collection.iterator();
		   int i = 0;
		   while(it.hasNext()) {
			   HSSFRow row=sheet.createRow(i);
			   HSSFCell cell=row.createCell(0);
			   cell.setCellValue(it.next().toString());
			   i++;
		   }
		   
		   /*HSSFCellStyle cellStyle=wb.createCellStyle();
		   cellStyle.setFillBackgroundColor(HSSFCellStyle.SOLID_FOREGROUND);
		   cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		   cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		   cellStyle.setWrapText(true);
		   HSSFFont font=wb.createFont();
		   font.setFontName("黑体");
		   font.setColor(HSSFFont.COLOR_RED);
		   cellStyle.setFont(font);
		   cell.setCellStyle(cellStyle);*/
		   FileOutputStream fOut=new FileOutputStream("D:\\workbook4.xls");
		   wb.write(fOut);
		   fOut.close();
	}
	
	//list集合去重
	public static List<String> getRandomList(){
		List<String> list = new ArrayList<>();
		String s;
		int i;
		for (i = 0; i < 50000; i++) {
			s = getCharAndNumr(10);
			if(!list.contains(s)) {
				list.add(s);
			}
		}
		System.out.println(i);
		System.out.println(list.size());
		return list;
	}
	
	//set集合去重
	public static Set<String> getRandomSet(){
		Set<String> set = new HashSet<String>();
		int i;
		for (i = 0; set.size() < 50; i++) {
			set.add(getCharAndNumr(10));
		}
		
		System.out.println(i);
		System.out.println(set.size());
		return set;
	}
	
	public static void main(String[] args) {
		//测试list和set去重方式的效率
		try {
			writeToExcel(getRandomList());
			//writeToExcel(getRandomSet());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
