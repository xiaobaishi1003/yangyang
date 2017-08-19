package want;

import java.util.ArrayList;
import java.util.List;

public class DanyuanceshiDAOProxy implements IDanyuanceshiDAO {

	private DatabaseConnection dabc = null;// 定义数据库连接
	private DanyuanceshiDAOImpl dao = null;// 定义DAO接口

	public DanyuanceshiDAOProxy() {
		try {
			dabc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao = new DanyuanceshiDAOImpl(dabc.getConnection());
	}

	public List<Danyuanceshi> queryDanyuanceshi(Grade grade) throws Exception {

		List<Danyuanceshi> danyuanceshi = new ArrayList<Danyuanceshi>();

		try {
			danyuanceshi = dao.queryDanyuanceshi(grade);
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return danyuanceshi;
	}
	public List<Danyuanceshi> queryChengji() throws Exception{
		
		List<Danyuanceshi> danyuanceshi = new ArrayList<Danyuanceshi>();
		
		try {
			danyuanceshi = dao.queryChengji();
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return danyuanceshi;
		
	}

}
