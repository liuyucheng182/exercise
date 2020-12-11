package poi;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分省将数据存入31个Excel表中
 */
public class ActiveUserStatistics {

    public static void main(String[] args) throws IOException {


        for (int i = 1; i <=31 ; i++) {
            String areaCode = "";
            if(i<10){
                areaCode = "0" + i;
            }else {
                areaCode = i + "";
            }
            String provinceName = getProvinceName("select province_name from province_dic where province_code = '"+areaCode+"'");
            XSSFWorkbook wb=new XSSFWorkbook();
            XSSFSheet sheet=wb.createSheet(provinceName);
            XSSFRow head=sheet.createRow(0);
            head.createCell(0).setCellValue("acc_nbr");
            head.createCell(1).setCellValue("area_code");
            head.createCell(2).setCellValue("status");
            String sql = "select * from all_acc_nbr_temp where area_code = '"+areaCode+"' ";
            List<Map<String,String>> list = getAll(sql);
            for (int j =0; j< list.size(); j++){
                XSSFRow row=sheet.createRow(j+1);
                XSSFCell cell1=row.createCell(0);
                XSSFCell cell2=row.createCell(1);
                XSSFCell cell3=row.createCell(2);
                cell1.setCellValue(list.get(j).get("accNbr"));
                cell2.setCellValue(list.get(j).get("areaCode"));
                cell3.setCellValue(list.get(j).get("status"));
            }
            FileOutputStream fOut=new FileOutputStream("/Users/liuyucheng/Downloads/all_ncc_nbr/"+areaCode+"_"+provinceName+".xlsx",false);
            wb.write(fOut);
            fOut.close();
            System.out.println(areaCode+"完成");
        }


    }


    private static Connection getConn() {
        //mysql8.0配置方式
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

    private static String getProvinceName(String sql) {
        Connection conn = getConn();
        PreparedStatement pstmt;
        String provinceName = "";
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                provinceName  = rs.getString("province_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provinceName;
    }

}
