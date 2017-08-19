package want;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteKemuDAOImpl implements IDeleteKemuDAO{

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public DeleteKemuDAOImpl(Connection conn){ 
		this.conn=conn;
	}
	
	public boolean deleteKemu(Kemu kmsc)throws Exception{
		String name = kmsc.getName();
		try{
			String sql="delete from kemu where name = ?";			
		    pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);			
			pstmt.executeUpdate();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
