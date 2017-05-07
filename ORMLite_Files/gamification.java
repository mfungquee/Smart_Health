import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "gameification")
public class gamification{
	
	public static final String GAMIFICATION_FIELD_NAME = "gamification_method";

	@DatabaseField(generatedId = true)
	private int idgamification;
	
	@DatabaseField(columnName = GAMIFICATION_FIELD_NAME)
	private String gamification_method;
	
	gamification(){
		//all persisted classes must define a no-arg constructor with at least package visibility
	}
	
	public gamification(String gamification_method){
		this.gamification_method = gamification_method;
	}
		
	public int getID(){
		return idgamification;
	}
	
	public String getgamification_method(){
		return gamification_method;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null || other.getClass() != getClass()){
			return false;
		}
		return gamification_method.equals(((gamification) other).gamification_method);
	}
	
}