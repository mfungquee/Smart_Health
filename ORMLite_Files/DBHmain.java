public class DBHmain {

	public static void main(String[] args) throws Exception {
		
		DBHandler dbh = new DBHandler();
		//String a = dbh.retrieveInfo();
		//System.out.print(a);
		dbh.makeUserAccount("albert", "drowssap");
	}

}
