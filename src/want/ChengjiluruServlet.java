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
	 * �ɼ�¼�����
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		// ����diskFileUpload����
		DiskFileUpload disk = new DiskFileUpload();

		// ���ϴ����ݸ�ΪUTF-8,gb2312,gbk
		disk.setHeaderEncoding("utf-8");

		// ����������ʱ�ļ���
		File file = new File("d:/temp");
		if (!file.exists()) {
			file.mkdir();
		}

		// ���û�����ʱ�ļ�λ��
		disk.setRepositoryPath("d:/temp");

		// ������ʱ�ļ��Ĵ�С
		disk.setSizeThreshold(1024*10);

		// �����ϴ��ļ��Ĵ�С
		disk.setSizeMax(1024 * 1024 * 10);

		// ʹ��diskFileUpload�����ȡ��������а�����������
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

		// �������е��ļ����󼯺�
		for (FileItem item : list) {
			// ��ȡԪ�ص�name����
			System.out.println(item.getFieldName());
			// ��ȡ�ļ���ѡ���ļ���·��ֵ
			System.out.println(item.getName());
			// ��ȡ����
			System.out.println(item.getSize());
			// ��ȡ�ı���ʽ��ֵ
			//System.out.println(item.getString());

			// �ж�ÿ���ļ��Ƿ����ϴ��ļ�
			if (item.isFormField()) {
				// ���ϴ�����

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
				// �ϴ�����
						
				// ��ȡ�ϴ��ļ���������
				InputStream input = item.getInputStream();

				// ��ȡ�ϴ��ļ����ļ���
				String fileName = item.getName().substring(
						item.getName().lastIndexOf("\\") + 1);

				// ��ȡ��������·��
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
		// 1.��ȡҳ���ϴ�����
		// String grade_id = request.getParameter("grade_id");
		// String kemu_id = request.getParameter("kemu_id");
		// String chengji = request.getParameter("chengji");
		// String tupian = request.getParameter("tupian");
		// String beizhu = request.getParameter("beizhu");

		// 2.�ж�������꼶����Ŀ�Ƿ����ظ�
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
			info.add("�ÿ�Ŀ���гɼ�����ȷ�Ͽ�Ŀ���ƺ�������");
		}

		// 3.�жϳɼ�������Ϸ���
		if (chengji == null || "".equals(chengji)) {
			info.add("�ɼ�����Ϊ��");
		} else if (false == chengji.matches("[0-9]+")) {
			info.add("�ɼ�����Ϊ����");
		} else {

			int cj = new Integer(chengji).intValue();
			if (cj < 0 || cj > 200) {
				info.add("�ɼ�������ڵ���0��С�ڵ���200");
			}

		}
		if (info.size() == 0) {// 4.1У���ͨ��
			try {

				// 4.1.1�������ݵ��ɼ���
				Chengjiluru cjlr = new Chengjiluru();
				cjlr.setGrade_id(Integer.parseInt(grade_id));
				// System.out.println(grade_id);
				cjlr.setKemu_id(Integer.parseInt(kemu_id));
				cjlr.setChengji(Integer.parseInt(chengji));
				cjlr.setBeizhu(beizhu);
				cjlr.setTupian(tupian);

				chengjiluruDAOProxy.addChengjiluru(cjlr);

				// 4.1.2Ϊ��תzonghechengji.jsp׼������
				Grade grade = new Grade();
				grade.setGradeid(new Integer(grade_id).intValue());
				List<Zonghechengji> chengji2 = zonghechengjiDAOProxy
						.queryZonghechengjiss(grade);
				request.setAttribute("chengji", chengji2);
				// request.setAttribute("chengji", chengji1);

				// 4.1.3��ת��zonghechengji.jspҳ��
				request.getRequestDispatcher("Zonghechengji.jsp").forward(
						request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// 4.2У��δͨ��

			// 4.2.1Ϊ��תchengjiluru.jsp׼������
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

			// 4.2.2��תchengjiluru��jspҳ��
			request.getRequestDispatcher("Chengjiluru.jsp").forward(request,
					response);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
