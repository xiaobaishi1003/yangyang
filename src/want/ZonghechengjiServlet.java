package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import want.Zonghechengji;
import want.ZonghechengjiDAOProxy;

public class ZonghechengjiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ZonghechengjiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String grade_id = request.getParameter("grade_id");
		//String chengji = request.getParameter("chengji");
		
		//System.out.println(chengji);
		
		ZonghechengjiDAOProxy zonghechengjiDAOProxy = new ZonghechengjiDAOProxy();
		try {
			request.setAttribute("grade_id", grade_id);
			//request.setAttribute("chengji", chengji);
			Grade grade = new Grade();
			grade.setGradeid(new Integer(grade_id).intValue());
			
//			Zonghechengji zhcj = new Zonghechengji();
//			zhcj.setChengji(new Integer(chengji).intValue());
			
			List<Zonghechengji> chengji1 = zonghechengjiDAOProxy.queryZonghechengjiss(grade);
			request.setAttribute("chengji", chengji1);
			request.getRequestDispatcher("Zonghechengji.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
