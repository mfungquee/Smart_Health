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
	private String iduserinfo_ref;

	@DatabaseField(columnName = DATE_FIELD_NAME)
	private String date;

	@DatabaseField(columnName = IDEXERCISE_FIELD_NAME)
	private String idexerciseinfo_ref;

	@DatabaseField(columnName = IDGAMFICATION_FIELD_NAME)
	private String idgamification_ref;

	@DatabaseField(columnName = REPS_FIELD_NAME)
	private String reps;

	@DatabaseField(columnName = SUCCESSRATE_FIELD_NAME)
	private String successrate;
	

	progress(){
		//all persisted classes must define a no-arg constructor with at least package visibility
	}
	
	public progress(String iduserinfo_ref, String date, String idexerciseinfo_ref, String idgamification_ref, String reps, String successrate){
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
	
	public String getIDuserinfo(){
		return iduserinfo_ref;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getIDexerciseinfo(){
		return idexerciseinfo_ref;
	}
	
	public String getIDgamification(){
		return idgamification_ref;
	}
	
	public String getReps(){
		return reps;
	}
	public String getSuccessrate(){
		return successrate;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null || other.getClass() != getClass()){
			return false;
		}
		return iduserinfo_ref.equals(((progress) other).iduserinfo_ref);
	}
	
}