package Bank;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException{

        Account person=new Account();
        person.display(0);
    }
}