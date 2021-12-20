package mybean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void insertBasket(basketVO basket) throws SQLException{
		String sql = "insert into basketTbl(basketNumber,userNumber, noticeNumber) values(?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, basket.getBasketNumber());
		pstmt.setInt(2, basket.getUserNumber());
		pstmt.setInt(3, basket.getNoticeNumber());
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	public void deleteBasket(int basketNumber) throws SQLException {
		String sql = "delete from basketTbl where basketNumber = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, basketNumber);

		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public List<basketListVO> listBasket(int userNumber) throws SQLException{
		List<basketListVO> basketList = new ArrayList<>();
		String sql = "select * from noticeTbl n join basketTbl b on (n.userNumber=b.userNumber)"
				+ "where n.userNumber=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, userNumber);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			basketList.add(new basketListVO(rs.getInt("noticeNumber"),rs.getInt("basketNumber"),rs.getString("noticeTitle")));
		}
		
		return basketList;
	}
	
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
}
