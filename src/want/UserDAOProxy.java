package want;
import want.DatabaseConnection;
import want.IUserDAO;
import want.User;
import want.UserDAOImpl;

public class UserDAOProxy implements IUserDAO{
    private DatabaseConnection dbc=null;
    private IUserDAO dao=null;
    public UserDAOProxy(){
    	try {
			dbc=new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new UserDAOImpl(dbc.getConnection());
    	
    }
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag=false;
		try {
			flag=dao.findLogin(user);
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
		return flag;
	}

}
