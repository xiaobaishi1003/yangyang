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
		if (name == null || "".equals(name)) { // 用户名输入格式问题
			info.add("用户名不能为空");
			System.out.println("用户名不能为空===" + new Date());
		}

		if (password == null || "".equals(password)) {// 密码输入格式问题
			info.add("密码不能为空");
			System.out.println("密码不能为空");
		}
		if (info.size() == 0) {
			User user = new User();			
			user.setName(name);
			user.setPassword(password);
			UserDAOProxy userDAOProxy = new UserDAOProxy();
			GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
			try {

				if (userDAOProxy.findLogin(user)) {
					//校验户名通过
					// response.sendRedirect("Title.jsp");
					getServletConfig().getServletContext().setAttribute("name", name);//把name中的数据提交给name
					System.out.println("=====用户名密码校验通过，用户名是："+name);
					//查询数据库中的学期名
					List<Grade> xueqiming = gradeDAOProxy.queryGrades();
					
					//把学期名传递到title页面
					request.setAttribute("xueqiming", xueqiming) ;
					//跳转到Title页面
					request.getRequestDispatcher("Title.jsp").forward(request,
							response);// 跳转
				} else {
					//校验不通过
					info.add("用户登录失败，错误的用户名和密码");
					request.setAttribute("info", info);// 保存错误信息
					request.getRequestDispatcher("Login.jsp").forward(request, response);// 跳转

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
		request.setAttribute("info", info);// 保存错误信息
		request.getRequestDispatcher("Login.jsp").forward(request, response);// 跳转
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
