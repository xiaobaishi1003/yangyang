package want;

import java.util.ArrayList;
import java.util.List;

public class GradeDAOProxy implements IGradeDAO{

	private DatabaseConnection dabc=null;//定义数据库连接
    private GradeDAOImpl dao=null;//定义DAO接口
    public GradeDAOProxy(){
    	try {
			dabc=new DatabaseConnection();//实例化数据库连接
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
