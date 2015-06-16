
package Admin;

import com.mysql.jdbc.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kevin Ewald
 */
public class ManageIndustries 
{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String message;
    private boolean succesful;
    
    public ManageIndustries()
    {
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
    } // end of constructor
    
    public void addIndustry(String industryName)
    {
        String queryStr;
        try
        {
            rs = st.executeQuery("SELECT COUNT(*) FROM industries WHERE industryName='" + industryName + "'");
            rs.next();
            int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
                if (matchCount == 0)
                {
                    if (industryName.length() > 0 && (industryName.length() < 35) && (!StringUtils.isEmptyOrWhitespaceOnly(industryName)))
                        
                    {
                        queryStr = "INSERT INTO `industries`(`industryName`) VALUES ('" + industryName + "')";
                        st.executeUpdate(queryStr);
                        this.message = "'" + industryName + "' has been added to the database.";
                        this.succesful = true;
                    }
                    else if (industryName.length() > 35)
                    {
                       this.message = "Error: Industry name must be less than 35 characters.";
                       this.succesful =  false; 
                    }
                    else
                    {
                        this.message = "Error: You must enter an industry name in the text field.";
                        this.succesful =  false;
                    }
                }
                else
                {
                    this.message = "Error: " + "A record for '" + industryName + "' already exists in the database.";
                    this.succesful =  false;
                }
        } catch(Exception ex)
        {
          System.out.println("Error: " + ex.getMessage());
          this.succesful = false;
        }
    } // end of addIndustry method
    
    public String getMessage()
    {
        return message;
    }
    
    public boolean getSuccesful()
    {
        return succesful;
    }
}
    
