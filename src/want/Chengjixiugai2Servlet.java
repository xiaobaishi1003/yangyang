package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Chengjixiugai2Servlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String juanmian = request.getParameter("juanmian");
		String xiehua = request.getParameter("xiehua");
		String beisong = request.getParameter("beisong");
		
		ChengjixiugaiDAOProxy chengjixiugaiDAOProxy = new ChengjixiugaiDAOProxy();
		
		List<String> info = new ArrayList<String>();
		
		if (juanmian == null || "".equals(juanmian)) {
			info.add("卷面成绩不能为空");
		} else if (false == juanmian.matches("[0-9]+")) {
			info.add("卷面成绩必须为数字");
		} else {
			int cj = new Integer(juanmian).intValue();
			if (cj < 0 || cj > 200) {
				info.add("卷面成绩必须大于等于0，小于等于200");
			}

		}
		if (xiehua == null || "".equals(xiehua)) {
			info.add("写话成绩不能为空");
		} else if (false == xiehua.matches("[0-9]+")) {
			info.add("写话成绩必须为数字");
		} else {
			int cj = new Integer(xiehua).intValue();
			if (cj < 0 || cj > 200) {
				info.add("写话成绩必须大于等于0，小于等于200");
			}

		}
		if (beisong == null || "".equals(beisong)) {
			info.add("背诵成绩不能为空");
		} else if (false == beisong.matches("[0-9]+")) {
			info.add("背诵成绩必须为数字");
		} else {
			int cj = new Integer(beisong).intValue();
			if (cj < 0 || cj > 200) {
				info.add("背诵成绩必须大于等于0，小于等于200");
			}

		}
		
		try {
			Chengjixiugai chengjixiugai = new Chengjixiugai();
			chengjixiugai.getChengji();
			if (chengjixiugaiDAOProxy.Chengjixiugai1(chengjixiugai)) {
				request.setAttribute("juanmian", juanmian);
				request.setAttribute("xiehua",xiehua);
				request.setAttribute("beisong",beisong);
				request.getRequestDispatcher("Danyuanceshi.jsp").forward(request,
						response);
			} else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

}
