
package AppFunctionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


/**
 *
 * @author Kevin Ewald
 */
public class Courses {
    private Connection con;
    private Statement st;
    private ResultSet rs;
   
public Courses()
{
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/findmycareer","root",""); 
        st = con.createStatement();
        
    } catch (Exception ex)
    {
       
    }
} // end of constructor

public ResultSet listAllCoursesByDisciplineID(int disciplineID)
{
    try
    {
       String queryStr = "SELECT * FROM courses WHERE disciplineID=" + disciplineID + 
               " ORDER BY courseName ASC";
       rs = st.executeQuery(queryStr);
       return rs;
    } catch(Exception ex)
    {
      System.out.println("Error: " + ex.getMessage()); 
      return null;
    }    
}

public boolean checkIfCourseNameExists(String courseName)
{
    boolean isValid = false;
    try
       {  
            // count the number of rows that contain the email address the user entered
            rs = st.executeQuery("SELECT COUNT(*) FROM courses WHERE courseName='" + courseName + "'");
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

public int getDisciplineIDByCourseName(String courseName)
{
   try
        {
            String queryStr = "SELECT disciplineID FROM courses WHERE courseName='" + courseName + "'";
            rs = st.executeQuery(queryStr);            
                if(rs.next())
                {
                    int id = rs.getInt(1);
                    return id;
                }            
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
      return 0; 
}

public ResultSet listAllCourses()
{
    try
    {
       String queryStr = "SELECT * FROM courses ORDER BY courseName ASC";
       rs = st.executeQuery(queryStr);
       return rs;
    } catch(SQLException ex)
    {
      System.out.println("Error: " + ex.getMessage());  
    }
    return null;
}

public void addCourse(int disciplineID, String courseName)
{
    try
    {
    String queryStr = "INSERT INTO `courses`(`disciplineID`, `courseName`) VALUES ('" + disciplineID + "','" + courseName + "')";
    st.executeUpdate(queryStr);
    }
    catch(SQLException ex)
    {
        System.out.println("Error: " + ex.getMessage());
    }
}

public void updateCourse(String newCourseName, String originalCourseName)
{
    try
    {
    String queryStr = "UPDATE `courses` SET `courseName`='" + newCourseName + "' WHERE courseName='" + originalCourseName + "'";
    st.executeUpdate(queryStr);
    }
    catch(SQLException ex)
    {
        System.out.println("Error: " + ex.getMessage());
    }
}

public void removeCourse(String courseName)
{
    try
    {
    String queryStr = "DELETE FROM `courses` WHERE courseName='" + courseName + "'";
    st.executeUpdate(queryStr);
    }
    catch(SQLException ex)
    {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
}
