package want;

public class ChengjixiugaiDAOProxy implements IChengjixiugaiDAO{
	private DatabaseConnection dabc=null;//�������ݿ�����
    private ChengjixiugaiDAOImpl dao=null;//����DAO�ӿ�
    public ChengjixiugaiDAOProxy(){
    	try {
			dabc=new DatabaseConnection();//ʵ�������ݿ�����
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
