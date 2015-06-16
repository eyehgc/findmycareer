/**
 * @author Yusuf Bhyat - 4105558614
 *
 * Purpose: Queries DB to check if email address exists
  *
 */


package AppFunctionality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CheckEmailUniqueYB {
    
    public boolean CheckEmailUnique(String email) {
        
        // declares varibles
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        conn = MySQLConnectYB.ConnectDB();

        boolean isValid = false;
        try
       {  
           // count the number of rows that contain the email address the user entered
           String sql = "SELECT COUNT(*) FROM users WHERE email='" + email + "'";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
            
           
            
            rs.next();
            int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
            if (matchCount == 0) // 0 means the email is not found in the users table
                isValid = true;
       } 
       catch (Exception ex) 
       {       
            System.out.println("Error: " + ex.getMessage());
       } 
    return isValid;
    
}
}
