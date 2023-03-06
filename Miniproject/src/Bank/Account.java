package Bank;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Account {
   private String Name="PRIYA";
   private int Balance=1000;
   private int accountNumber=123;
	private static void connectToDatabase() throws ClassNotFoundException {
  		try 
  		{
  			Class.forName("com.mysql.jdbc.Driver");
  			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","priya");
  			Statement ss=(Statement) con.createStatement();
  			ResultSet rs=ss.executeQuery("select * from accounts");
  			while(rs.next())
  			{
  				System.out.println(rs.getString(1)+" "+rs.getString(2)+"  "+rs.getString(3)+" ");
  			}
  					
  		} catch (Exception e) {
  			System.out.println(e);
  		}
  	}
    //it stores the customer name      
    //now making constructor of bank account
    private static void createAccount() throws SQLException {
        System.out.println("Enter name:");
        String name = System.console().readLine();

        System.out.println("Enter initial balance:");
        int balance = Integer.BYTES;
        System.out.println("Enter initial balance:");
        int accountNumber= Integer.BYTES;
        
        String query = "INSERT INTO accounts (name, balance,accountNumber) VALUES (?, ?)";
        Connection connection = null;
		PreparedStatement stmt =connection.prepareStatement(query);
        stmt.setString(1, name);
        stmt.setInt(2, balance);
        stmt.setInt(3, accountNumber);
        stmt.executeUpdate();
        System.out.println("Account created");
      }
    //function for depositing the given amount in the account
    public void depositCash(int amount)throws SQLException{
    	 System.out.println("Enter account number:");
    	    int accountNumber = Integer.BYTES;

    	    System.out.println("Enter amount to deposit:");
    	    int amount1 = Integer.BYTES;

    	    String query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
    	    Connection connection = null;
			PreparedStatement stmt = connection.prepareStatement(query);
    	    stmt.setInt(1, amount1);
    	    stmt.setInt(2, accountNumber);
    	    int numRowsAffected = stmt.executeUpdate();
    	    if (numRowsAffected > 0) {
    	      System.out.println("Deposit successful");
    	    } else {
    	      System.out.println("Account not found");
    	    }
    	         if(amount!=0){
    	          Balance=Balance+amount; //update balance
        }
    }
    
    //function for withdrawing the given amount from the account
    public void withdrawCash(int amount) throws SQLException{
    	  System.out.println("Enter account number:");
    	    int accountNumber = Integer.BYTES;
    	  
    	    System.out.println("Enter amount to withdraw:");
    	    int amount1 = Integer.BYTES;
    	    
    	    String query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
    	    
    		Connection 
    		connection = null;
			PreparedStatement stmt =(PreparedStatement)connection.prepareStatement(query);
    	    stmt.setInt(1, amount1);
    	    stmt.setInt(2, accountNumber);
    	    int numRowsAffected = stmt.executeUpdate();
    	    if (numRowsAffected > 0) {
    	      System.out.println("Withdrawal successful");
    	    } else {
    	      System.out.println("Account not found");
    	    }
    	  
        if(amount1!=0){
            Balance=Balance-amount1;         //update balance
        }
    }
    private static void checkBalance() throws SQLException {
        System.out.println("Enter account number:");
        int accountNumber = Integer.BYTES;

        String query = "SELECT balance FROM accounts WHERE account_number = ?";
        Connection connection = null;
		PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, accountNumber);
        ResultSet rs = stmt.executeQuery();
        if (rs.next());
      }
    

    //function which shows the menu interface
    public void display(int accounNumber) throws SQLException{
        char option='\0';
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to IOB of India");
        System.out.println("Your name is : " + Name);
        System.out.println("Your Account Number is : "+accountNumber);
        System.out.println("\0");
        System.out.println( "A.Check Balance\n B. Deposit Cash\n C. Withdraw Cash\n D. Exit");

        do{
            System.out.println("Enter an option");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch(option){
                    case 'A':
                    System.out.println("Current Balance : " + Balance);
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("Enter an amount want to deposit");
                    int deposit_Amount=sc.nextInt();
                    depositCash(deposit_Amount);
                    System.out.println("\0");
                    System.out.println("The amount was deposited");
                    break;

                case 'C':
                    System.out.println("Enter an amount want to withdraw");
                    int withdrawl_Amount=sc.nextInt();
                    withdrawCash(withdrawl_Amount);
                    System.out.println(" after withdrawl AccountBalance:" + Balance);
                    break;

                    case 'D':
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid Operation!!!!!!. Please enter valid operation");
                    break;
            }
        }while(option != 'E');
        System.out.println("Thanks for using our banking services");
    }
}