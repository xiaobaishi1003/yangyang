package want;

public class ChengjixiugaiDAOProxy implements IChengjixiugaiDAO{
	private DatabaseConnection dabc=null;//定义数据库连接
    private ChengjixiugaiDAOImpl dao=null;//定义DAO接口
    public ChengjixiugaiDAOProxy(){
    	try {
			dabc=new DatabaseConnection();//实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new ChengjixiugaiDAOImpl(dabc.getConnection());    	
    }
    public boolean Chengjixiugai(Chengjixiugai cjxg)throws Exception {
    	boolean flag =false;
		try {
			flag=dao.Chengjixiugai(cjxg);
		}catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return flag;
	}
    
    public boolean Chengjixiugai1(Chengjixiugai cjxg) throws Exception{
    	boolean flag = false;
    	try{
    		flag=dao.Chengjixiugai1(cjxg);
    	}catch(Exception e) {
    		throw e;
    	}finally{
    		dabc.close();
    	}
    	return flag;
    }
    
}
