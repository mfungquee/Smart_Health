import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "progress")
public class progress{
	
	public static final String IDUSERINFO_FIELD_NAME = "iduserinfo";
	public static final String DATE_FIELD_NAME = "date";
	public static final String IDEXERCISE_FIELD_NAME = "idexercise";
	public static final String IDGAMFICATION_FIELD_NAME = "idgamification";
	public static final String REPS_FIELD_NAME = "reps";
	public static final String SUCCESSRATE_FIELD_NAME = "successrate";

	@DatabaseField(generatedId = true)
	private int idprogress;
	
	@DatabaseField(columnName = IDUSERINFO_FIELD_NAME)
	private int iduserinfo_ref;

	@DatabaseField(columnName = DATE_FIELD_NAME)
	private String date;

	@DatabaseField(columnName = IDEXERCISE_FIELD_NAME)
	private int idexerciseinfo_ref;

	@DatabaseField(columnName = IDGAMFICATION_FIELD_NAME)
	private int idgamification_ref;

	@DatabaseField(columnName = REPS_FIELD_NAME)
	private int reps;

	@DatabaseField(columnName = SUCCESSRATE_FIELD_NAME)
	private int successrate;
	

	progress(){
		//all persisted classes must define a no-arg constructor with at least package visibility
	}
	
	public progress(int iduserinfo_ref, String date, int idexerciseinfo_ref, int idgamification_ref, int reps, int successrate){
		this.iduserinfo_ref = iduserinfo_ref;
		this.date = date;
		this.idexerciseinfo_ref = idexerciseinfo_ref;
		this.idgamification_ref = idgamification_ref;
		this.reps = reps;
		this.successrate = successrate;
	}
		
	public int getID(){
		return idprogress;
	}
	
	public int getIDuserinfo(){
		return iduserinfo_ref;
	}
	
	public String getDate(){
		return date;
	}
	
	public int getIDexerciseinfo(){
		return idexerciseinfo_ref;
	}
	
	public int getIDgamification(){
		return idgamification_ref;
	}
	
	public int getReps(){
		return reps;
	}
	public int getSuccessrate(){
		return successrate;
	}
	/*
	@Override
	public boolean equals(Object other){
		if (other == null || other.getClass() != getClass()){
			return false;
		}
		return iduserinfo_ref.equals(((progress) other).iduserinfo_ref);
	}
	*/
}