package want;

public class DeleteNianjiDAOProxy implements IDeleteNianjiDAO{
	private DatabaseConnection dabc=null;//�������ݿ�����
    private DeleteNianjiDAOImpl dao=null;//����DAO�ӿ�
    public DeleteNianjiDAOProxy(){
    	try {
			dabc=new DatabaseConnection();//ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new DeleteNianjiDAOImpl(dabc.getConnection());    	
    }
    
    public boolean deleteNianji(DeleteNianji njsc)throws Exception{
    	
    	boolean flag=true;
		try {
			flag=dao.deleteNianji(njsc);
		}catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return flag;
    	
    }
    
}
