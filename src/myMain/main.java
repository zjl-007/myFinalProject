package myMain;
import jpcap.JpcapCaptor; 
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class main {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stat = null;
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			//ע������
			DriverManager.registerDriver(driver);
			//��ȡ����
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytestdb", "root", "root");
			stat = (Statement) conn.createStatement();
			//JDBCSQL��䲻��д�ֺ�
			String sql = "insert into my_table (id, name) values(3, 'zhangsan')";
			//ִ��SQL���
			int res = stat.executeUpdate(sql);
			System.out.println(res);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//�ر���Դ
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