package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNianjiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		//1.获取页面上传参数
		String xueqiming = request.getParameter("xueqiming");
		
		List<String> info = new ArrayList<String>();
		
		//判断输入的年级是否存在
		boolean name = true;
		DeleteNianjiDAOProxy deleteNianjiDAOProxy = new DeleteNianjiDAOProxy();
		DeleteNianji njsc = new DeleteNianji();
		njsc.setXueqiming(xueqiming);
		
		try {
			name = deleteNianjiDAOProxy.deleteNianji(njsc);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(name==false){
			info.add("输入年级不存在，无法删除");
		}
		
		
		//判断输入学期名的合法性
		if (xueqiming == null || "".equals(xueqiming)) {
			info.add("学期名不能为空");
		}
		
		if(info.size()== 0){//校验均通过
			
			//删除对应的学期名
			DeleteNianji njsc1 = new DeleteNianji();		
			njsc1.setXueqiming(xueqiming);
			
			try {
				deleteNianjiDAOProxy.deleteNianji(njsc1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//为跳转Title.jsp准备数据
			
			GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
			List<Grade> xueqiming1;
			try {
				xueqiming1 = gradeDAOProxy.queryGrades();
				request.setAttribute("xueqiming", xueqiming1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//跳转Title.jsp页面
			request.getRequestDispatcher("Title.jsp").forward(request,
					response);
			
			
		}else{//校验不通过
			request.setAttribute("info", info);
			request.getRequestDispatcher("DeleteNianji.jsp").forward(request,
					response);}
		
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
