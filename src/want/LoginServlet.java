package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import want.User;
import want.UserDAOProxy;

;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		List<String> info = new ArrayList<String>();
		if (name == null || "".equals(name)) { // �û��������ʽ����
			info.add("�û�������Ϊ��");
			System.out.println("�û�������Ϊ��===" + new Date());
		}

		if (password == null || "".equals(password)) {// ���������ʽ����
			info.add("���벻��Ϊ��");
			System.out.println("���벻��Ϊ��");
		}
		if (info.size() == 0) {
			User user = new User();			
			user.setName(name);
			user.setPassword(password);
			UserDAOProxy userDAOProxy = new UserDAOProxy();
			GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
			try {

				if (userDAOProxy.findLogin(user)) {
					//У�黧��ͨ��
					// response.sendRedirect("Title.jsp");
					getServletConfig().getServletContext().setAttribute("name", name);//��name�е������ύ��name
					System.out.println("=====�û�������У��ͨ�����û����ǣ�"+name);
					//��ѯ���ݿ��е�ѧ����
					List<Grade> xueqiming = gradeDAOProxy.queryGrades();
					
					//��ѧ�������ݵ�titleҳ��
					request.setAttribute("xueqiming", xueqiming) ;
					//��ת��Titleҳ��
					request.getRequestDispatcher("Title.jsp").forward(request,
							response);// ��ת
				} else {
					//У�鲻ͨ��
					info.add("�û���¼ʧ�ܣ�������û���������");
					request.setAttribute("info", info);// ���������Ϣ
					request.getRequestDispatcher("Login.jsp").forward(request, response);// ��ת

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
		request.setAttribute("info", info);// ���������Ϣ
		request.getRequestDispatcher("Login.jsp").forward(request, response);// ��ת
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
