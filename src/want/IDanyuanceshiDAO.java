package want;

import java.util.List;

public interface IDanyuanceshiDAO {
	
	public List<Danyuanceshi> queryDanyuanceshi(Grade grade) throws Exception;
	
	public List<Danyuanceshi> queryChengji() throws Exception;

}
