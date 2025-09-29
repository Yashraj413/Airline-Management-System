package airlinemanagementsystem;

import java.sql.*;

public class Conn {
	static String url="jdbc:mysql:///airlinemanagement";
	static String username="root";
	static String password="root123*";
	
	Connection conn=null;
	
	public Connection CreateConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Database connected");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
