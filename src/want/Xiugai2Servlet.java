package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xiugai2Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		DanyuanceshiDAOProxy danyuanceshiDAOProxy = new DanyuanceshiDAOProxy();
		
		try {
			
			List<Danyuanceshi> chengji = danyuanceshiDAOProxy.queryChengji();
			request.setAttribute("chengji",chengji);
			request.getRequestDispatcher("Chengjixiugai2.jsp").forward(request,
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
