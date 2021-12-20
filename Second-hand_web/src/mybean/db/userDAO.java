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

	private userDAO() throws SQLException, ClassNotFoundException {
		conn = dbCon.getConnection();
	}

	public static userDAO getInstance() throws SQLException, ClassNotFoundException {
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
	
	public void insertRecord(userVO user) throws SQLException {
		String sql = "insert into userTbl(userId, userPwd, userName, userAge,"
				+ " userPhoneNumber, userAddr, userEmail, userGender) values(?,?,?,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  user.getUserId());
		pstmt.setString(2,  user.getUserPwd());
		pstmt.setString(3,  user.getUserName());
		pstmt.setInt(4,  user.getUserAge());
		pstmt.setString(5,  user.getUserPhoneNumber());
		pstmt.setString(6,  user.getUserAddr());
		pstmt.setString(7,  user.getUserEmail());
		pstmt.setString(8,  user.getUserGender());
		
		pstmt.executeUpdate();
	}
	
	public void updateRecord(userVO user) throws SQLException {
		String sql = "update userTbl set userPwd=?, userName=?, userPhoneNumber=?, userAddr=?, userEmail=?"
				+ " where userId=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getUserPwd());
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getUserPhoneNumber());
		pstmt.setString(4, user.getUserAddr());
		pstmt.setString(5, user.getUserEmail());
		pstmt.setString(6, user.getUserId());
		
		pstmt.executeUpdate();
	}
	
	public void deleteRecord(String id) throws SQLException {
		String sql = "update userTbl u, notice n, comment c"
				+ " set u.userCondition='탈퇴', n.noticeCondition='비공개', c.commentCondition='비공개' where id = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		pstmt.executeUpdate();
	}
	
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(rs != null) pstmt.close();
		if(rs != null) conn.close();
	}
}

