
package AppFunctionality;
import java.sql.*;

/**
 * @author Kevin Ewald
 */
public class Careers2Courses {
    private Connection con;
    private ResultSet rs;
    private Statement st;
    
    public Careers2Courses()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/findmycareer","root",""); 
            st = con.createStatement();  
        } 
        catch (Exception ex)
        {

        }
    } // end of constructor
    
    public ResultSet listCareerOutcomeByCourse(String courseName)
    {
        try
        {
           String queryStr = "SELECT * FROM careers2courses WHERE courseName='" + courseName + 
                   "' ORDER BY careerName ASC";
           rs = st.executeQuery(queryStr);
           return rs;
        } 
        catch(Exception ex)
        {
          System.out.println("Error: " + ex.getMessage()); 
          return null;
        }
    }
    
    public boolean checkIfLinkExists(String courseName, String careerName)
    {
        boolean alreadyExists;
       try
       {  
        // count the number of rows that contain the careerName the user entered
        rs = st.executeQuery("SELECT COUNT(*) FROM careers2courses WHERE courseName='" + courseName + "' AND careerName='" + careerName + "'");
        rs.next();
        int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
            if (matchCount == 0) // 0 means the careerName is not found in the careers table
               alreadyExists = false;
            else
                alreadyExists = true;
       } 
       catch (Exception ex) 
       {       
        System.out.println("Error: " + ex.getMessage());
        alreadyExists = false;
       } // end of try/catch
      return alreadyExists;
    }
    
    public void linkCareer2Course(String courseName, String careerName)
    {
        try
        {
        String queryStr = "INSERT INTO `careers2courses`(`courseName`, `careerName`) VALUES ('" + courseName + "','" + careerName + "')";
        st.executeUpdate(queryStr);
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void removeCareerOutcome(String courseName, String courseOutcome)
    {
        try
        {
        String queryStr = "DELETE FROM `careers2courses` WHERE courseName='" + courseName +"' AND careerName='" + courseOutcome + "'";
        st.executeUpdate(queryStr);
        }
        catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
