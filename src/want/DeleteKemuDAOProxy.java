package want;

public class DeleteKemuDAOProxy implements IDeleteKemuDAO {
	private DatabaseConnection dabc = null;// 定义数据库连接
	private DeleteKemuDAOImpl dao = null;// 定义DAO接口

	public DeleteKemuDAOProxy() {
		try {
			dabc = new DatabaseConnection();// 实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao = new DeleteKemuDAOImpl(dabc.getConnection());
	}

	public boolean deleteKemu(Kemu kmsc) throws Exception {

		boolean flag = true;
		try {
			flag = dao.deleteKemu(kmsc);
		} catch (Exception e) {
			throw e;
		} finally {
			dabc.close();
		}
		return flag;

	}

}
