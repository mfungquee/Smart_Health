import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;


public class UserinfoORMtest{
	public final static String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/smart_health";
	public final static String DATABASE_USERNAME = "root";
	public final static String DATABASE_PASSWORD = "hofstracs";
	private Dao<Userinfo, Integer> userinfoDAO;
	
	public static void main(String[] args) throws Exception{
		new UserinfoORMtest().doMain(args);
	}
	
	//Things to do in main
	public void doMain(String[] args) throws Exception{
		ConnectionSource connectionSource = null;
		try{
			//create data-source for the database
			connectionSource = new JdbcConnectionSource(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
			//setup database and DAOs
			setupDatabase(connectionSource);
			
			//display the database table entries
			//displayData();
			
			//makes new account
			makeNew_Account();

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
	}
	
	//display the database table entries
	public void displayData() throws Exception{
		for (Userinfo userinfo : userinfoDAO){
			System.out.println("ID: "+ userinfo.getID());
			System.out.println("Username: "+ userinfo.getUsername());
			System.out.println("Password: "+ userinfo.getPassword());
		}
	}
	
	public void makeNew_Account() throws Exception{
		//create instance of account
		String name = "krish";
		String password = "compsci";
		Userinfo user = new Userinfo(name, password);
		
		//persist the account object to the database
		userinfoDAO.create(user);
		int id = user.getID();
		
		//updates database with new user
		userinfoDAO.update(user);
		
		//displays table after adding a new user
		displayData();
		
		//deletes new user from table
		userinfoDAO.delete(user);
		
		System.out.println("--------------------------------------------------------");
		
		// display table after deleting new account 
		displayData();
	}
}