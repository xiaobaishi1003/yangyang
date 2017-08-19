package want;

public class DeleteKemuDAOProxy implements IDeleteKemuDAO {
	private DatabaseConnection dabc = null;// �������ݿ�����
	private DeleteKemuDAOImpl dao = null;// ����DAO�ӿ�

	public DeleteKemuDAOProxy() {
		try {
			dabc = new DatabaseConnection();// ʵ�������ݿ�����
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
