package Registration;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Kevin Ewald
 * Purpose: This class contains methods which can be used for email validation.
 * the email address the user enters will be checked to see whether or not it already
 * exists in the DB, this can be used to ensure the same email address cannot be used 
 * for more than one account.
 */
public class EmailValidation {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    private boolean isEmailValid;
    private String message;
    
    public EmailValidation() // constructor
    {
        try
        {
            isEmailValid = false;
            message = "No email address has been entered.";
            Class.forName("com.mysql.jdbc.Driver");
            // 3306 is the3 default port number for mysql (if not working check the port number
            // people is the databse we are using.
            // root is the DB user we are using and the empty string that follows is the password (no password set)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root",""); 
            st = con.createStatement();   
        } 
        catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    } // end of constructor
    
    /**
     *<h3>@author Kevin Ewald</h3><br />
     * <strong>Purpose:</strong>
     * Queries the database for an email address matching the email address the
     * user supplied then counts the number of results returned.<br /><br />
     * <strong>Note:</strong> Use the checkValid method to return the boolean value
     * of <code>queryDBForEmail</code> method.<br />
     * <code>true</code> = Email not yet registered in DB<br />
     * <code>false</code> = Email already registered in DB
     * @param email     The email address entered by the user.
     * 
     */
    public void queryDBForEmail(String email)
    {
       try
       {  
        // count the number of rows that contain the email address the user entered
        rs = st.executeQuery("SELECT COUNT(*) FROM users WHERE email='" + email + "'");
        rs.next();
        int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
        if (matchCount == 0) // 0 means the email is not found in the users table
        {
            isEmailValid = true;
            message = "Email Address Does not yet exist in the database";
        }
        else
            // isEmailValid remains as false
            message = "This email address has already been registered.";
       } 
       catch (Exception ex) 
       {       
        System.out.println("Error: " + ex.getMessage());
       } // end of try/catch
    } // end of queryDBForEmail
    
    /**
     * <h3>@author Kevin Ewald</h3><br />
     * <strong>checkValid</strong> returns the boolean value of
     * the <code>queryDBForEmail</code> method.
     * @return
     * <code> true</code> if email is not yet registered in the DB<br />
     * <code>false</code> if email is already registered in the DB
     */
    public boolean checkValid()
    {
        return isEmailValid;
    }
    
    /**
     * <h3>@author Kevin Ewald</h3><br />
     * <strong>getMessage()</strong> Returns the string message which can be
     * used to display an appropriate message to the screen.
     * @return String
     */
    public String getMessage()
    {
        return message;
    }
}
