package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NianjizengjiaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//1 获取页面参数
		String xueqiming = request.getParameter("xueqiming");
		//2判断年级是否重复
		NianjizengjiaDAOProxy nianjizengjiaDAOProxy = new NianjizengjiaDAOProxy();
		
		List<String> info = new ArrayList<String>();
		Grade grade = new Grade();
		grade.setXueqiming(xueqiming);
		
		boolean name = false ;
		Nianjizengjia njzj = new Nianjizengjia();
		njzj.setXueqiming(xueqiming);
		try {
			name = nianjizengjiaDAOProxy.addNianjis(njzj);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(name == true){
			info.add("该年级已存在，请重新输入！");
		}
		//3判断年级输入的合法性
		if(xueqiming==null){
			info.add("增加年级不能为空");
		}
	
		if(info.size()==0){//4校验通过
		
		try {//将数据插入到数据库中
			NianjizengjiaDAOProxy nianjizengjiaDAOProxy1 = new NianjizengjiaDAOProxy();
			Nianjizengjia nianjizengjia = new Nianjizengjia();			
			nianjizengjia.setXueqiming(xueqiming);
			nianjizengjiaDAOProxy1.addNianji(nianjizengjia);
			//为跳转Title.jsp准备数据
			
			GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
			List<Grade> xueqiming1 = gradeDAOProxy.queryGrades();
			request.setAttribute("xueqiming", xueqiming1);
			//跳转Title.jsp页面
			request.getRequestDispatcher("Title.jsp").forward(request,
					response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		}else{//校验不通过
			request.setAttribute("info", info);
			request.getRequestDispatcher("Nianjizengjia.jsp").forward(request,
					response);
		}
	}
	
	
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
