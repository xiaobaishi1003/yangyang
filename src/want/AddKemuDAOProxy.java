package want;

import java.util.ArrayList;
import java.util.List;

public class AddKemuDAOProxy implements IAddKemu{
	private DatabaseConnection dabc = null;// �������ݿ�����
	private AddKemuDAOImpl dao = null;// ����DAO�ӿ�

	public AddKemuDAOProxy() {
		try {
			dabc = new DatabaseConnection();// ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao = new AddKemuDAOImpl(dabc.getConnection());
	}
	public List<String> addKemu(AddKemu kmzj) throws Exception{
		
		List<String> kemuzengjia = new ArrayList<String>();
		try {
			kemuzengjia = dao.addKemu(kmzj);
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return kemuzengjia;
	}
	
	public boolean addKemus(AddKemu kmzj)throws Exception{
		
		boolean flag=false;
		try {
			flag=dao.addKemus(kmzj);
		} catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return flag;
	}
	
}
