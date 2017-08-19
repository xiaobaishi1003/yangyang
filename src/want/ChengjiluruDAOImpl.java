package want;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChengjiluruDAOImpl implements IChengjiluruDAO{
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public ChengjiluruDAOImpl(Connection conn){ 
		this.conn=conn;
	}
	public boolean addChengjiluru(Chengjiluru cjlr)throws Exception {
		int grade_id = cjlr.getGrade_id();
		int kemu_id = cjlr.getKemu_id();
		int chengji = cjlr.getChengji();
		String tupian = cjlr.getTupian();
		String beizhu = cjlr.getBeizhu();
		try{
			String sql="insert into zonghechengji(grade_id,kemu_id,chengji,tupian,beizhu)values(?,?,?,?,?)";			
		    pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,grade_id);
			pstmt.setInt(2,kemu_id);
			pstmt.setInt(3,chengji);
			pstmt.setString(4,tupian);
			pstmt.setString(5,beizhu);
			pstmt.executeUpdate();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addChengjiluru2(Chengjiluru cjlr) throws Exception{
		int grade_id = cjlr.getGrade_id();
		int kemu_id = cjlr.getKemu_id();
		int danyuan = cjlr.getDanyuan();
		int juanmian = cjlr.getJuanmian();
		int xiehua = cjlr.getXiehua();
		int beisong = cjlr.getBeisong();
		
		try{
			String sql="insert into danyuanceshi(grade_id,kemu_id,danyuan,juanmian,xiehua,beisong)values(?,?,?,?,?,?)";			
		    pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,grade_id);
			pstmt.setInt(2,kemu_id);
			pstmt.setInt(3,danyuan);
			pstmt.setInt(4,juanmian);
			pstmt.setInt(5,xiehua);
			pstmt.setInt(6,beisong);
			pstmt.executeUpdate();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

}
