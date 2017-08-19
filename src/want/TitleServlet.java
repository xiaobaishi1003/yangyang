package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
		KemuDAOProxy kemuDAOProxy = new KemuDAOProxy();
		try {
			List<Grade> xueqiming = gradeDAOProxy.queryGrades();
			List<Kemu> kemu = kemuDAOProxy.queryKemus();
			request.setAttribute("xueqiming", xueqiming) ;
			request.setAttribute("kemu",kemu);
			request.getRequestDispatcher("Chengjiluru.jsp").forward(request,
					response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
