package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DanyuanceshiServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanyuanceshiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		
		String grade_id = request.getParameter("grade_id");
		
		DanyuanceshiDAOProxy danyuanceshiDAOProxy = new DanyuanceshiDAOProxy();
		try{
			request.setAttribute("grade_id",grade_id);
			Grade grade = new Grade();
			grade.setGradeid(new Integer(grade_id).intValue());
			
			List<Danyuanceshi> chengji = danyuanceshiDAOProxy.queryDanyuanceshi(grade);
			request.setAttribute("chengji", chengji);
			request.getRequestDispatcher("Danyuanceshi.jsp").forward(request,
					response);		
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
		
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}
	

}
