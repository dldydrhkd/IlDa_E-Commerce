

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

import mybean.db.commentDAO;
import mybean.db.commentVO;

@WebServlet("/commentListServlet")
public class commentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public commentListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		
		try {
			commentDAO comment = commentDAO.getInstance();
			List<commentVO> li = comment.listComment(noticeNumber);
//			comment.disConnect();
			RequestDispatcher rd = request.getRequestDispatcher("/basketList.jsp");
			request.setAttribute("commentList", li);
			rd.forward(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
