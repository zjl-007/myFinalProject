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
			//1ע������
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://localhost:3306/mytestdb";
			String user = "root";
			String password = "root";
			//2��ȡ����
			conn = (Connection) DriverManager.getConnection(url, user, password);
			stat = (Statement) conn.createStatement();
			//3JDBCSQL��䲻��д�ֺ�
			//String controlSql = "insert into my_table (id, name) values(5, 'zhangsan')";
			//4ִ��SQL���
			//int upRes = stat.executeUpdate(controlSql); //ֻ�ܴ���insert/delete/update
			//5�����ѯ�����
			String querySql = "select * from my_table";
			queryRes = stat.executeQuery(querySql); //ִ��DQL���,��ȡ��ѯ�������
			while (queryRes.next()) {//ÿnextһ��,���ݱ�Ĺ������һ���ƶ�һλ
				//���˿�����String����ȡ����������ʹ��getInt()�����������
				String id = queryRes.getString("id"); //ȡ���ݣ���������������(n��)��������
				String name = queryRes.getString("name"); //ȡ����
				System.out.println("id" + id + "name" + name);
			}
			//System.out.println(upRes);
			System.out.println(queryRes);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//6�ر���Դ
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