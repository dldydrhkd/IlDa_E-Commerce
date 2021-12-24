

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.db.basketDAO;
import mybean.db.basketVO;

@WebServlet("/basketAddServlet")
public class basketAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public basketAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		int userNumber = (int) session.getAttribute("userNumber");
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		try {
			basketDAO basket = basketDAO.getInstance();
			basket.insertBasket(new basketVO(userNumber, noticeNumber));
//			basket.disConnect();
			response.sendRedirect("listBasketServlet");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
