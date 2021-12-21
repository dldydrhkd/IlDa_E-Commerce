

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.db.noticeDAO;
import mybean.db.noticeVO;


@WebServlet("/noticeRecentViewServlet")
public class noticeRecentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public noticeRecentViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		int userNumber = (int) session.getAttribute("userNumber");
		try {
			noticeDAO notice = noticeDAO.getInstance();
			noticeVO n = notice.getRecentNotice(userNumber);
//			notice.disConnect();
			RequestDispatcher rd = request.getRequestDispatcher("noticeView.jsp");
			request.setAttribute("notice", n);
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}