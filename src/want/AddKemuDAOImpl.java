package want;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddKemuDAOImpl implements IAddKemu{

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public AddKemuDAOImpl(Connection conn){ 
		this.conn=conn;
	}
	
	public List<String> addKemu(AddKemu kmzj) throws Exception{
		
		List<String> kemuzengjia = new ArrayList<String>();

		String name = kmzj.getName();
		try {
			String sql = "insert into kemu(name) values(?)";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return kemuzengjia;
	}
	
	public boolean addKemus(AddKemu kmzj)throws Exception{
		boolean flag=false;
		
		try{
			String sql="select name from kemu where name = ?";			
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1,kmzj.getName());			
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
