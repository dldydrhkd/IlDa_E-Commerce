

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import mybean.db.userDAO;
import mybean.db.userVO;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		int userNumber = -1;
		
		try {
			userDAO db = userDAO.getInstance();
			userNumber = db.isLoginOk(id, pwd);
			db.disConnect();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(userNumber > -1) {
			out.print("<script>");
			out.print("alert('로그인이 되었습니다.')");
			out.print("</script>");
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("userNumber", userNumber);
//			response.sendRedirect("test.jsp");  // 나중에 main으로 바꿀거
		}
		else {
			out.print("<script>");
			out.print("alert('로그인 실패')");
			out.print("</script>");
//			response.sendRedirect("banner.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
