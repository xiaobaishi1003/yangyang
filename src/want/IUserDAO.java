package want;
import want.User;

public interface IUserDAO {
	/**
	 * �û���¼��֤
	 * 
	 * @param user����vo����
	 * @return ��֤�Ĳ������
	 * @throws Exception
	 */
	public boolean findLogin(User user) throws Exception;

}
