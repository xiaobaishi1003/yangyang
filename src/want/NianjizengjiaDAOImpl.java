package want;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NianjizengjiaDAOImpl {

	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库操作对象

	public NianjizengjiaDAOImpl(Connection conn) { // 设置数据库连接
		this.conn = conn;
	}
	
	public List<String> addNianji(Nianjizengjia njzj) throws Exception{
		
		List<String> nianjizengjia = new ArrayList<String>();

		String xueqiming = njzj.getXueqiming();
		
		try {
			String sql = "insert into grade(xueqiming) values(?)";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,xueqiming);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return nianjizengjia;
	}
	
	public boolean addNianjis(Nianjizengjia njzj)throws Exception{
		boolean flag=false;
		
		try{
			String sql="select xueqiming from grade where xueqiming = ?";
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1,njzj.getXueqiming());			
		    ResultSet rSet = pstmt.executeQuery();
			if(rSet.next()){
		    	rSet.getString(1);
		    	flag=true;   	
		    }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
		
}
