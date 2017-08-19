package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KemuchengjiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String grade_id = request.getParameter("grade_id");
		String kemu_id = request.getParameter("kemu_id");
		String chengji1 = request.getParameter("chengji1");
		String chengji2 = request.getParameter("chengji2");
		
		int c1 = -1;
		if(chengji1 == null || "".equals(chengji1)){
			c1 = -1;
		}else{
			c1 = new Integer(chengji1).intValue();
		}
		
		int c2 = -1;
		if(chengji2 == null || "".equals(chengji2)){
			c2 = -1;
		}else{
			c2 = new Integer(chengji2).intValue();
		}

		ZonghechengjiDAOProxy zonghechengjiDAOProxy = new ZonghechengjiDAOProxy();

		try {
			// 对数据库进行操作
			
			//给跳转页面传递数据

			Kemuchengji kemuchengji = new Kemuchengji();
			kemuchengji.setGrade_id(new Integer(grade_id).intValue());
			kemuchengji.setKemu_id(new Integer(kemu_id).intValue());
			kemuchengji.setChengji1(c1);
			kemuchengji.setChengji2(c2);
			
			List<Zonghechengji> chengji = zonghechengjiDAOProxy
					.queryChengjis(kemuchengji);
			request.setAttribute("chengji", chengji);
			//跳转展示页面
			request.getRequestDispatcher("Kemuchengji.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
