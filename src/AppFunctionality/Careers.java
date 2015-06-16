
package AppFunctionality;
import java.sql.*;

/**
 *
 * @author Kevin Ewald
 */
public class Careers {
    private Connection con;
    private ResultSet rs;
    private Statement st;
    
    
    private String industryName;
    
    public Careers()
    {
        industryName = null;
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
    
    /**
     * <h3>@author Kevin Ewald</h3>
     * <strong>Purpose: </strong><br />
     * Used to display a list of all careers associated with
     * the supplied disciplineID.<br />
     * <strong>Note: </strong>The disciplineID can be obtained through the
     * <code>getDisciplineIDByName</code> method of the Disciplines Class.
     * @param industryID
     * @return ResultSet
     */
    public ResultSet listCareers(int disciplineID)
    {
        try
        {
            String queryStr = "SELECT * FROM careers WHERE disciplineID='" + disciplineID + "'" +
                               "ORDER BY careerName ASC";
            rs = st.executeQuery(queryStr);
            return rs;
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
      return null;
    } // end of listCareers method
    
    public ResultSet listCareerInfo(String careerName)
    {
        try
        {
            String queryStr = "SELECT * FROM careers WHERE careerName='" + careerName + "'" +
                               "ORDER BY careerName ASC";
            rs = st.executeQuery(queryStr);
            return rs;
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
      return null;
    }
    
    public ResultSet listCareersInDemand(int industryID)
    {
        try
        {
            String queryStr = "SELECT * FROM careers WHERE industryID='" + industryID + "' AND inDemand='Yes'" +
                               "ORDER BY careerName ASC";
            rs = st.executeQuery(queryStr);
            return rs;
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
      return null;
    } // end of listCareers method
    
    public void removeCareer(String careerName)
    {
        try
        {
            String execStr = "DELETE FROM `careers` WHERE careerName='" + careerName + "'";
            st.executeUpdate(execStr);
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    public boolean queryDBForCareerName(String careerName)
    {
        boolean isValid;
       try
       {  
        // count the number of rows that contain the careerName the user entered
        rs = st.executeQuery("SELECT COUNT(*) FROM careers WHERE careerName='" + careerName + "'");
        rs.next();
        int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
            if (matchCount == 0) // 0 means the careerName is not found in the careers table
               isValid = true;
            else
                isValid = false;
       } 
       catch (Exception ex) 
       {       
        System.out.println("Error: " + ex.getMessage());
        isValid = false;
       } // end of try/catch
      return isValid;
    } // end of queryDBForcareerName
    
    
    public void addCareer(int disciplineID, String careerName, String description, String inDemand)
    {
        try
        {
            String queryStr = "INSERT INTO `careers`(`disciplineID`, `careerName`, `description`, `inDemand`) VALUES ('" + disciplineID +"','" + careerName + "','" + description + "','" + inDemand + "')";
            st.executeUpdate(queryStr);
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void updateCareer(String careerName, String description, String inDemand, String originalCareerName)
    {
        try
        {
            String queryStr = "UPDATE `careers` SET `careerName`='" + careerName + "',`description`='" + description + "',`inDemand`='" + inDemand + "' "
            + "WHERE careerName='" + originalCareerName + "'";
            st.executeUpdate(queryStr);
        } 
        catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
} // end of class
