package want;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Chengjiluru2Servlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	String grade_id = request.getParameter("grade_id");
	String kemu_id = request.getParameter("kemu_id");	
	String danyuan = request.getParameter("danyuan");
	String juanmian = request.getParameter("juanmian");
	String beisong = request.getParameter("beisong");
	String xiehua = request.getParameter("xiehua");

	List<String> info = new ArrayList<String>();
	ChengjiluruProxy chengjiluruDAOProxy = new ChengjiluruProxy();
	
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
	if (info.size() == 0) {
		try {


			Chengjiluru cjlr = new Chengjiluru();
			cjlr.setGrade_id(Integer.parseInt(grade_id));
			cjlr.setKemu_id(Integer.parseInt(kemu_id));
			cjlr.setDanyuan(Integer.parseInt(danyuan));
			cjlr.setJuanmian(Integer.parseInt(juanmian));
			cjlr.setBeisong(Integer.parseInt(beisong));
			cjlr.setXiehua(Integer.parseInt(xiehua));
			

			chengjiluruDAOProxy.addChengjiluru2(cjlr);

			Grade grade = new Grade();
			grade.setGradeid(new Integer(grade_id).intValue());
			DanyuanceshiDAOProxy danyuanceshiDAOProxy = new DanyuanceshiDAOProxy();
			List<Danyuanceshi> chengji2 = danyuanceshiDAOProxy
					.queryDanyuanceshi(grade);
			request.setAttribute("chengji", chengji2);


			request.getRequestDispatcher("Danyuanceshi.jsp").forward(
					request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} else {
		
		List<Danyuanceshi> chengji = null;

		DanyuanceshiDAOProxy danyuanceshiDAOProxy1 = new DanyuanceshiDAOProxy();
		try {
			chengji = danyuanceshiDAOProxy1.queryChengji();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("info", info);
		request.setAttribute("chengji", chengji);
		
		request.getRequestDispatcher("Chengjiluru2.jsp").forward(request,
				response);
		
	}
	
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
}
