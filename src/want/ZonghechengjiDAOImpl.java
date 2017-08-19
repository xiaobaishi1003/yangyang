package want;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZonghechengjiDAOImpl implements IZonghechengjiDAO {
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement pstmt = null;// �������ݿ��������

	public ZonghechengjiDAOImpl(Connection conn) { // �������ݿ�����
		this.conn = conn;
	}

	public List<String> queryZonghechengjis(Grade grade) throws Exception {
		List<String> zonghechengjis = new ArrayList<String>();
		try {
			String sql = "select kemu.name,zonghechengji.chengji from kemu,zonghechengji where zonghechengji.kemu_id=kemu.id and zonghechengji.grade_id = ?";
			pstmt = conn.prepareStatement(sql);// ʵ��������
			pstmt.setInt(1, grade.getGradeid());
			ResultSet rSet = pstmt.executeQuery();// ȡ�ý��
			while (rSet.next()) {
				zonghechengjis.add(rSet.getString(1));// ȡ���û���
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
		return zonghechengjis;
	}

	@Override
	public List<Zonghechengji> queryZonghechengjiss(Grade grade)
			throws Exception {
		List<Zonghechengji> zonghechengjis = new ArrayList<Zonghechengji>();
		try {
			String sql = "select kemu.name,zonghechengji.chengji,zonghechengji.tupian,zonghechengji.beizhu from kemu,zonghechengji where zonghechengji.kemu_id=kemu.id and zonghechengji.grade_id = ?";
			pstmt = conn.prepareStatement(sql);// ʵ��������
			pstmt.setInt(1, grade.getGradeid());
			ResultSet rSet = pstmt.executeQuery();// ȡ�ý��
			while (rSet.next()) {
				Zonghechengji j = new Zonghechengji();
				j.setKemumingcheng(rSet.getString(1));// ȡ�ÿ�Ŀ����
				j.setChengji(rSet.getInt(2));
				j.setTupian(rSet.getString(3));
				j.setBeizhu(rSet.getString(4));
				zonghechengjis.add(j);
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
		return zonghechengjis;
	}

	public List<Zonghechengji> queryChengji() throws Exception {

		List<Zonghechengji> zonghechengji = new ArrayList<Zonghechengji>();

		try {
			String sql = "SELECT grade.xueqiming,kemu.`name`,zonghechengji.chengji,zonghechengji.tupian,zonghechengji.beizhu, zonghechengji.grade_id, zonghechengji.kemu_id from grade,kemu,zonghechengji "
					+ "where zonghechengji.grade_id = grade.id and zonghechengji.kemu_id = kemu.id";
			pstmt = conn.prepareStatement(sql);// ʵ��������
			ResultSet rSet = pstmt.executeQuery();// ȡ�ý��
			while (rSet.next()) {
				Zonghechengji j = new Zonghechengji();
				j.setXueqiming(rSet.getString(1));// ȡ��ѧ����
				j.setKemumingcheng(rSet.getString(2));// ȡ�ÿ�Ŀ����
				j.setChengji(rSet.getInt(3));// ȡ�óɼ�
				j.setTupian(rSet.getString(4));// ȡ��ͼƬ��ַ
				j.setBeizhu(rSet.getString(5));// ȡ�ñ�ע
				j.setGrade_id(rSet.getInt(6));
				j.setKemu_id(rSet.getInt(7));
				zonghechengji.add(j);
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
		return zonghechengji;
	}

	public List<Zonghechengji> queryChengjis(Kemuchengji kemuchengji)
			throws Exception {
		List<Zonghechengji> zonghechengji = new ArrayList<Zonghechengji>();

		try {
			String sql = "select grade.xueqiming,kemu.name,zonghechengji.chengji,zonghechengji.tupian,zonghechengji.beizhu from grade,kemu,zonghechengji where zonghechengji.grade_id=grade.id and zonghechengji.kemu_id=kemu.id";
			if (kemuchengji.getGrade_id() != -1) {
				sql += " and zonghechengji.grade_id= " + kemuchengji.getGrade_id();
			}
			if (kemuchengji.getKemu_id() != -1) {
				sql += " and zonghechengji.kemu_id=" + kemuchengji.getKemu_id();
			}
			if (kemuchengji.getChengji1() != -1) {
				sql += " and zonghechengji.chengji >=" + kemuchengji.getChengji1();
			}
			if (kemuchengji.getChengji2() != -1) {
				sql += " and zonghechengji.chengji <=" + kemuchengji.getChengji2();
			}
			pstmt = conn.prepareStatement(sql);// ʵ��������
			//pstmt.setInt(1, kemu.getKemuid());
			ResultSet rSet = pstmt.executeQuery();// ȡ�ý��
			while (rSet.next()) {
				Zonghechengji j = new Zonghechengji();
				j.setXueqiming(rSet.getString(1));// ȡ��ѧ����
				j.setKemumingcheng(rSet.getString(2));// ȡ�ÿ�Ŀ����
				j.setChengji(rSet.getInt(3));// ȡ�óɼ�
				j.setTupian(rSet.getString(4));//ȡ��ͼƬ��ַ
				j.setBeizhu(rSet.getString(5));
				zonghechengji.add(j);
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
		return zonghechengji;

	}

}