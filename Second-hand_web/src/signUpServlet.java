

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signUpServlet
 */
@WebServlet("/signUpServlet")
public class signUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public signUpServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		User usr = new User();
		usr.setId(id);
		usr.setName(name);
		usr.setPwd(pwd);
		try {
			userDB db = new userDB();
			db.insertRecord(usr);
			db.close();
		}catch(NamingException e) {
			out.print(e);
			return
		}catch(SQLException e) {
			out.print(e);
			return;
		}
		PrintWriter out = response.getWriter();
		out.print("alert('회원가입이 성공적으로 되셨습니다.')");
		response.sendRedirect("userLogin.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
