

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.db.basketDAO;

@WebServlet("/basketDeleteServlet")
public class basketDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public basketDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int basketNumber = Integer.parseInt(request.getParameter("basketNumber"));
		
		try {
			basketDAO basket = basketDAO.getInstance();
			basket.deleteBasket(basketNumber);
//			basket.disConnect();
			response.sendRedirect("MainPage.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
