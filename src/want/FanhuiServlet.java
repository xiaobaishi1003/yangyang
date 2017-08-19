package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FanhuiServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//String name = userDAOProxy.findLogin(user);
		GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
		List<Grade> xueqiming;
		try {
			xueqiming = gradeDAOProxy.queryGrades();
			request.setAttribute("xueqiming", xueqiming);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Title.jsp").forward(request,
				response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
