

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		System.out.println(path);
		
		int maxsize = 1024*1024*5;
		
		String fileName = null;
		String originalFileName = null;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, maxsize, "utf-8", new DefaultFileRenamePolicy());;
			
			Enumeration<?> files = multi.getFileNames();
			String str = (String)files.nextElement();
			
			fileName = multi.getFilesystemName(str);
			originalFileName = multi.getOriginalFileName(str);
		
			String title = multi.getParameter("title");
			String info = multi.getParameter("content");
			String classification = multi.getParameter("noticeClassification");
			int price = Integer.parseInt(multi.getParameter("price"));
			HttpSession session = request.getSession();
			int userNumber = (int) session.getAttribute("userNumber");
			noticeVO n = new noticeVO(title, info, classification, userNumber, originalFileName, fileName, price);
			noticeDAO notice = noticeDAO.getInstance();
			notice.insertRecord(n);
			notice.disConnect();
			response.sendRedirect("MainPage.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}