package want;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChengjixiugaiDAOImpl implements IChengjixiugaiDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ChengjixiugaiDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean Chengjixiugai(Chengjixiugai cjxg) throws Exception {
		boolean flag = false;

		try {

			String sql = "update zonghechengji set chengji = ? where kemu_id = ? and grade_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cjxg.getChengji());
			pstmt.setInt(2, cjxg.getKemu_id());
			pstmt.setInt(3, cjxg.getGrade_id());
			pstmt.executeUpdate();
			// ResultSet rSet=pstmt.executeQuery();//取的结果集
			// if(rSet.next()){
			// cjxg.setChengji(rSet.getInt(1));
			// flag=true;
			// }
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
		return flag;

	}

	public boolean Chengjixiugai1(Chengjixiugai cjxg) throws Exception {
		boolean flag = false;
		try {

			String sql = "update danyuanceshi set juanmian = ? and xiehua=? and beisong = ? where kemu_id = ? and grade_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cjxg.getChengji());
			pstmt.setInt(2, cjxg.getKemu_id());
			pstmt.setInt(3, cjxg.getGrade_id());
			pstmt.executeUpdate();
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
		return flag;

	}

}
