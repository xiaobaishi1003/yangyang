package want;

public class DeleteNianjiDAOProxy implements IDeleteNianjiDAO{
	private DatabaseConnection dabc=null;//定义数据库连接
    private DeleteNianjiDAOImpl dao=null;//定义DAO接口
    public DeleteNianjiDAOProxy(){
    	try {
			dabc=new DatabaseConnection();//实例化数据库连接
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
