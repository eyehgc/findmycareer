
package Admin;

import java.text.DateFormat;
import java.util.Calendar;

/**
 *
 * <h3>@author Kevin Ewald</h3>
 * <strong>Purpose:</strong><br />
 * This class is used to calculate a past or future date by subtracting or adding
 * X (months | days | years) from the current date.
 * 
 */
public class CalculateDate {
    private Calendar date;
    private DateFormat dateFormat;
    
    public CalculateDate() // constructor
    {  
        date = Calendar.getInstance();        
    }
    
    /**
     * <h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong><br />
     * Used to subtract X amount of years from the current date.
     * Returns a string containing the resulting date.
     * @param years
     * @return String
     */
    public String getDateXyearsAgo(int years)
    {    
    date = Calendar.getInstance();
    date.add(Calendar.YEAR, -years);
    
    int year = date.get(Calendar.YEAR);
    int month = (date.get(Calendar.MONTH) + 1);
    int day = date.get(Calendar.DATE);
    
    String result = year + "-" + month + "-" + day;
    
    return result;
    }
    
    /**
     * <h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong><br />
     * Used to subtract X amount of months from the current date.
     * Returns a string containing the resulting date.
     * @param months
     * @return String
     */
    public String getDateXmonthsAgo(int months)
    {
    date = Calendar.getInstance();
    date.add(Calendar.MONTH, -months);
    
    int year = date.get(Calendar.YEAR);
    int month = (date.get(Calendar.MONTH) + 1);
    int day = date.get(Calendar.DATE);
    
    String result = year + "-" + month + "-" + day;
    
    return result;
    }
    
    /**
     * <h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong><br />
     * Used to subtract X amount of days from the current date.
     * Returns a string containing the resulting date.
     * @param days
     * @return String
     */
    public String getDateXdaysAgo(int days)
    {
    //Calendar date = Calendar.getInstance();

    date = Calendar.getInstance();
    date.add(Calendar.DATE, -days);
    
    int year = date.get(Calendar.YEAR);
    int month = (date.get(Calendar.MONTH) + 1);
    int day = date.get(Calendar.DATE);
    
    String result = year + "-" + month + "-" + day;
    
    return result;
    }
    
    public String addXyearsToCurrentDate(int years)
    {
    //Calendar date = Calendar.getInstance();

    date = Calendar.getInstance();
    date.add(Calendar.YEAR, +years);
    
    int year = date.get(Calendar.YEAR);
    int month = (date.get(Calendar.MONTH) + 1);
    int day = date.get(Calendar.DATE);
    
    String result = year + "-" + month + "-" + day;
    
    return result;
    }
    
    public String addXmonthsToCurrentDate(int months)
    {
    //Calendar date = Calendar.getInstance();

    date = Calendar.getInstance();
    date.add(Calendar.MONTH, +months);
    
    int year = date.get(Calendar.YEAR);
    int month = (date.get(Calendar.MONTH) + 1);
    int day = date.get(Calendar.DATE);
    
    String result = year + "-" + month + "-" + day;
    
    return result;
    }
    
    public String addXdaysToCurrentDate(int days)
    {
    //Calendar date = Calendar.getInstance();

    date = Calendar.getInstance();
    date.add(Calendar.DATE, +days);
    
    int year = date.get(Calendar.YEAR);
    int month = (date.get(Calendar.MONTH) + 1);
    int day = date.get(Calendar.DATE);
    
    String result = year + "-" + month + "-" + day;
    
    return result;
    }

   
    
}
