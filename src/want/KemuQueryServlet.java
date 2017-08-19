/**
 * 
 */
package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author want
 *
 */
public class KemuQueryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
		KemuDAOProxy kemuDAOProxy = new KemuDAOProxy();
		
		try {
			List<Grade> xueqiming = gradeDAOProxy.queryGrades();
			List<Kemu> kemu = kemuDAOProxy.queryKemus();
			
			request.setAttribute("xueqiming", xueqiming) ;
			request.setAttribute("kemu",kemu);
			request.getRequestDispatcher("Kemu.jsp").forward(request,
					response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
