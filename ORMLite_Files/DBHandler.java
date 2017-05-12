import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

//STRING TO INTERGER -> int foo = Integer.parseInt("1234");


public class DBHandler{
	public final static String DATABASE_URL = "jdbc:mysql://192.150.1.125:3306/smart_health";
	public final static String DATABASE_USERNAME = "root";
	public final static String DATABASE_PASSWORD = "hofstracs";
	
	private Dao<Userinfo, Integer> userinfoDAO;
	//private Dao<exerciseinfo, Integer> exerciseinfoDAO;
	//private Dao<gamification, Integer> gamificationDAO;
	private Dao<progress, Integer> progressDAO;

	public static void main(String[] args) throws Exception{
		new DBHandler().doMain(args);
	}
	
//Constructor
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public void doMain(String[] args) throws Exception{
		ConnectionSource connectionSource = null;
		
		try{
			connectionSource = new JdbcConnectionSource(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD); //create data-source for the database
			setupDatabase(connectionSource); //setup database and DAOs
	
			
		   } finally{
			   
			//destroy data source which closed any other connections
			if(connectionSource != null){
				connectionSource.close();
			}
		}
	}
	
	//Set up database & DAO
	public void setupDatabase(ConnectionSource connectionSource) throws Exception{
		userinfoDAO = DaoManager.createDao(connectionSource, Userinfo.class);
		//exerciseinfoDAO = DaoManager.createDao(connectionSource, exerciseinfo.class);
		//gamificationDAO = DaoManager.createDao(connectionSource, gamification.class);
		progressDAO = DaoManager.createDao(connectionSource, progress.class);
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------	

//makes a new User Account	
	public void makeUserAccount(String u, String p) throws Exception{
		
		//create instance of account
		String username = u;
		String password = p;
		Userinfo user = new Userinfo(username, password);
		
		//persist the account object to the database
		userinfoDAO.create(user); 
		
		//updates database with new user
		userinfoDAO.update(user); 
	}
//end of makeUserAccount

//retrieve user information
	public void retrieveInfo(String u){
		for (Userinfo user : userinfoDAO) {
			String currentID = user.getUsername();
			if (u == currentID){
				user.getID();
				user.getPassword();
			} 
		}		
	}
//	
//create new entry in the progress table	
	public void progressEntry(int iduserinfo_, String date_, int idexerciseinfo_, int idgamification_, int reps_, int successrate_) throws Exception{
		
		//create instance of account
		int a = iduserinfo_;
		String b = date_;
		int c = idexerciseinfo_;
		int d = idgamification_;
		int e = reps_;
		int f = successrate_;
		progress p = new progress(a, b, c, d, e, f);
		
		//persist the account object to the database
		progressDAO.create(p); 
		
		//updates database with new user
		progressDAO.update(p); 
	}
}//end of DBHandler