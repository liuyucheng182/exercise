package poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 分省将数据存入Excel文件的31个sheet页中（效率较低，执行时间长，消耗资源）
 */
public class ExcelSample {

	public static void main(String[] args) throws IOException {

        XSSFWorkbook wb=new XSSFWorkbook();
        for (int i = 1; i <=31 ; i++) {
            if(i<10){
                String areaCode = "0" + i;
                XSSFSheet sheet=wb.createSheet(areaCode);
                String sql = "select * from all_acc_nbr_temp where area_code = '"+areaCode+"' ";
                List<Map<String,String>> list = getAll(sql);
                for (int j =0; j< list.size(); j++){
                    XSSFRow row=sheet.createRow(j);
                    XSSFCell cell1=row.createCell(0);
                    XSSFCell cell2=row.createCell(1);
                    XSSFCell cell3=row.createCell(2);
                    cell1.setCellValue(list.get(j).get("accNbr"));
                    cell2.setCellValue(list.get(j).get("areaCode"));
                    cell3.setCellValue(list.get(j).get("status"));
                    System.out.println(list.get(j).get("accNbr"));
                }

            } else {
                String areaCode = i + "";
                XSSFSheet sheet=wb.createSheet(areaCode);
                String sql = "select * from all_acc_nbr_temp where area_code = '"+areaCode+"' ";
                List<Map<String,String>> list = getAll(sql);
                for (int j =0; j< list.size(); j++){
                    XSSFRow row=sheet.createRow(j);
                    XSSFCell cell1=row.createCell(0);
                    XSSFCell cell2=row.createCell(1);
                    XSSFCell cell3=row.createCell(2);
                    cell1.setCellValue(list.get(j).get("accNbr"));
                    cell2.setCellValue(list.get(j).get("areaCode"));
                    cell3.setCellValue(list.get(j).get("status"));
                }
            }
        }

        FileOutputStream fOut=new FileOutputStream("/Users/liuyucheng/Downloads/all_ncc_nbr.xlsx");
        wb.write(fOut);
        fOut.close();
	}


    private static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/middle_db?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "ctsi2019";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static List<Map<String,String>>  getAll(String sql) {
        Connection conn = getConn();
        PreparedStatement pstmt;
        List<Map<String,String>> list = new ArrayList<>();
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Map<String,String> map = new HashMap<>();
                // 通过字段检索
                String accNbr  = rs.getString("acc_nbr");
                String areaCode = rs.getString("area_code");
                String status = rs.getString("status");
                map.put("accNbr",accNbr);
                map.put("areaCode",areaCode);
                map.put("status",status);
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
