
package AppFunctionality;

import com.mysql.jdbc.StringUtils;
import java.sql.*;

/**
 * @author Kevin Ewald, Sasha Graham, Eunice Yeh
 */
public class Industries {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    private String industryNameChosen;
    private int industryID;
    private String message;
    private boolean succesful;
  
  public Industries()
  {
    industryNameChosen = null;
    industryID = 0;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        // 3306 is the3 default port number for mysql (if not working check the port number
        // findmycareer is the databse we are using.
        // root is the DB user we are using and the empty string that follows is the password (no password set)
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/findmycareer","root",""); 
        st = con.createStatement();
        
    } catch (Exception ex)
    {
        System.out.println("Error: " + ex.getMessage());
    }
    
  } // end of constructor
  
   /**
   * <h3>@author Kevin Ewald</h3>
   * <strong>Purpose:</strong><br />
   * This method will return a ResultSet object of all
   * industries found in the database, listed in alphabetical order.
   * @return ResultSet  -All industries found in DB
   */
  public ResultSet listAllIndustries()
  {
    try
    {
       String queryStr = "SELECT * FROM industries ORDER BY industryName ASC";
       rs = st.executeQuery(queryStr);
       return rs;
    } catch(Exception ex)
    {
      System.out.println("Error: " + ex.getMessage());  
    }
    return null;
  } // end of listAllIndustries method
  
  /**
   * <h3>@author Kevin Ewald</h3>
   * <strong>Purpose: </strong><br />
   * Used to return the industryID for a particular industry. the result of this can be used
   * with the <code>listCareers</code> method of the <code>Careers</code> class in order to list all 
   * corresponding careers associated with the industry.
   * @param industryName
   * @return Integer    - The corresponding industryID for the supplied industryName
   */
  public int getIndustryIDByName(String industryName)
    {
        try
        {
            String queryStr = "SELECT industryID FROM industries WHERE industryName='" + industryName + "'";
            rs = st.executeQuery(queryStr);            
                if(rs.next())
                {
                    int id = rs.getInt(1);
                    this.industryID = id;
                    this.setIndustryNameChosen(industryName);
                    return id;
                }            
        } catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
      return 0;        
    } // end of getIndustryIDByName method
  
  public boolean checkIfIndustryExists(String industryEntered)
{
    boolean isValid = false;
    try
       {  
            // count the number of rows that contain the email address the user entered
            rs = st.executeQuery("SELECT COUNT(*) FROM industries WHERE industryName='" + industryEntered + "'");
            rs.next();
            int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
            if (matchCount == 0) // 0 means the email is not found in the users table
                isValid = true;
       } 
       catch (SQLException ex) 
       {       
            System.out.println("Error: " + ex.getMessage());
       } 
    return isValid;
}
  
  /**
   * <h3>@author Kevin Ewald</h3>
   * <strong>Purpose:</strong><br />
   * used to store the name of the industry the user selects so that it may be retrieved again
   * at any time when needed.<br />
   * <strong>Note:</strong> this method is automatically run when the 
   * <code>getIndustryIDByName</code> method is called.
   * @param industryNameChosen 
   */
  public void setIndustryNameChosen(String industryNameChosen)
  {
      this.industryNameChosen = industryNameChosen;
  }
  
  /**
   * <h3>@author Kevin Ewald</h3>
   * <strong>Purpose:</strong><br />
   * Used to retrieve the value stored in the <code>setIndustryNameChosen</code>
   * method.
   * @return String     -IndustryNameChosen
   */
  public String getIndustryNameChosen()
  {
      return this.industryNameChosen;
  }
  
  /**
   * <h3>@author Kevin Ewald</h3>
   * <strong>Purpose:</strong><br />
   * Used to get the value of the industryID that was last returned by the
   * <code>getIndustryIDByName</code> method.
   * This method can be used as a way for allowing the user to go "back"
   * a page after they have selected a career.
   * @return Integer 
   */
  public int getIndustryID()
    {
        return industryID;
    }
  
  
  /**
   * @Author: Sasha Graham
   * Purpose: This SLQ statement is used to update the industry name
   *          in the industries table to whatever the admin wants to 
   *          set it to.
  */
      public void updateIndustry(String updateIndustryName, String industryName)
    {
        String queryStr;
        
        try
        {
            rs = st.executeQuery("SELECT COUNT(*) FROM industries WHERE industryName='" + industryName + "'");
            rs.next();

                    if (updateIndustryName.length() > 0 && (updateIndustryName.length() < 35) && (!StringUtils.isEmptyOrWhitespaceOnly(updateIndustryName)))  
                    {
                        queryStr = "UPDATE industries SET industryName='" + updateIndustryName + "'" + 
                                   " WHERE industryName='" + industryName + "'";
                        st.executeUpdate(queryStr);
                        this.message = "'" + industryName + "' has been updated to '" + updateIndustryName + "' in the database.";
                        this.succesful = true;
                    }
                    else if (updateIndustryName.length() > 35)
                    {
                       this.message = "Error: Discipline name must be less than 35 characters.";
                       this.succesful =  false; 
                    }
                    else  if (StringUtils.isEmptyOrWhitespaceOnly(updateIndustryName))
                    {
                        this.message = "Error: You must enter a discipline name in the text field.";
                        this.succesful =  false;
                    }
                
                else
                {
                    this.message = "Error: " + "A record for '" + updateIndustryName + 
                                   "' already exists in the database.";
                    this.succesful =  false;
                }
                
        } catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
            this.succesful = false;
        }

        }
      public String getMessage()
    {
        return message;
    }
    
    public boolean getSuccesful()
    {
        return succesful;
    }
    
    /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * Used to remove an industry using industryID.
   * @param industryID
   */
  public void removeIndustry(int industryID)
    {
        try
        {
            String queryStr = "DELETE FROM industries WHERE industryID=" + industryID;
            st.executeUpdate(queryStr);
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
} // end of class





