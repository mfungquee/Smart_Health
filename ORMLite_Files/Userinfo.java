import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "userinfo")
public class Userinfo{
	
	public static final String USERNAME_FIELD_NAME = "username";
	public static final String PASSWORD_FIELD_NAME = "password";
	
	@DatabaseField(generatedId = true)
	private int iduserinfo;
	
	@DatabaseField(columnName = USERNAME_FIELD_NAME)
	private String username;
	
	@DatabaseField(columnName = PASSWORD_FIELD_NAME)
	private String password;
	
	Userinfo(){
		//all persisted classes must define a no-arg constructor with at least package visibility
	}
	
	public Userinfo(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public int getID(){
		return iduserinfo;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null || other.getClass() != getClass()){
			return false;
		}
		return username.equals(((Userinfo) other).username);
	}
	
}