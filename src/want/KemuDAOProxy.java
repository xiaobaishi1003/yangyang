package want;

import java.util.ArrayList;
import java.util.List;

public class KemuDAOProxy implements IkemuDAO{

	private DatabaseConnection dabc=null;//定义数据库连接
    private KemuDAOImpl dao=null;//定义DAO接口
    public KemuDAOProxy(){
    	try {
			dabc=new DatabaseConnection();//实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new KemuDAOImpl(dabc.getConnection());    	
    }
    public boolean findKemu(Zonghechengji zhcj) throws Exception {
		boolean flag=false;
		try {
			flag=dao.findKemu(zhcj);
		} catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return flag;
	}
    public List<Kemu> queryKemus()throws Exception{
    	List<Kemu> kemus = new ArrayList<Kemu>();
		try {
			kemus=dao.queryKemus();
		}catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return kemus;
    	
    }

}

