package want;


public class ChengjiluruProxy implements IChengjiluruDAO {
	private DatabaseConnection dabc=null;//�������ݿ�����
    private ChengjiluruDAOImpl dao=null;//����DAO�ӿ�
    public ChengjiluruProxy(){
    	try {
			dabc=new DatabaseConnection();//ʵ�������ݿ�����
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
