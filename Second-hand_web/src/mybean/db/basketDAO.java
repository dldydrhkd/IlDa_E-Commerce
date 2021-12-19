package mybean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class basketDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// Singleton
	private static basketDAO basket;

	private basketDAO() throws SQLException, ClassNotFoundException {
		conn = dbCon.getConnection();
	}

	public static basketDAO getInstance() throws SQLException, ClassNotFoundException {
		if(basket==null) {
			basket = new basketDAO();
		}
		return basket;
	}
	public void insertBasket(basketVO Bvo, userVO Uvo, noticeVO Nvo) throws SQLException{
		String sql = "insert into basketTbl(basketNumber,userNumber, noticeNumber) values(?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, Bvo.getBasketNumber());
		pstmt.setInt(2, Uvo.getUserNumber());
		pstmt.setInt(3,  Nvo.getNoticeNumber());
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	public void deleteBasket(basketVO Bvo, userVO Uvo, noticeVO Nvo) throws SQLException {
		String sql = "delete from basketTbl where (basketNumber = ?)"
				+ "and (userNumber = ?) and (noticeNumber = ?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Bvo.getBasketNumber());
		pstmt.setInt(2, Uvo.getUserNumber());
		pstmt.setInt(3,  Nvo.getNoticeNumber());
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
}
