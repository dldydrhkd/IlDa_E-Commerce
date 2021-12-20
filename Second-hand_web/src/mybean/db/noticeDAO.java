package mybean.db;

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
	
	
<<<<<<< Updated upstream
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
=======
	public void insertRecord(noticeVO notice) throws SQLException {
		String sql = "insert into noticeTbl(noticeNumber, noticeTitle, noticeInfo, "
				+ " noticeClassification, userNumber) values(?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  null);
		pstmt.setString(2,  notice.getNoticeTitle());
		pstmt.setString(3,  notice.getNoticeInfo());
		pstmt.setString(4,  notice.getNoticeClassification());
		pstmt.setInt(5,  notice.getUserNumber());

>>>>>>> Stashed changes
		
		pstmt.executeUpdate();
	}
	
<<<<<<< Updated upstream
	public void updateRecord(noticeVO Nvo, userVO Uvo) throws SQLException {
		String sql = "update noticeTbl set noticeTitle=?, noticeInfo=?, noticeState=?, noticeClassification=? noticeImgfileRealName=? "
				+ "where noticeNumber=? and userNumber=?";
=======
	public void updateRecord(noticeVO notice) throws SQLException {
		String sql = "update noticeTbl set noticeTitle=?, noticeInfo=?, noticeState=?, noticeClassification=? "
				+ "where noticeNumber=?";
>>>>>>> Stashed changes
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
	
<<<<<<< Updated upstream
	public void deleteRecord(noticeVO Nvo, userVO Uvo) throws SQLException {
		String sql = "delete from noticeTbl where noticeNumber = ? and userNumber = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, Nvo.getNoticeNumber());
		pstmt.setInt(2, Uvo.getUserNumber());
=======
	public void deleteRecord(noticeVO notice) throws SQLException {
		String sql = "update noticeTbl n, commentTbl c set n.noticeCondition='비공개', c.commentCondition='비공개' where noticeNumber = ? ";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, notice.getNoticeNumber());
>>>>>>> Stashed changes
		
		pstmt.executeUpdate();
	}
	
	public List<noticeVO> listNotice() throws SQLException{
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
	
	public noticeVO getnoticeView(int noticeNumber) throws SQLException {
		String sql="select * from noticeTbl where noticeNumber = ?";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, noticeNumber);
		
		rs = pstmt.executeQuery();//select
		
		if(rs.next()) {
			noticeVO nd = new noticeVO();
			nd.setNoticeNumber(rs.getInt(1));
			nd.setNoticeTitle(rs.getString(2));
			nd.setNoticeInfo(rs.getString(3));
			nd.setNoticeState(rs.getString(4));
			nd.setNoticeClassification(rs.getString(5));
			return nd;
		}			
		return null;
	}
	
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	
}
