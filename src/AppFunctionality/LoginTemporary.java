
package AppFunctionality;

import java.sql.*;

/**
 * @author Kevin Ewald
 * Note: this class will not really be used, just a temporary class until the real one is created
 */
public class LoginTemporary 
{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    private String accountType;
    
    public LoginTemporary()
    {
        accountType = "Standard";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            // 3306 is the3 default port number for mysql (if not working check the port number
            // findmycareer is the databse we are using.
            // root is the DB user we are using and the empty string that follows is the password (no password set)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/findmycareer","root",""); 
            st = con.createStatement();

        } catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void checkForAccount(String email, String password)
    {
        try
        {
            String queryStr = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password +"'";
            rs = st.executeQuery(queryStr);            
                if(rs.next())
                {
                    String accounttype = rs.getString("accountType");
                    this.accountType = accounttype;
                }            
        } catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }        
    }
    
    public String getAccountType()
    {
        return accountType;
    }
}
