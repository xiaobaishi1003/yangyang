package want;

import java.util.ArrayList;
import java.util.List;

public class ZonghechengjiDAOProxy implements IZonghechengjiDAO {

	private DatabaseConnection dabc = null;// 定义数据库连接
	private ZonghechengjiDAOImpl dao = null;// 定义DAO接口

	public ZonghechengjiDAOProxy() {
		try {
			dabc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao = new ZonghechengjiDAOImpl(dabc.getConnection());
	}

	public List<String> queryZonghechengjis(Grade grade) throws Exception {
		List<String> zonghechengji = new ArrayList<String>();
		try {
			zonghechengji = dao.queryZonghechengjis(grade);
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return zonghechengji;
	}

	@Override
	public List<Zonghechengji> queryZonghechengjiss(Grade grade)
			throws Exception {
		List<Zonghechengji> zonghechengji = new ArrayList<Zonghechengji>();
		try {
			zonghechengji = dao.queryZonghechengjiss(grade);
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return zonghechengji;
	}
	
	public List<Zonghechengji> queryChengji() throws Exception{
		
		List<Zonghechengji> zonghechengji = new ArrayList<Zonghechengji>();
		try {
			zonghechengji = dao.queryChengji();
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return zonghechengji;
	}
	
	public List<Zonghechengji> queryChengjis(Kemuchengji kemuchengji) throws Exception{
		
		List<Zonghechengji> zonghechengji = new ArrayList<Zonghechengji>();
		
		try {
			zonghechengji = dao.queryChengjis(kemuchengji);
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return zonghechengji;
	}

}