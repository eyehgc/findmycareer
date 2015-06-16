package Admin;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Eunice Yeh
 */
public class ManageAdmins {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;   
    
    public ManageAdmins()
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
   * This method lists all admins in database.
   * 
   */
   public ResultSet listAllAdmins()
  {
    
        try
        {  
           String queryStr =  "SELECT lastName,firstName, email FROM users WHERE accountType='Admin' ORDER BY lastName ASC";
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
   * This method is used to make sure the email 
   * isn't already registered in the database.
   * 
   */  
  public boolean queryDBForEmail(String email)
    {
       boolean isValid;
       try
       {  
        rs = st.executeQuery("SELECT COUNT(*) FROM users WHERE email='" + email + "'");
        rs.next();
        int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
            if (matchCount == 0){ 
               isValid = true;} // 0 means the disciplineName is not found in the discplines table
            else{
                isValid = false;}
       } 
       catch (Exception ex) 
       {       
        System.out.println("Error: " + ex.getMessage());
        isValid = false;
       } // end of try/catch
      return isValid;
    }
   
    /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * This method is used to add an admin to the database.
   * 
   */
  public ResultSet addAdmin(String email, String password2, String firstName, String lastName)
  {
    
    try
    {  
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String date1 = dateFormat.format(date);
       String queryStr = "INSERT INTO users (email, password, accountType, firstName, lastName, "
                        + "birthDate, gender, employmentStatus,"
                        + "lastActive, registrationDate)"
                        + "VALUES ('" + email +"','" + password2 + "','Admin','" + firstName + "','" + lastName + "','"
                        + date1 + "', 'NA', 'NA','"
                        + date1 + "','" + date1 + "')";
           
       st.executeUpdate(queryStr);
    } catch(Exception ex)
    {
      System.out.println("Error: " + ex.getMessage());  
    }
    return null;
  } 
   
   /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * This method is used to remove 
   * an admin from the database.
   * 
   */
   public void removeAdmin(String emailSelected)
    {
        try
        {
            String queryStr = "DELETE FROM users WHERE accountType='Admin' AND email='" + emailSelected + "'";
            st.executeUpdate(queryStr);
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
