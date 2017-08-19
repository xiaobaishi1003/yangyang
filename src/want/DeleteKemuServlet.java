package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteKemuServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		List<String> info = new ArrayList<String>();

		boolean name1 = true;
		DeleteKemuDAOProxy deleteKemuDAOProxy = new DeleteKemuDAOProxy();
		Kemu kmsc = new Kemu();
		kmsc.setName(name);

		try {
			name1 = deleteKemuDAOProxy.deleteKemu(kmsc);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (name1 == false) {
			info.add("输入课目不存在，无法删除");
		}
		if (name == null || "".equals(name)) {
			info.add("课目名称不能为空");
		}
		if (info.size() == 0) {

			try {
				deleteKemuDAOProxy.deleteKemu(kmsc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
			List<Grade> xueqiming1;
			try {
				xueqiming1 = gradeDAOProxy.queryGrades();
				request.setAttribute("xueqiming", xueqiming1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getRequestDispatcher("Title.jsp")
					.forward(request, response);

		} else {
			request.setAttribute("info", info);
			request.getRequestDispatcher("DeleteKemu.jsp").forward(request,
					response);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
