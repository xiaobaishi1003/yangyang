package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChengjixiugaiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		List<String> info = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		String[] grade_kemu_id = request.getParameterValues("grade_kemu_id");

		String[] newchengji = request.getParameterValues("newchengji");

		for (int i = 0; i < newchengji.length; i++) {

			String chengji = newchengji[i];

			ChengjixiugaiDAOProxy chengjixiugaiDAOProxy = new ChengjixiugaiDAOProxy();

			if (chengji == null || "".equals(chengji)) {
				continue;
			} else if (false == chengji.matches("[0-9]+")) {
				info.add("成绩必须为数字");
				continue;
			} else {
				int cj = new Integer(chengji).intValue();
				if (cj < 0 || cj > 200) {
					info.add("成绩必须大于等于0，小于等于200");
					continue;
				}

			}

			try {
				Chengjixiugai chengjixiugai = new Chengjixiugai();
				String[] grade_kemu = grade_kemu_id[i].split(",");
				int grade_id = new Integer(grade_kemu[0]).intValue();
				int kemu_id = new Integer(grade_kemu[1]).intValue();
				chengjixiugai.setGrade_id(grade_id);
				chengjixiugai.setKemu_id(kemu_id);
				chengjixiugai.setChengji(new Integer(chengji).intValue());
				boolean ret = chengjixiugaiDAOProxy.Chengjixiugai(chengjixiugai);
				
				/*if (ret) {
					List<Zonghechengji> chengji2 = null;
					ZonghechengjiDAOProxy zonghechengjiDAOProxy = new ZonghechengjiDAOProxy();

					try {
						chengji2 = zonghechengjiDAOProxy.queryChengji();
					} catch (Exception e) {
						e.printStackTrace();
					}
					request.setAttribute("chengji", chengji);
					request.getRequestDispatcher("Zonghechengji.jsp").forward(
							request, response);
				} else {
					List<Zonghechengji> chengji1 = null;
					ZonghechengjiDAOProxy zonghechengjiDAOProxy1 = new ZonghechengjiDAOProxy();
					try {
						chengji1 = zonghechengjiDAOProxy1.queryChengji();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					request.setAttribute("info", info);
					request.setAttribute("chengji", chengji1);
					request.getRequestDispatcher("Chengjixiugai.jsp").forward(
							request, response);
				}*/

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<Zonghechengji> chengji1 = null;
		ZonghechengjiDAOProxy ZonghechengjiDAOProxy1 = new ZonghechengjiDAOProxy();
		try {
			chengji1 = ZonghechengjiDAOProxy1.queryChengji();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.setAttribute("chengji", chengji1);
		request.getRequestDispatcher("Chengjixiugai.jsp").forward(request,
				response);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
