

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.db.noticeDAO;
import mybean.db.noticeVO;


@WebServlet("/writeServlet")
public class writeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public writeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String title = request.getParameter("title");
		String info = request.getParameter("content");
		String state = null;
		String classification = request.getParameter("noticeClassification");
		String image = request.getParameter("image");
		HttpSession session = request.getSession();
		int userNumber = (int) session.getAttribute("userNumber");
		
		noticeVO n = new noticeVO(title, info, state, classification, userNumber, image);
		
		try {
			noticeDAO notice = noticeDAO.getInstance();
			notice.insertRecord(n);
			notice.disConnect();
			response.sendRedirect("noticeList.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}