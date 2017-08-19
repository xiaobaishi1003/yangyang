package want;

public class User{
	private int userid;//对数据库中的userid
	private String name;//对应数据库中的name
	private String password;//对应数据库中的password
	public int getUserid(){
		return userid ;
	}
	public void setUserid(int userid){
		this.userid = userid ;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
}
