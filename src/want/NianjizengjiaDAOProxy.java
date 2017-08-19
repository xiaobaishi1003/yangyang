package want;

import java.util.ArrayList;
import java.util.List;

public class NianjizengjiaDAOProxy implements INianjizengjiaDAO {

	private DatabaseConnection dabc = null;
	private NianjizengjiaDAOImpl dao = null;

	public NianjizengjiaDAOProxy() {
		try {
			dabc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao = new NianjizengjiaDAOImpl(dabc.getConnection());
	}

	public List<String> addNianji(Nianjizengjia njzj) throws Exception{
		List<String> nianjizengjia = new ArrayList<String>();
		try {
			nianjizengjia = dao.addNianji(njzj);
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return nianjizengjia;
	}
	
	public boolean addNianjis(Nianjizengjia njzj)throws Exception{
		
		boolean flag=false;
		try {
			flag=dao.addNianjis(njzj);
		} catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return flag;
	}

}
