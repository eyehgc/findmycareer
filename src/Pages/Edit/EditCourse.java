

package Pages.Edit;

import AppFunctionality.Courses;
import java.awt.Color;
import java.sql.ResultSet;

/**
 *
 * @author Kevin Ewald
 */
public class EditCourse extends javax.swing.JFrame {
    
    Courses courses;
    
    ResultSet coursesRS;

    /**
     * Creates new form EditCourse
     */
    public EditCourse() {
        initComponents();
        labelNewCourseName.setEnabled(false);
        txtNewCourseName.setEnabled(false);
        btnUpdate.setEnabled(false);
        labelMessage.setVisible(false);
        labelValidationmessage.setVisible(false);
        
        try
        {
            courses = new Courses();
            coursesRS = courses.listAllCourses();
            comboCourse.removeAllItems();
            comboCourse.addItem("- Select -");
            while(coursesRS.next())
            {
                String courseName = coursesRS.getString("courseName");
                comboCourse.addItem(courseName);
            }
        }
        catch(Exception ex)
        {
            
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
        labelCourseName = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox();
        labelNewCourseName = new javax.swing.JLabel();
        txtNewCourseName = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        labelMessage = new javax.swing.JLabel();
        btnRefreshList = new javax.swing.JButton();
        labelValidationmessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Course");

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Edit Course");

        labelCourseName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCourseName.setForeground(new java.awt.Color(255, 255, 255));
        labelCourseName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCourseName.setText("Course Name:");

        comboCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });

        labelNewCourseName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNewCourseName.setForeground(new java.awt.Color(255, 255, 255));
        labelNewCourseName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNewCourseName.setText("New Course Name:");

        txtNewCourseName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewCourseNameKeyReleased(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        labelMessage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelMessage.setForeground(new java.awt.Color(255, 255, 255));
        labelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMessage.setText("message");
        labelMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMessageMouseClicked(evt);
            }
        });

        btnRefreshList.setText("Refresh List");
        btnRefreshList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshListActionPerformed(evt);
            }
        });

        labelValidationmessage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelValidationmessage.setForeground(new java.awt.Color(255, 255, 255));
        labelValidationmessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelValidationmessage.setText("This course already exists");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNewCourseName)
                            .addComponent(labelCourseName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelValidationmessage))))
                    .addComponent(labelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefreshList)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCourseName)
                    .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshList))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(labelNewCourseName)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(labelValidationmessage))
                .addGap(18, 18, 18)
                .addComponent(labelMessage)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseActionPerformed
        // TODO add your handling code here:
        int index = comboCourse.getSelectedIndex();
        if(index > 0)
        {
           String courseChosen = (String) comboCourse.getSelectedItem();
           txtNewCourseName.setText(courseChosen);
           labelNewCourseName.setEnabled(true);
           txtNewCourseName.setEnabled(true);
           labelCourseName.setEnabled(false);
           labelValidationmessage.setForeground(new java.awt.Color(204, 0, 0));
           labelValidationmessage.setText("Course already Exists");
           labelValidationmessage.setVisible(true);
           btnUpdate.setEnabled(false);
        }
        else
        {
            txtNewCourseName.setText("");
            txtNewCourseName.setEnabled(false);
            labelNewCourseName.setEnabled(false);
            labelCourseName.setEnabled(true);
            btnUpdate.setEnabled(false);
        }
    }//GEN-LAST:event_comboCourseActionPerformed

    private void txtNewCourseNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewCourseNameKeyReleased
        // TODO add your handling code here:
        String courseEntered = txtNewCourseName.getText();
        int length = courseEntered.length();
        if(length < 5)
        {
            labelValidationmessage.setForeground(new java.awt.Color(204, 0, 0));
            labelValidationmessage.setText("Course name too short");
            labelValidationmessage.setVisible(true);
            btnUpdate.setEnabled(false);
        }
        else if (length > 60)
        {
            int amountOver = length - 60;
            labelValidationmessage.setForeground(new java.awt.Color(204, 0, 0));
            labelValidationmessage.setText("Course name " + amountOver + " Characters too Long");
            labelValidationmessage.setVisible(true);
            btnUpdate.setEnabled(false);
        }
        else
        {
            try
            {
                Courses courses = new Courses();
                if(courses.checkIfCourseNameExists(courseEntered) == false)
                {
                    labelValidationmessage.setForeground(new java.awt.Color(204, 0, 0));
                    labelValidationmessage.setText("Course already Exists");
                    labelValidationmessage.setVisible(true);
                    btnUpdate.setEnabled(false);
                }
                else
                {
                    labelValidationmessage.setForeground(new java.awt.Color(0, 204, 51));
                    labelValidationmessage.setText("Course name Valid");
                    labelValidationmessage.setVisible(true);
                    btnUpdate.setEnabled(true);
                }
            }
            catch(Exception ex){}
        }
//        else    
//            btnUpdate.setEnabled(true);
    }//GEN-LAST:event_txtNewCourseNameKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String originalCourseName = (String) comboCourse.getSelectedItem();
        String newCourseName = txtNewCourseName.getText();

        try
        {
            courses = new Courses();
            courses.updateCourse(newCourseName, originalCourseName);
            labelMessage.setForeground(new java.awt.Color(255, 255, 255));
            labelMessage.setText("'" + originalCourseName + "' has been changed to '" + newCourseName + "' (click to hide)");
            labelMessage.setVisible(true);
        } 
        catch(Exception ex)
        {
            labelMessage.setForeground(new java.awt.Color(204, 0, 0));
            labelMessage.setText("Error: update failed. please check your connection (click to hide)");
            labelMessage.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void labelMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMessageMouseClicked
        // TODO add your handling code here:
        labelMessage.setVisible(false);
    }//GEN-LAST:event_labelMessageMouseClicked

    private void btnRefreshListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshListActionPerformed
        // TODO add your handling code here:
        labelNewCourseName.setEnabled(false);
        txtNewCourseName.setEnabled(false);
        btnUpdate.setEnabled(false);
        labelMessage.setVisible(false);
        
        try
        {
            courses = new Courses();
            coursesRS = courses.listAllCourses();
            comboCourse.removeAllItems();
            comboCourse.addItem("- Select -");
            while(coursesRS.next())
            {
                String courseName = coursesRS.getString("courseName");
                comboCourse.addItem(courseName);
            }
        }
        catch(Exception ex)
        {
            
        }
    }//GEN-LAST:event_btnRefreshListActionPerformed

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
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefreshList;
    public javax.swing.JButton btnUpdate;
    public javax.swing.JComboBox comboCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel labelCourseName;
    public javax.swing.JLabel labelMessage;
    public javax.swing.JLabel labelNewCourseName;
    private javax.swing.JLabel labelValidationmessage;
    public javax.swing.JTextField txtNewCourseName;
    // End of variables declaration//GEN-END:variables
}
