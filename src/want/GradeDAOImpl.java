package want;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeDAOImpl implements IGradeDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库操作对象

	public GradeDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	public List<Grade> queryGrades() throws Exception {
		List<Grade> grades = new ArrayList<Grade>();
		try {
			String sql = "select id,xueqiming from grade";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			ResultSet rSet = pstmt.executeQuery();// 取得结果
			while (rSet.next()) {
				Grade grade = new Grade();
				grade.setGradeid(rSet.getInt(1));
				grade.setXueqiming(rSet.getString(2));
				grades.add(grade);// 
			}

		} catch (Exception e) {
			throw e;
		} finally {
			// 关闭操作
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
