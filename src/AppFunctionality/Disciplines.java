
package AppFunctionality;

import com.mysql.jdbc.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kevin Ewald, Sasha Graham, Eunice Yeh
 */
public class Disciplines {
    
    private Connection con;
    private ResultSet rs;
    private Statement st;
    
    
    private String industryName;
    private String message;
    private boolean succesful;
    
    public Disciplines()
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
    
    public ResultSet listDisciplinesByIndustryID(int industryID)
    {
        try
        {
            String queryStr = "SELECT * FROM disciplines WHERE industryID='" + industryID + "'" +
                               "ORDER BY disciplineName ASC";
            rs = st.executeQuery(queryStr);
            return rs;
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
      return null;
    }
    
    public ResultSet listAllDisciplines()
    {
        try
        {
            String queryStr = "SELECT * FROM disciplines ORDER BY disciplineName asc";
            rs = st.executeQuery(queryStr);
            return rs;
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
      return null;
    }
    
    public ResultSet listDisciplinesByName(String disciplineName)
    {
        try
        {
            String queryStr = "SELECT * FROM disciplines WHERE disciplineName='" + disciplineName + "'" +
                               "ORDER BY disciplineName ASC";
            rs = st.executeQuery(queryStr);
            return rs;
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
      return null;
    }
    
    public int getDisciplineIDByName(String disciplineName)
    {
        try
        {
            String queryStr = "SELECT disciplineID FROM disciplines WHERE disciplineName='" + disciplineName + "'";
            rs = st.executeQuery(queryStr);            
                if(rs.next())
                {
                    int id = rs.getInt(1);
                    return id;
                }            
        } catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
      return 0;
    }
    
    /**
     * @author Kevin Ewald
     * @param email
     * @param disciplineSelected 
     */
    public void recordDisciplineSelected(String email, String disciplineSelected)
    {
        int hits;
        try
        {
            rs = st.executeQuery("SELECT COUNT(*) FROM usageData WHERE email='" + email + "' AND disciplineViewed='" + disciplineSelected + "'");
            rs.next();
            int matchCount = rs.getInt(1); // get the first result in the returned array (there will only be 1)
            if (matchCount > 0)
            {
                String queryStr = "SELECT hits FROM usageData WHERE email='" + email + "' AND disciplineViewed='" + disciplineSelected + "'";
                rs = st.executeQuery(queryStr);            
                rs.next();
                    hits = rs.getInt("hits");
                    hits++;
                queryStr = "UPDATE `usagedata` SET `hits`='" + hits + "' WHERE email='" + email + "' AND disciplineViewed='" + disciplineSelected + "'";
                st.executeUpdate(queryStr);
            }
            else
            {
                st.executeUpdate("INSERT INTO `usagedata`(`email`, `disciplineViewed`, `hits`) "
                                + "VALUES ('" + email + "','" + disciplineSelected + "'," + 1 + ")");
            }
        } 
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    
    /**
   * @Author: Sasha Graham
   * Purpose: This SLQ statement is used to update the discipline name
   *          in the disciplines table to whatever the admin wants to 
   *          set it to.
  */
    
    public void updateDiscipline(String updateDisciplineName, String disciplineName)
    {
        String queryStr;
        
        try
        {
            rs = st.executeQuery("SELECT COUNT(*) FROM disciplines WHERE disciplineName='" + disciplineName + "'");
            rs.next();

                    if (updateDisciplineName.length() > 0 && (updateDisciplineName.length() < 35) && (!StringUtils.isEmptyOrWhitespaceOnly(updateDisciplineName)))  
                    {
                        queryStr = "UPDATE disciplines SET disciplineName='" + updateDisciplineName + "'" + 
                                   " WHERE disciplineName='" + disciplineName + "'";
                        st.executeUpdate(queryStr);
                        this.message = "'" + disciplineName + "' has been updated to '" + updateDisciplineName + "' in the database.";
                        this.succesful = true;
                    }
                    else if (updateDisciplineName.length() > 35)
                    {
                       this.message = "Error: Discipline name must be less than 35 characters.";
                       this.succesful =  false; 
                    }
                    else  if (StringUtils.isEmptyOrWhitespaceOnly(updateDisciplineName))
                    {
                        this.message = "Error: You must enter a discipline name in the text field.";
                        this.succesful =  false;
                    }
                
                else
                {
                    this.message = "Error: " + "A record for '" + updateDisciplineName + 
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
   * This method is used to make sure 
   * the discipline does not already exist
   * in the database.
   * 
   * @param disciplineName
   */
    public boolean queryDBForDiscipline(String disciplineName)
    {
        boolean isValid;
       try
       {  
        // count the number of rows that contain the careerName the user entered
        rs = st.executeQuery("SELECT COUNT(*) FROM disciplines WHERE disciplineName='" + disciplineName + "'");
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
    } // end of queryDBForDisciplineName

   /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * This method is used to add
   * a discipline into the database.
   * 
   */
    public void addDiscipline(int industryID, String disciplineEntered, String skillsEntered)
    {
        try
        {
            String queryStr = "INSERT INTO disciplines(industryID, disciplineName, essentialSkills) VALUES ('" + industryID +"','" + disciplineEntered + "','" + skillsEntered + "')";
            st.executeUpdate(queryStr);
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
  
   /**
   * <h3>@author Eunice Yeh</h3>
   * <strong>Purpose:</strong><br />
   * This method is used to remove 
   * a discipline from the database.
   * 
   */
  public void removeDiscipline(int disciplineID)
    {
        try
        {
            String queryStr = "DELETE FROM disciplines WHERE disciplineID=" + disciplineID;
            st.executeUpdate(queryStr);
        } catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
