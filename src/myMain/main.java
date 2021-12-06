package myMain;
import java.util.*;
import jpcap.JpcapCaptor; 
import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stat = null;
		ResultSet queryRes = null;
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			//1注册驱动
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://localhost:3306/mytestdb";
			String user = "root";
			String password = "root";
			//2获取链接
			conn = (Connection) DriverManager.getConnection(url, user, password);
			stat = (Statement) conn.createStatement();
			//3JDBCSQL语句不用写分号
			//String controlSql = "insert into my_table (id, name) values(5, 'zhangsan')";
			//4执行SQL语句
			//int upRes = stat.executeUpdate(controlSql); //只能处理insert/delete/update
			//5处理查询结果集
			String querySql = "select * from my_table";
			queryRes = stat.executeQuery(querySql); //执行DQL语句,获取查询结果对象
			while (queryRes.next()) {//每next一次,数据表的光标向下一行移动一位
				//除了可以以String类型取出，还可以使用getInt()（区分情况）
				String id = queryRes.getString("id"); //取数据，参数可以是数字(n列)或者列名
				String name = queryRes.getString("name"); //取数据
				System.out.println("id" + id + "name" + name);
			}
			//System.out.println(upRes);
			System.out.println(queryRes);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//6关闭资源
			if(stat != null) {
				try {
					stat.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}