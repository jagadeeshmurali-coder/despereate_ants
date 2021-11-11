package day18;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/coda4","root","Gaayathri@123");
		System.out.println(con);
	}

}
