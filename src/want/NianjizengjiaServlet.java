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
		//1 ��ȡҳ�����
		String xueqiming = request.getParameter("xueqiming");
		//2�ж��꼶�Ƿ��ظ�
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
			info.add("���꼶�Ѵ��ڣ����������룡");
		}
		//3�ж��꼶����ĺϷ���
		if(xueqiming==null){
			info.add("�����꼶����Ϊ��");
		}
	
		if(info.size()==0){//4У��ͨ��
		
		try {//�����ݲ��뵽���ݿ���
			NianjizengjiaDAOProxy nianjizengjiaDAOProxy1 = new NianjizengjiaDAOProxy();
			Nianjizengjia nianjizengjia = new Nianjizengjia();			
			nianjizengjia.setXueqiming(xueqiming);
			nianjizengjiaDAOProxy1.addNianji(nianjizengjia);
			//Ϊ��תTitle.jsp׼������
			
			GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
			List<Grade> xueqiming1 = gradeDAOProxy.queryGrades();
			request.setAttribute("xueqiming", xueqiming1);
			//��תTitle.jspҳ��
			request.getRequestDispatcher("Title.jsp").forward(request,
					response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		}else{//У�鲻ͨ��
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
