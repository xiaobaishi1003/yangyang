package want;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteNianjiDAOImpl implements IDeleteNianjiDAO{
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public DeleteNianjiDAOImpl(Connection conn){ 
		this.conn=conn;
	}
	
	public boolean deleteNianji(DeleteNianji njsc)throws Exception{
		String xueqiming = njsc.getXueqiming();
		try{
			String sql="delete from grade where xueqiming = ?";			
		    pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,xueqiming);			
			pstmt.executeUpdate();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
