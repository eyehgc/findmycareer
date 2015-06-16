package AppFunctionality;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eunice Yeh
 */
public class Users {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;  
    
    public Users()
  {
  
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        // 3306 is the3 default port number for mysql (if not working check the port number
        // findmycareer is the database we are using.
        // root is the DB user we are using and the empty string that follows is the password (no password set)
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/findmycareer","root",""); 
        st = con.createStatement();
        
    } catch (Exception ex)
    {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
      /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * This method is used to list all users 
   * in the database by their last name.
   * 
   * @return null
   */
    public ResultSet listAllUsers()
  {
    try
    {
        String queryStr = "SELECT * FROM users WHERE accountType='Standard' ORDER BY lastName ASC";
        rs = st.executeQuery(queryStr);
        return rs;
    } catch(Exception ex)
    {
        System.out.println("Error: " + ex.getMessage());  
    }
    return null;
  } 
    
   /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * This method is lists all deactivated users.
   * 
   */
    public ResultSet listDeactivatedUsers()
  {
    try
    {
      
       String queryStr = "SELECT lastName, firstName, email, dateDeactivated FROM users "
                       + "WHERE accountType='Standard' AND accountStatus='Inactive' "
                       + "ORDER BY dateDeactivated DESC";
       rs = st.executeQuery(queryStr);
       return rs;
    } catch(Exception ex)
    {
      System.out.println("Error: " + ex.getMessage());  
    }
    return null;
  } 
      
   /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * This method lists users that have been
   * deactivated in the past 30 days.
   * 
   */
    public ResultSet listRecentlyDeactivatedUsers(String dateReturned)
  {
    
    try
    {  
       String queryStr = "SELECT lastName, firstName, email, dateDeactivated FROM users "
                       + "WHERE accountType='Standard' AND dateDeactivated>='"+ dateReturned 
                       + "' ORDER BY dateDeactivated DESC";
       rs = st.executeQuery(queryStr);
       return rs;
    } catch(Exception ex)
    {
      System.out.println("Error: " + ex.getMessage());  
    }
    return null;
  } 
    
    public void reactivateUser(String emailSelected)
  {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = new Date();
      String date1 = dateFormat.format(date);
        try
        {  
           String queryStr = "UPDATE users SET accountStatus= 'Active', "
                            + "lastActive='" + date1 + "' ,"
                            + "dateDeactivated= NULL WHERE email='" + emailSelected + "'";
           st.executeUpdate(queryStr);
        } catch(SQLException ex)
        {
          System.out.println("Error: " + ex.getMessage());  
        }
  } 
        
}