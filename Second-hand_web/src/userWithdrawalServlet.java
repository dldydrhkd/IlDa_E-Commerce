

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.db.userDAO;

@WebServlet("/userWithdrawalServlet")
public class userWithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userWithdrawalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pwd = request.getParameter("pwd");
		
		try {
			userDAO db = userDAO.getInstance();
			boolean check = db.isPwdOk(id, pwd);
			if(check) {
				db.deleteRecord(id);
				db.disConnect();
				session.invalidate();
				response.sendRedirect("MainPage.jsp");
			}
			else {
				out.print("<script>");
				out.print("alert('회원 탈퇴 되었습니다.')");
				out.print("</script>");
				response.sendRedirect("Edit.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
