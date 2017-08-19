package want;

import java.util.ArrayList;
import java.util.List;

public class GradeDAOProxy implements IGradeDAO{

	private DatabaseConnection dabc=null;//�������ݿ�����
    private GradeDAOImpl dao=null;//����DAO�ӿ�
    public GradeDAOProxy(){
    	try {
			dabc=new DatabaseConnection();//ʵ�������ݿ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new GradeDAOImpl(dabc.getConnection());    	
    }
	public List<Grade> queryGrades()  throws Exception {
		List<Grade> grades = new ArrayList<Grade>();
		try {
			grades=dao.queryGrades();
		}catch (Exception e) {
			throw e;
		}finally{
			dabc.close();
		}
		return grades;
	}

}
