package want;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import want.Zonghechengji;

public class KemuDAOImpl implements IkemuDAO{

	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;// �������ݿ��������

	public KemuDAOImpl(Connection conn) { // �������ݿ�����
		this.conn = conn;
	}

	public boolean findKemu(Zonghechengji zhcj) throws Exception{
		boolean flag=false;
		
		try {
			String sql = "select chengji from zonghechengji where kemu_id = ? and grade_id = ?";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,zhcj.getKemu_id());
			pstmt.setInt(2,zhcj.getGrade_id());
			ResultSet rSet = pstmt.executeQuery();
			if(rSet.next()){
		    	rSet.getInt(1);
		    	flag=true;   	
		    }

		} catch (Exception e) {
			throw e;
		} finally {
			// �رղ���
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}

		}
		return flag;
	}
	
	public List <Kemu> queryKemus() throws Exception{
		List<Kemu> kemus = new ArrayList<Kemu>();
		
		try {
			String sql = "select * from kemu";
			pstmt = conn.prepareStatement(sql);
			ResultSet rSet = pstmt.executeQuery();
			while (rSet.next()) {
				Kemu kemu = new Kemu();
				kemu.setKemuid(rSet.getInt(1));
				kemu.setName(rSet.getString(2));
				kemus.add(kemu);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			// �رղ���
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					throw e;
				}
			}

		}
		return kemus;
		
		
	}
}
