package mybean.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketDAO 
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// Singleton
	private static BasketDAO basket;

	private BasketDAO() throws SQLException, ClassNotFoundException 
	{
		conn = dbCon.getConnection();
	}

	public static BasketDAO getInstance() throws SQLException, ClassNotFoundException 
	{
		if(basket==null) {
			basket = new BasketDAO();
		}
		return basket;
	}
	public void ShowList() throws SQLException
	{
		
	}
	public void insertBasket(basketVO Bvo, userVO Uvo, noticeVO Nvo) throws SQLException
	{
		try
		{
		String sql = "insert into basketTbl(basketNumber,userNumber, noticeNumber) values(?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Bvo.getBasketNumber());
		pstmt.setString(2, Uvo.getUserNumber());
		pstmt.setString(3,  Nvo.getNoticeNumber());
		
		pstmt.executeUpdate();
		pstmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public void deleteBasket(basketVO Bvo, userVO Uvo, noticeVO Nvo) throws SQLException
	{
		try
		{
		String sql = "delete from basketTbl where (basketNumber = ?)"
				+ "and (userNumber = ?) and (noticeNumber = ?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Bvo.getBasketNumber());
		pstmt.setString(2, Uvo.getUserNumber());
		pstmt.setString(3,  Nvo.getNoticeNumber());
		
		pstmt.executeUpdate();
		pstmt.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public void disConnect() throws SQLException {
		if(rs != null) rs.close();
		if(rs != null) pstmt.close();
		if(rs != null) conn.close();
	}
}
