package main;
import jpcap.JpcapCaptor; 
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class main {
	public static void main(String[] args) {
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://127.0.0.1:3306/mydb";
			String user = "root";
			String password = "root";
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("数据库链接对象" + conn);
			Statement stat = (Statement) conn.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
