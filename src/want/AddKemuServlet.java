package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddKemuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1 获取页面参数
		String name = request.getParameter("kemu");

		List<String> info = new ArrayList<String>();

		// 2判断课目输入的合法性

		if (name == null) {
			info.add("输入课目不能为空");
		}

		// 3判断年级是否重复
		AddKemuDAOProxy addKemuDAOProxy = new AddKemuDAOProxy();
		Kemu kemu = new Kemu();
		kemu.setName(name);
		boolean name1 = false;

		AddKemu kmzj = new AddKemu();
		kmzj.setName(name);
		try {
			name1 = addKemuDAOProxy.addKemus(kmzj);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (name1 == true) {
			info.add("该课目已存在，请重新输入！");
		}

		if (info.size() == 0) {// 校验通过

			try {
				// 将新增课目数据插入到数据库中
				AddKemu kemuzengjia = new AddKemu();
				kemuzengjia.setName(name);
				addKemuDAOProxy.addKemu(kemuzengjia);

				// 为跳转Title.jsp准备数据

				GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
				List<Grade> xueqiming = gradeDAOProxy.queryGrades();
				request.setAttribute("xueqiming", xueqiming);
				request.setAttribute("name", name);
				// 跳转Title.jsp页面
				request.getRequestDispatcher("Title.jsp").forward(request,
						response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {// 校验不通过
			request.setAttribute("info", info);
			request.getRequestDispatcher("AddKemu.jsp").forward(request,
					response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
