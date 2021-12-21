

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.db.noticeDAO;
import mybean.db.noticeVO;


@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String question = request.getParameter("Search");
		
		try {
			noticeDAO notice = noticeDAO.getInstance();
			List<noticeVO> li = notice.listNotice();
			List<noticeVO> search = new ArrayList();
			for(noticeVO i : li) {
				if(i.getNoticeTitle().contains(question)) {
					search.add(i);
				}
			}
//			notice.disConnect();
			request.setAttribute("noticeList", search);
			request.setAttribute("isSearch", "1");
			RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp");
			rd.forward(request,response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
