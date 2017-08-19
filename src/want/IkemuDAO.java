package want;

import java.util.List;

import want.Kemu;

public interface IkemuDAO {
	
	public boolean findKemu(Zonghechengji zhcj) throws Exception;
	
	public List<Kemu> queryKemus() throws Exception;

}
