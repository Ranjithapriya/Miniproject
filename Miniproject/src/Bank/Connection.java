package Bank;

import PreparedStatement;
import Statement;

// Global connection Class
	public class Connection {
	    private static final String DriverManager = null;
		static Connection con; // Global Connection Object
	    public static Connection getConnection()
	    {
	        try {
	            
	            
	            String mysqlJDBCDriver
	                = "com.mysql.cj.jdbc.Driver"; //jdbc driver
	            String url
	                = "jdbc:mysql://localhost:3306/mydata"; //mysql url
	            String user = "root";        //mysql username
	            String pass = "priya";  //mysql passcode
	             Class.forName(mysqlJDBCDriver);
	            con = DriverManager.getConnection();
	        }
	        catch (Exception e) {
	            System.out.println("Connection Failed!");
	        }
	 
	        return con;
	    }
		public Statement createStatement() {
			// TODO Auto-generated method stub
			return null;
		}
		public PreparedStatement preparedStatement() {
			// TODO Auto-generated method stub
			return null;
		}
		public java.sql.PreparedStatement prepareStatement(String string) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
