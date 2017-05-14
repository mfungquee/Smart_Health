import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

//STRING TO INTERGER -> int foo = Integer.parseInt("1234");


public class DBHandler{
	//public final static String DATABASE_URL = "jdbc:mysql://saxena5com.fatcowmysql.com/smart_health";
	public final static String DATABASE_URL = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9174268";
	//public final static String DATABASE_USERNAME = "smarthealth";
	public final static String DATABASE_USERNAME = "sql9174268";
	public final static String DATABASE_PASSWORD = "fj4DLXSZIZ";
	
	private Dao<Userinfo, Integer> userinfoDAO;
	//private Dao<exerciseinfo, Integer> exerciseinfoDAO;
	//private Dao<gamification, Integer> gamificationDAO;
	private Dao<progress, Integer> progressDAO;
	
//Constructor
//----------------------------------------------------------------------------------------------------------------------------------------------------
	public DBHandler() throws Exception{
		ConnectionSource connectionSource = null;
		
		try{
			connectionSource = new JdbcConnectionSource(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD); //create data-source for the database
			userinfoDAO = DaoManager.createDao(connectionSource, Userinfo.class);
			//exerciseinfoDAO = DaoManager.createDao(connectionSource, exerciseinfo.class);
			//gamificationDAO = DaoManager.createDao(connectionSource, gamification.class);
			progressDAO = DaoManager.createDao(connectionSource, progress.class);
		   } finally{
			   
			//destroy data source which closed any other connections
			if(connectionSource != null){
				connectionSource.close();
			}
		}
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
		
		System.out.print("New Account created.");
	}
//end of makeUserAccount

//retrieve user information
/*
	public void retrieveInfo() throws SQLException{
		// get our query builder from the DAO
		QueryBuilder<Userinfo, Integer> queryBuilder =
		  userinfoDAO.queryBuilder();
		// get the WHERE object to build our query
		Where<Userinfo, Integer> where = queryBuilder.where();
		// the name field must be equal to "foo"
		where.eq(Userinfo.USERNAME_FIELD_NAME, "asaxena");
		PreparedQuery<Userinfo> preparedQuery = queryBuilder.prepare();

	}
*/
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