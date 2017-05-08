import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "exerciseinfo")
public class exerciseinfo{
	
	public static final String EXERCISENAME_FIELD_NAME = "exercisename";

	@DatabaseField(generatedId = true)
	private int idexerciseinfo;
	
	@DatabaseField(columnName = EXERCISENAME_FIELD_NAME)
	private String exercisename;
	
	exerciseinfo(){
		//all persisted classes must define a no-arg constructor with at least package visibility
	}
	
	public exerciseinfo(String exercisename){
		this.exercisename = exercisename;
	}
		
	public int getID(){
		return idexerciseinfo;
	}
	
	public String getExercisename(){
		return exercisename;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null || other.getClass() != getClass()){
			return false;
		}
		return exercisename.equals(((exerciseinfo) other).exercisename);
	}
	
}