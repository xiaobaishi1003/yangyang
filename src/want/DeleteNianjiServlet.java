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
		
		//1.��ȡҳ���ϴ�����
		String xueqiming = request.getParameter("xueqiming");
		
		List<String> info = new ArrayList<String>();
		
		//�ж�������꼶�Ƿ����
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
			info.add("�����꼶�����ڣ��޷�ɾ��");
		}
		
		
		//�ж�����ѧ�����ĺϷ���
		if (xueqiming == null || "".equals(xueqiming)) {
			info.add("ѧ��������Ϊ��");
		}
		
		if(info.size()== 0){//У���ͨ��
			
			//ɾ����Ӧ��ѧ����
			DeleteNianji njsc1 = new DeleteNianji();		
			njsc1.setXueqiming(xueqiming);
			
			try {
				deleteNianjiDAOProxy.deleteNianji(njsc1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Ϊ��תTitle.jsp׼������
			
			GradeDAOProxy gradeDAOProxy = new GradeDAOProxy();
			List<Grade> xueqiming1;
			try {
				xueqiming1 = gradeDAOProxy.queryGrades();
				request.setAttribute("xueqiming", xueqiming1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��תTitle.jspҳ��
			request.getRequestDispatcher("Title.jsp").forward(request,
					response);
			
			
		}else{//У�鲻ͨ��
			request.setAttribute("info", info);
			request.getRequestDispatcher("DeleteNianji.jsp").forward(request,
					response);}
		
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
