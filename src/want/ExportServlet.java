package want;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		response.setContentType("application/vnd.ms-excel");

		ZonghechengjiDAOProxy zonghechengjiDAOProxy = new ZonghechengjiDAOProxy();
		List<Zonghechengji> chengji1 = null;
		try {

			chengji1 = zonghechengjiDAOProxy.queryChengji();

		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletOutputStream out = response.getOutputStream(); // ��Ӧ���������
		HSSFWorkbook wb = new HSSFWorkbook(); // ����Excel���
		HSSFSheet sheet = wb.createSheet("�ۺϳɼ�"); // ����������
		// sheet.setColumnWidth(4, 5000); // �����п�

		HSSFRow titleRow = sheet.createRow(0); // ����Excel�еı�����,��1��
		HSSFCell titleCell1 = titleRow.createCell(0);
		titleCell1.setCellValue("��Ŀ����");
		HSSFCell titleCell2 = titleRow.createCell(1);
		titleCell2.setCellValue("�ɼ�");
		HSSFCell titleCell3 = titleRow.createCell(2);
		titleCell3.setCellValue("ͼƬ��ַ");
		HSSFCell titleCell4 = titleRow.createCell(3);
		titleCell4.setCellValue("��ע");

		for (int i = 0; i < chengji1.size(); i++) {
			HSSFRow valueRow = sheet.createRow(i + 1);
			HSSFCell nameCell = valueRow.createCell(0);
			nameCell.setCellValue(chengji1.get(i).getKemumingcheng());
			HSSFCell pwdCell = valueRow.createCell(1);
			pwdCell.setCellValue(chengji1.get(i).getChengji());
			HSSFCell sexCell = valueRow.createCell(2);
			sexCell.setCellValue(chengji1.get(i).getTupian());
			HSSFCell ageCell = valueRow.createCell(3);
			ageCell.setCellValue(chengji1.get(i).getBeizhu());
		}

		wb.write(out); // ����Ӧ�����뵽Excel�����
		out.flush();

	}

}
