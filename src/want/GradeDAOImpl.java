package want;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeDAOImpl implements IGradeDAO {
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;// �������ݿ��������

	public GradeDAOImpl(Connection conn) { // �������ݿ�����
		this.conn = conn;
	}

	public List<Grade> queryGrades() throws Exception {
		List<Grade> grades = new ArrayList<Grade>();
		try {
			String sql = "select id,xueqiming from grade";
			pstmt = conn.prepareStatement(sql);// ʵ��������
			ResultSet rSet = pstmt.executeQuery();// ȡ�ý��
			while (rSet.next()) {
				Grade grade = new Grade();
				grade.setGradeid(rSet.getInt(1));
				grade.setXueqiming(rSet.getString(2));
				grades.add(grade);// 
			}

		} catch (Exception e) {
			throw e;
		} finally {
			// �رղ���
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}

		}
		return grades;
	}

}
