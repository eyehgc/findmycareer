package Pages.Admin;
import java.sql.*;
import Admin.CalculateDate;
import AppFunctionality.Users;
import javax.swing.ListSelectionModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Eunice Yeh
 */
public class ListDeactivated extends javax.swing.JFrame {
   Users users;
   ResultSet usersRS;
   CalculateDate calculateDate;
   
        
    /**
     * Creates new form ListDeactivated
     */
    public ListDeactivated() {
        initComponents();
        labelConnectionError.setVisible(false);
        btnRetry.setVisible(false);
        labelMessage.setVisible(false);
        
         try
        {
            users = new Users();
            calculateDate= new CalculateDate();
            String dateReturned = (String) calculateDate.getDateXdaysAgo(30);
            usersRS = users.listRecentlyDeactivatedUsers(dateReturned);
            tableDeactivated.setModel(DbUtils.resultSetToTableModel(usersRS));
            tableDeactivated.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            btnReactivate.setEnabled(false);
        }
        catch(Exception ex)
        {
           //connection error message
           btnRetry.setVisible(true);
           labelConnectionError.setVisible(true);          
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelConnectionError = new javax.swing.JLabel();
        btnRetry = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDeactivated = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        btnReactivate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        labelMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("List Deactivated Accounts");

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recently deactivated accounts");

        labelConnectionError.setForeground(new java.awt.Color(255, 255, 255));
        labelConnectionError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelConnectionError.setText("Error: Unable to connect to database, please check your connection");

        btnRetry.setText("Retry");
        btnRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetryActionPerformed(evt);
            }
        });

        tableDeactivated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "Email", "Date Deactivated"
            }
        ));
        tableDeactivated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDeactivatedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDeactivated);
        if (tableDeactivated.getColumnModel().getColumnCount() > 0) {
            tableDeactivated.getColumnModel().getColumn(0).setHeaderValue("Last Name");
            tableDeactivated.getColumnModel().getColumn(1).setHeaderValue("First Name");
            tableDeactivated.getColumnModel().getColumn(2).setHeaderValue("Email");
            tableDeactivated.getColumnModel().getColumn(3).setHeaderValue("Date Deactivated");
        }

        btnReactivate.setText("Reactivate");
        btnReactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactivateActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_action_refresh2.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        labelMessage.setForeground(new java.awt.Color(255, 255, 255));
        labelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMessage.setText("This label  is not displayed by default");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReactivate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(labelConnectionError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRetry, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReactivate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(labelMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelConnectionError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetry)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetryActionPerformed
        // TODO add your handling code here:
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        ListDeactivated listDeactivated = new ListDeactivated(); // creates a new window identical to the current window
        dispose(); // disposes of the old window
        listDeactivated.setVisible(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRetryActionPerformed

    private void btnReactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactivateActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedRowIndex = tableDeactivated.getSelectedRow();
        String emailSelected = (String) tableDeactivated.getModel().getValueAt(selectedRowIndex, 2);
        String firstName = (String)tableDeactivated.getModel().getValueAt(selectedRowIndex,1);
        String lastName = (String)tableDeactivated.getModel().getValueAt(selectedRowIndex,0);
        users = new Users();
        users.reactivateUser(emailSelected);
        labelMessage.setText("" + firstName+" "+lastName + "'s account has been reactivated.");
        labelMessage.setVisible(true);
    }//GEN-LAST:event_btnReactivateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:

        try
        {
            users = new Users();
            calculateDate= new CalculateDate();
            String dateReturned = (String) calculateDate.getDateXdaysAgo(30);
            usersRS = users.listRecentlyDeactivatedUsers(dateReturned);
            tableDeactivated.setModel(DbUtils.resultSetToTableModel(usersRS));
            tableDeactivated.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            btnReactivate.setEnabled(false);
        }
        catch(Exception ex)
        {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            btnRetry.setVisible(true);
            labelConnectionError.setVisible(true);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableDeactivatedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeactivatedMouseClicked
        // TODO add your handling code here:
        btnReactivate.setEnabled(true);
    }//GEN-LAST:event_tableDeactivatedMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListDeactivated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListDeactivated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListDeactivated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListDeactivated.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListDeactivated().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReactivate;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRetry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelConnectionError;
    private javax.swing.JLabel labelMessage;
    private javax.swing.JTable tableDeactivated;
    // End of variables declaration//GEN-END:variables

    private String String(String dateReturned) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
