import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
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
			
			
			
			//Put any code to test functions in this section:
			retrieveInfo();
			// construct a query using the QueryBuilder

			//makeUserAccount("abc123", "hellohello");
			//
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

//retrieve all user information
	public void retrieveInfo(){
		for (Userinfo user : userinfoDAO){
			System.out.println(user.getID());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
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