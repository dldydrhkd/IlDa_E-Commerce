package mybean.dbte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class noticeDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// Singleton
	private static noticeDAO notice;

	private noticeDAO() throws SQLException, ClassNotFoundException {
		conn = dbCon.getConnection();
	}

	public static noticeDAO getInstance() throws SQLException, ClassNotFoundException {
		if(notice==null) {
			notice = new noticeDAO();
		}
		return notice;
	}
	
	
	public void insertRecord(noticeVO Nvo, userVO Uvo) throws SQLException {
		String sql = "insert into noticeTbl(noticeTitle, noticeInfo, noticeState, "
				+ " noticeClassification, userNumber, noticecImgfileRealName) values(?,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  Nvo.getNoticeTitle());
		pstmt.setString(2,  Nvo.getNoticeInfo());
		pstmt.setString(3,  Nvo.getNoticeState());
		pstmt.setString(4,  Nvo.getNoticeClassification());
		pstmt.setInt(5,  Uvo.getUserNumber());
		pstmt.setString(6, Nvo.getNoticeImgfileRealName());
		
		pstmt.executeUpdate();
	}
	
	public void updateRecord(noticeVO Nvo, userVO Uvo) throws SQLException {
		String sql = "update noticeTbl set noticeTitle=?, noticeInfo=?, noticeState=?, noticeClassification=? noticeImgfileRealName=? "
				+ "where noticeNumber=? and userNumber=?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,  Nvo.getNoticeTitle());
		pstmt.setString(2,  Nvo.getNoticeInfo());
		pstmt.setString(3,  Nvo.getNoticeState());
		pstmt.setString(4,  Nvo.getNoticeClassification());
		pstmt.setString(5,  Nvo.getNoticeImgfileRealName());
		pstmt.setInt(6,  Nvo.getNoticeNumber());
		pstmt.setInt(7,  Uvo.getUserNumber());
		
		pstmt.executeUpdate();
	}
	
	public void deleteRecord(noticeVO Nvo, userVO Uvo) throws SQLException {
		String sql = "delete from noticeTbl where noticeNumber = ? and userNumber = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, Nvo.getNoticeNumber());
		pstmt.setInt(2, Uvo.getUserNumber());
		
		pstmt.executeUpdate();
	}
	
	public List<noticeVO> list() throws SQLException{
		List<noticeVO> noticeList = new ArrayList<>();
		String sql = "select * from noticeTbl";
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			noticeList.add(new noticeVO(rs.getInt(1),rs.getString(2),rs.getString(3), 
					rs.getString(4), rs.getString(5),rs.getDate(6), rs.getInt(7), rs.getString(8)));
		}
		return noticeList;
	}
	
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	
}
