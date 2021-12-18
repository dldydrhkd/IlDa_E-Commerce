package mybean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// Singleton
	private static userDAO user;

	private userDAO() throws ClassNotFoundException, SQLException {
		conn = dbCon.getConnection();
	}

	public static userDAO getInstance() throws ClassNotFoundException, SQLException {
		if(user==null) {
			user = new userDAO();
		}
		return user;
	}
	
	public boolean isLoginOk(String id, String pwd) throws SQLException{
		String sql = "select * from userTbl";
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("userId").equals(id) && rs.getString("userPwd").contentEquals(pwd)) {
				return true;
			}
		}
		return false;
	}
}

