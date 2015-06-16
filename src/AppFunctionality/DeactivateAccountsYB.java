/**
 * @author Yusuf Bhyat - 4105558614
 *
 * Purpose: This class will run when the application starts up. It will
 * deactivate accounts not used for more than 183 days (6 months)
 *
 *
 */
package AppFunctionality;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class DeactivateAccountsYB {

    public DeactivateAccountsYB() {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        conn = MySQLConnectYB.ConnectDB();

        try {

            String sql = "select lastActive, accountStatus from users";

            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                String lastActive = rs.getString("lastActive");
                String accountStatus = rs.getString("accountStatus");

                System.out.println(lastActive + " " + accountStatus);

                //only checks for active accounts                
                if (accountStatus.contentEquals("Active")) {

                    Calendar cal = Calendar.getInstance();
                    Date today = cal.getTime();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    cal.setTime(dateFormat.parse(lastActive));
                    Date birthday = cal.getTime();

                    long dateSubtract = today.getTime() - birthday.getTime();
                    long time = 1000 * 60 * 60 * 24;
                    long days = dateSubtract / time;
                    System.out.println(days + " Days");

                    //cast Days (Long) to int
                    int daysL = (int) days;

                    //sets accountStatus to Inactive for accounts not used for more than 183 days
                    if (daysL > 183) {

                        // sets date for DOB
                        //get current date time with Date()
                        Date date = new Date();

                        try {

                            String update;
                            update = "UPDATE users SET accountStatus = ?, dateDeactivated = ? where lastActive = ?";

                            PreparedStatement preStatement3 = conn.prepareStatement(update);
                            preStatement3.setString(1, "Inactive");
                            preStatement3.setString(2, dateFormat.format(date));
                            preStatement3.setString(3, lastActive);

                            int i = preStatement3.executeUpdate();

                        } catch (Exception e) {

                            JOptionPane.showMessageDialog(null, e);
                        }

                    } // end of active check

                } //end of 183 days check

            } // end of while next line

        } catch (SQLException | ParseException | HeadlessException e) {
        }
    }
}
