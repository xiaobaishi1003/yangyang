package want;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanyuanceshiDAOImpl implements IDanyuanceshiDAO {

	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库操作对象

	public DanyuanceshiDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}

	public List<Danyuanceshi> queryDanyuanceshi(Grade grade) throws Exception {
		List<Danyuanceshi> danyuanceshi = new ArrayList<Danyuanceshi>();
		try {
			String sql = "select kemu.name,danyuanceshi.danyuan,danyuanceshi.juanmian,danyuanceshi.xiehua,danyuanceshi.beisong from kemu,danyuanceshi where danyuanceshi.kemu_id=kemu.id and danyuanceshi.grade_id = ?";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			pstmt.setInt(1, grade.getGradeid());
			ResultSet rSet = pstmt.executeQuery();// 取得结果
			while (rSet.next()) {
				Danyuanceshi d = new Danyuanceshi();
				
				d.setName(rSet.getString(1));
				d.setDanyuan(rSet.getInt(2));
				d.setJuanmian(rSet.getInt(3));
				d.setXiehua(rSet.getInt(4));
				d.setBeisong(rSet.getInt(5));
				danyuanceshi.add(d);
			
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
		return danyuanceshi;
	}
	
	public List<Danyuanceshi> queryChengji() throws Exception {
		List<Danyuanceshi> danyuanceshi = new ArrayList<Danyuanceshi>();
		try {
			String sql = "select grade.xueqiming,kemu.name,danyuanceshi.danyuan,danyuanceshi.juanmian,danyuanceshi.xiehua,danyuanceshi.beisong from kemu,danyuanceshi,grade where danyuanceshi.grade_id=grade.id and danyuanceshi.kemu_id=kemu.id";
			pstmt = conn.prepareStatement(sql);// 实例化操作
			ResultSet rSet = pstmt.executeQuery();// 取得结果
			while (rSet.next()) {
				Danyuanceshi d = new Danyuanceshi();
				d.setXueqiming(rSet.getString(1));
				d.setName(rSet.getString(2));
				d.setDanyuan(rSet.getInt(3));
				d.setJuanmian(rSet.getInt(4));
				d.setXiehua(rSet.getInt(5));
				d.setBeisong(rSet.getInt(6));
				danyuanceshi.add(d);
			
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
		return danyuanceshi;
	}
	
		
}
