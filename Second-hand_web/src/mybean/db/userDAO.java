package mybean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

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
	
	public int isLoginOk(String id, String pwd) throws SQLException{
		String sql = "select * from userTbl";
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("userId").equals(id) && rs.getString("userPwd").equals(pwd)) {
				if(rs.getString("userCondition").equals("일반")) {
					return rs.getInt("userNumber");
				}
				return -1;
			}
		}
		return -1;
	}
	
	public boolean isPwdOk(String id, String pwd) throws SQLException{
		String sql = "select * from userTbl where userId=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("userPwd").equals(pwd)) {
				return true;
			}
		}
		return false;
	}
	
	public void insertRecord(userVO user) throws SQLException {
		String sql = "insert into userTbl(userNumber, userId, userPwd, userName, userBirthDate,"
				+ " userPhoneNumber, userAddr, userEmail, userGender, userCondition, userWithdrawalDate) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  null);
		pstmt.setString(2,  user.getUserId());
		pstmt.setString(3,  user.getUserPwd());
		pstmt.setString(4,  user.getUserName());
		pstmt.setDate(5,  user.getUserBirth());
		pstmt.setString(6,  user.getUserPhoneNumber());
		pstmt.setString(7,  user.getUserAddr());
		pstmt.setString(8,  user.getUserEmail());
		pstmt.setString(9,  user.getUserGender());
		pstmt.setString(10,  "일반");
		pstmt.setDate(11,  null);
		
		pstmt.executeUpdate();
	}
	
	public void updateRecord(userVO user) throws SQLException {
		String sql = "update userTbl set userPwd=?, userName=?, userPhoneNumber=?, userAddr=?, userEmail=? where userId=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user.getUserPwd());
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getUserPhoneNumber());
		pstmt.setString(4, user.getUserAddr());
		pstmt.setString(5, user.getUserEmail());
		pstmt.setString(6, user.getUserId());
		
		pstmt.executeUpdate();
	}
	
	public void deleteRecord(String id, Date d, int userNumber) throws SQLException {
		
		String sql = "update userTbl set userCondition='탈퇴', userWithdrawalDate=? where userId=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setDate(1, d);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
		sql = "update noticeTbl set noticeCondition='0' where userNumber = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,userNumber);
		pstmt.executeUpdate();
		
		sql = "update commentTbl set commentCondition='0' where userId = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.executeUpdate();
	}
	
	public boolean duplicateIdCheck(String id) throws SQLException {
		String sql = "select * from userTbl";
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("userId").equals(id)) {
				return false;
			}
		}
		return true;
	}
	
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
}

