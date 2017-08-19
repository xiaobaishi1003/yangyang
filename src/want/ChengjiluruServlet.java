package want;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.DiskFileUpload;
import org.hibernate.validator.util.GetConstructor;

import java.io.File;

public class ChengjiluruServlet extends HttpServlet {
	/**
	 * 成绩录入服务
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		// 创建diskFileUpload对象
		DiskFileUpload disk = new DiskFileUpload();

		// 将上传内容该为UTF-8,gb2312,gbk
		disk.setHeaderEncoding("utf-8");

		// 创建缓冲临时文件夹
		File file = new File("d:/temp");
		if (!file.exists()) {
			file.mkdir();
		}

		// 设置缓冲临时文件位置
		disk.setRepositoryPath("d:/temp");

		// 设置临时文件的大小
		disk.setSizeThreshold(1024*10);

		// 设置上传文件的大小
		disk.setSizeMax(1024 * 1024 * 10);

		// 使用diskFileUpload对象读取请求对象中包含的输入流
		List<FileItem> list = null;
		try {
			list = disk.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String grade_id = null;
		String kemu_id = null;
		String chengji = null;
		String tupian = null;
		String beizhu = null;

		// 遍历表单中的文件对象集合
		for (FileItem item : list) {
			// 获取元素的name属性
			System.out.println(item.getFieldName());
			// 获取文件域选择文件的路径值
			System.out.println(item.getName());
			// 获取长度
			System.out.println(item.getSize());
			// 获取文本形式的值
			//System.out.println(item.getString());

			// 判断每个文件是否是上传文件
			if (item.isFormField()) {
				// 非上传内容

				if ("grade_id".equalsIgnoreCase(item.getFieldName())) {
					grade_id = item.getString();
				} else if ("kemu_id".equalsIgnoreCase(item.getFieldName())) {
					kemu_id = item.getString();
				} else if ("chengji".equalsIgnoreCase(item.getFieldName())) {
					chengji = item.getString();
				} else if ("beizhu".equalsIgnoreCase(item.getFieldName())) {
					beizhu = item.getString();
				}

			} else {
				// 上传内容
						
				// 获取上传文件的输入流
				InputStream input = item.getInputStream();

				// 获取上传文件的文件名
				String fileName = item.getName().substring(
						item.getName().lastIndexOf("\\") + 1);

				// 获取服务器的路径
				String path = this.getServletContext().getRealPath("");

				System.out.println(path);

				path += "\\upload\\";
				File file1 = new File(path);
				if (!file1.exists()) {
					file1.mkdir();
				}

				path += fileName;

				tupian = path;

				try {

					item.write(new File(path));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// 1.获取页面上传参数
		// String grade_id = request.getParameter("grade_id");
		// String kemu_id = request.getParameter("kemu_id");
		// String chengji = request.getParameter("chengji");
		// String tupian = request.getParameter("tupian");
		// String beizhu = request.getParameter("beizhu");

		// 2.判断输入的年级、课目是否有重复
		KemuDAOProxy kemuDAOProxy = new KemuDAOProxy();
		List<String> info = new ArrayList<String>();
		ZonghechengjiDAOProxy zonghechengjiDAOProxy = new ZonghechengjiDAOProxy();
		ChengjiluruProxy chengjiluruDAOProxy = new ChengjiluruProxy();
		boolean kemuid = false;
		Zonghechengji zhcj = new Zonghechengji();
		zhcj.setKemu_id(new Integer(kemu_id).intValue());
		zhcj.setGrade_id(new Integer(grade_id).intValue());
		try {
			kemuid = kemuDAOProxy.findKemu(zhcj);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (kemuid == true) {
			info.add("该课目已有成绩，请确认课目名称后再输入");
		}

		// 3.判断成绩输入项合法性
		if (chengji == null || "".equals(chengji)) {
			info.add("成绩不能为空");
		} else if (false == chengji.matches("[0-9]+")) {
			info.add("成绩必须为数字");
		} else {

			int cj = new Integer(chengji).intValue();
			if (cj < 0 || cj > 200) {
				info.add("成绩必须大于等于0，小于等于200");
			}

		}
		if (info.size() == 0) {// 4.1校验均通过
			try {

				// 4.1.1插入数据到成绩表
				Chengjiluru cjlr = new Chengjiluru();
				cjlr.setGrade_id(Integer.parseInt(grade_id));
				// System.out.println(grade_id);
				cjlr.setKemu_id(Integer.parseInt(kemu_id));
				cjlr.setChengji(Integer.parseInt(chengji));
				cjlr.setBeizhu(beizhu);
				cjlr.setTupian(tupian);

				chengjiluruDAOProxy.addChengjiluru(cjlr);

				// 4.1.2为跳转zonghechengji.jsp准备数据
				Grade grade = new Grade();
				grade.setGradeid(new Integer(grade_id).intValue());
				List<Zonghechengji> chengji2 = zonghechengjiDAOProxy
						.queryZonghechengjiss(grade);
				request.setAttribute("chengji", chengji2);
				// request.setAttribute("chengji", chengji1);

				// 4.1.3跳转到zonghechengji.jsp页面
				request.getRequestDispatcher("Zonghechengji.jsp").forward(
						request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// 4.2校验未通过

			// 4.2.1为跳转chengjiluru.jsp准备数据
			List<Grade> xueqiming = null;
			List<Kemu> kemu = null;
			KemuDAOProxy kemuDAOProxy1 = new KemuDAOProxy();
			GradeDAOProxy gradeDAOProxy1 = new GradeDAOProxy();
			try {
				xueqiming = gradeDAOProxy1.queryGrades();
				kemu = kemuDAOProxy1.queryKemus();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("info", info);
			request.setAttribute("xueqiming", xueqiming);
			request.setAttribute("kemu", kemu);

			// 4.2.2跳转chengjiluru。jsp页面
			request.getRequestDispatcher("Chengjiluru.jsp").forward(request,
					response);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
