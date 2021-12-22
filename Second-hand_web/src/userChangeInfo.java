

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
import mybean.db.userVO;

@WebServlet("/userChangeInfo")
public class userChangeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public userChangeInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String pwd = request.getParameter("pwd1");
		String name = request.getParameter("name");
		String userPhoneNumber = request.getParameter("phone");
		String userAddr = request.getParameter("address");
		String userEmail = request.getParameter("email");

		
		userVO usr = new userVO();
		usr.setUserId(id);
		usr.setUserName(name);
		usr.setUserPwd(pwd);
		usr.setUserPhoneNumber(userPhoneNumber);
		usr.setUserAddr(userAddr);
		usr.setUserEmail(userEmail);
		
		try {
			userDAO db = userDAO.getInstance();
			db.updateRecord(usr);
//			db.disConnect();
			response.sendRedirect("MainPage.jsp");
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
