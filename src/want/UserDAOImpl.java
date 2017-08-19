package want;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import want.User;
public class UserDAOImpl implements IUserDAO{
	private Connection conn=null;//�������ݿ����Ӷ��� 
	private PreparedStatement pstmt=null;//�������ݿ��������
	public UserDAOImpl(Connection conn){ //�������ݿ�����
		this.conn=conn;
	}
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag=false;
		try {
			String sql="select name from user where name=? and password=?";
			pstmt=conn.prepareStatement(sql);//ʵ��������
			pstmt.setString(1,user.getName());
		    pstmt.setString(2, user.getPassword());
		    ResultSet rSet=pstmt.executeQuery();//ȡ�ý�� 
		    if(rSet.next()){
		    	user.setName(rSet.getString(1));//ȡ���û���
		    	flag=true;   	
		    }

		} catch (Exception e) {
			throw e;
		}finally{
			//�رղ���
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (Exception e) {
					throw e;				
			}		
		}
			
		}
		return flag;
	}
	
}