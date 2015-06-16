
package Registration;

/**
 *
 * @author Big Kev
 */
public class PasswordValidation {
    private String password1;
    private String password2;
    private Boolean isValid;
    private String message;

    /**
     *
     */
    public PasswordValidation()
    {
        this.password1 = null;
        this.password2 = null;
        this.isValid = false;
        this.message = "No Password has been set.";
    }
    /**
     *<h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong>
     * Used to check that the password and confirmation password the user entered
     * when registering an account meets the requirements. 6 - 20 characters 
     * and contains no spaces.<br />
     * <strong>NOTE:</strong> Use checkValid() method in order to return the boolean value 
     * created by this method.
     * Use returnMessage() method to return the message created by this method.
     * @param password1     The password the user entered
     * @param password2     The password confirmation the user entered
     */
    public void passwordValidation(String password1, String password2)
    {
        if (password1.equals(password2)) // ensure the passwords match, if they do, enter the loop and check their length
        {
            int lengthCheck = password1.length(); // only need to check the length of one password since both have been confirmed to be the same
            if (lengthCheck >= 6 && lengthCheck <= 20)
            {
                if (!password1.contains(" ")) // checks if password contains a blank space (uses !/not operator) 
                {
                    isValid = true; // all criteria is met isValid set to true
                    message = ""; // set an empty message string
                } 
                else // if password DOES contain spaces
                {
                    isValid = false; // sets isValid to false if password contains space
                    message = "Password must not contain spaces";
                }
            }
            else // if lengthCheck test is not passed
            {
                isValid = false; // invalid length, isValid set to false
                if (lengthCheck > 20)
                    message = "Password is too long. Must be between 6 - 20 charactes in length.";
                else
                    message = "Password is too short. Password must be between 6 - 20 characters in length";
            }
        } // end of outter if loop
        else // if passwords do not match
        {
            isValid = false; // sets isValid to false if passwords do not match
            message = "The passwords you entered do not match. Please try again.";
        }
        this.password1 = password1; // stored the value of password one in the variable so it can be returned by the getPassword() method
    } // end of passwordValidation 

    /**
     * <h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong>
     * Used to return the boolean value of isValid after the
     * passwordValidation method has been run
     * 
     * @return Boolean
     */
    public Boolean checkValid()
    {
        return isValid;
    }
    
    /**
     * <h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong>
     * <span>Used to return an appropriate message if the password was NOT valid.</span>
     * @return String
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * <h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong>
     * <span>Returns the first password the user entered as a string<br />
     * <strong>Note: </strong> you must use the passwordValidation method before calling this method or the password will be returned as an empty string.</span>
     * @return String
     */
    public String getPassword()
    {
        return password1;
    }
    
    
    /**
     *<h3>@author Kevin Ewald</h3>
     * <strong>Purpose:</strong>
     * <span>Override toString method used to display all current values
     * stored by password1, message and isValid.</span>
     * @return String
     */
    @Override
    public String toString()
    {
        return    "============================================\n"
                + "Current isValid State: " + checkValid() + "\n"
                + "Current Message: " + getMessage() +  "\n"
                + "Current Password Set: " + getPassword() + "\n"
                + "============================================\n";
    }
}
