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
		// 1 ��ȡҳ�����
		String name = request.getParameter("kemu");

		List<String> info = new ArrayList<String>();

		// 2�жϿ�Ŀ����ĺϷ���

		if (name == null) {
			info.add("�����Ŀ����Ϊ��");
		}

		// 3�ж��꼶�Ƿ��ظ�
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
			info.add("�ÿ�Ŀ�Ѵ��ڣ����������룡");
		}

		if (info.size() == 0) {// У��ͨ��

			try {
				// ��������Ŀ���ݲ��뵽���ݿ���
				AddKemu kemuzengjia = new AddKemu();
				kemuzengjia.setName(name);
				addKemuDAOProxy.addKemu(kemuzengjia);

				// Ϊ��תTitle.jsp׼������

				GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
				List<Grade> xueqiming = gradeDAOProxy.queryGrades();
				request.setAttribute("xueqiming", xueqiming);
				request.setAttribute("name", name);
				// ��תTitle.jspҳ��
				request.getRequestDispatcher("Title.jsp").forward(request,
						response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {// У�鲻ͨ��
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
