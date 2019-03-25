package test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		String URL="jdbc:oracle:thin:@//172.16.20.176:1521/wtdb";
        String USER="e_channel";
        String PASSWORD="e_channel";
        //1.加载驱动程序
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        int n = 1;
        while(true) {
        	 st.executeQuery("select sysdate from dual");
        	 System.out.println(n++);
        	 Thread.sleep(180000);
        }

	}

}
