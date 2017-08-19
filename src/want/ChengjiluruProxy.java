package want;


public class ChengjiluruProxy implements IChengjiluruDAO {
	private DatabaseConnection dabc=null;//定义数据库连接
    private ChengjiluruDAOImpl dao=null;//定义DAO接口
    public ChengjiluruProxy(){
    	try {
			dabc=new DatabaseConnection();//实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new ChengjiluruDAOImpl(dabc.getConnection());    	
    }
    public boolean addChengjiluru(Chengjiluru cjlr)throws Exception {
    	boolean flag = false;
		try {
			flag=dao.addChengjiluru(cjlr);
		}catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return flag;
	}

    
    public boolean addChengjiluru2(Chengjiluru cjlr) throws Exception{
    	
    	boolean flag = false;
		try {
			flag=dao.addChengjiluru2(cjlr);
		}catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return flag;
    }
}
