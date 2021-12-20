package mybean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class commentDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// Singleton
	private static commentDAO comment;

	private commentDAO() throws SQLException, ClassNotFoundException {
		conn = dbCon.getConnection();
	}

	public static commentDAO getInstance() throws SQLException, ClassNotFoundException {
		if(comment==null) {
			comment = new commentDAO();
		}
		return comment;
	}
	
	
	public void insertRecord(commentVO comment) throws SQLException {
		String sql = "insert into commentTbl(commentNumber, commentInfo, noticeNumber, userId) "
				+ " values(?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  null);
		pstmt.setString(2,  comment.getCommentInfo());
		pstmt.setInt(3,  comment.getNoticeNumber());
		pstmt.setString(4,  comment.getUserId());
		
		pstmt.executeUpdate();
	}
	
	public void updateRecord(commentVO comment) throws SQLException {
		String sql = "update commentTbl set commentInfo=? "
				+ "where commentNumber=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,  comment.getCommentInfo());
		pstmt.setInt(2,  comment.getCommentNumber());

		pstmt.executeUpdate();
	}
	
	public void deleteRecord(commentVO comment) throws SQLException {
		String sql = "update commentTbl set commentCondition='0' "
				+ "where commentNumber=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, comment.getCommentNumber());
		
		pstmt.executeUpdate();
			
	}
	
	public List<commentVO> listComment(int noticeNumber) throws SQLException {
		
		List<commentVO> commentList = new ArrayList<commentVO>();
		
		String sql = "select * from commentTbl where noticeNumber=?";
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, noticeNumber);
			
		rs = pstmt.executeQuery();
			
		while(rs.next()) {	
			commentList.add(new commentVO(rs.getString("userId"), rs.getDate("commentRegistrationDate"), rs.getString("commentInfo")));
		}	
		return commentList;
		 
	}
	
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}

}
