import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.db.userDAO;


public class memberIdCheck implements Action
{
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		userDAO dao = userDAO.getInstance();
		
		boolean result = dao.duplicateIdCheck(id);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		if(result)	out.println("0");
		else		out.println("1");
		
		System.out.println(result);
		
		out.close();
		
		return null;
	}
}
