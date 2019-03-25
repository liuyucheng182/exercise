package poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    HSSFWorkbook workBook=new HSSFWorkbook();
    FileOutputStream fOut=new FileOutputStream("D:\\workbook.xlsx");
    workBook.write(fOut);
    fOut.close();
	}

}
