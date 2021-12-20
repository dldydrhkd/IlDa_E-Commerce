

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.db.commentDAO;
import mybean.db.commentVO;

@WebServlet("/commentChangeServlet")
public class commentChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public commentChangeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String contents = request.getParameter("contents");
		int commentNumber = Integer.parseInt(request.getParameter("commentNumber"));
		
		try {
			commentDAO comment = commentDAO.getInstance();
			comment.updateRecord(new commentVO(contents, commentNumber, null));
			comment.disConnect();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
