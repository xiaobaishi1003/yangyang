package want;

import java.util.List;

public interface IZonghechengjiDAO {
	
	public List<String> queryZonghechengjis(Grade grade) throws Exception;
	
	public List<Zonghechengji> queryZonghechengjiss( Grade grade) throws Exception;
	
	public List<Zonghechengji> queryChengji() throws Exception;
	
	public List<Zonghechengji> queryChengjis(Kemuchengji kemuchengji) throws Exception;
	
	
}
