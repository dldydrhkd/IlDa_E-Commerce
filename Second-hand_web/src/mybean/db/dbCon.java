package mybean.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbCon {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://localhost:3306/SHDB?serverTimezone=UTC&autoReconnect=true";
		String dbUser = "root";
		String dbPwd = "12341234";
		
		Class.forName(jdbcDriver);
		// 2. Database Connection 연결
		conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
		
		return conn;
	}
}

