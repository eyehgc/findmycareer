 /**
     * @author Yusuf Bhyat - 4105558614
     *
     * Purpose: Sets up connection to the DB
     * 
     *
     */

package AppFunctionality;

import java.sql.*;
import javax.swing.*;


public class MySQLConnectYB {

    Connection conn = null;

    public static Connection ConnectDB() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/findmycareer", "root", "");
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;

        }

    }

}
