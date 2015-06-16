
package Pages;

import Pages.Admin.UserAdministrationYB;
import Pages.Remove.RemoveCourse;
import Pages.Edit.EditCourse;
import Pages.Edit.EditCareer;
import Pages.Add.AddIndustry;
import Pages.Add.AddCourse;
import Pages.Add.AddCareer2Course;
import Pages.Add.AddCareer;
import AppFunctionality.*;
import Pages.Add.AddDiscipline;
import Pages.Admin.AddAdmin;
import Pages.Admin.ListDeactivated;
import Pages.Admin.RemoveAdmin;
import Pages.Edit.UpdateDiscipline;
import Pages.Edit.UpdateIndustry;
import Pages.Remove.RemoveCareer;
import Pages.Remove.RemoveCourseOutcome;
import Pages.Remove.RemoveDiscipline;
import Pages.Remove.RemoveIndustry;
import java.awt.CardLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kevin Ewald
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     * 
     */
    Careers careers;
    Careers2Courses c2c;
    Courses courses;
    Disciplines disciplines;
    Industries industries;

    
    ResultSet careersRS;
    ResultSet c2cRS;
    ResultSet coursesRS;
    ResultSet disciplinesRS;
    ResultSet industriesRS;
    
    // pages which are opened from menu bar
    AddIndustry addIndustryPage;
    AddCareer addCareerPage;
    AddCourse addCoursePage;
    AddCareer2Course career2coursePage;
    EditCareer editCareerPage;
    EditCourse editCoursePage;
    RemoveCourse removeCoursePage;
    RemoveCourseOutcome removeCourseOutcomePage;
    UpdateIndustry updateIndustryPage;
    UpdateDiscipline updateDisciplinePage;
    RemoveIndustry removeIndustryPage;
    RemoveDiscipline removeDisciplinePage;
    AddDiscipline addDisciplinePage;
    RemoveAdmin removeAdminPage;
    ListDeactivated listDeactivatedPage;
    UserAdministrationYB userAdminPage;
    RemoveCareer removeCareerPage;
    AddAdmin addAdminPage;
    BonusFeatures bonusFeaturesPage;
    
    // get the email and account type from the below page
    String accountType = UserInformationSummaryGlobalVariablesYB.lblAccType.getText();
    String email = UserInformationSummaryGlobalVariablesYB.lblEMail.getText();
    String name = UserInformationSummaryGlobalVariablesYB.lblFName.getText();

    
    public MainPage() {
        initComponents();
        comboIndustries.setEnabled(true);
        comboIndustries.removeAllItems();
        comboIndustries.addItem("- Select -");
        labelSelectIndustry.setEnabled(true);
        
        comboDiscipline.setEnabled(false);
        comboDiscipline.removeAllItems();
        comboDiscipline.addItem("- Select -");
        labelSelectDiscipline.setEnabled(false);
        
        comboSelectOption.setEnabled(false);
        comboSelectOption.removeAllItems();
        comboSelectOption.addItem("- Select -");
        labelOption.setEnabled(false);
        
        comboSelectCourse.setVisible(false);
        comboSelectCourse.removeAllItems();
        comboSelectCourse.addItem("- Select -");
        labelSelectCourse.setVisible(false);
        
        comboSelectCareer.setVisible(false);
        comboSelectCareer.removeAllItems();
        comboSelectCareer.addItem("- Select -");
        labelSelectCareer.setVisible(false);
        
        btnRetryConnection.setVisible(false);
        labelConnectError.setVisible(false);
        
        // create the pages now so that the close all other windows menu option will work
        addIndustryPage = new AddIndustry();
        addIndustryPage.setVisible(false);
        addIndustryPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addCareerPage = new AddCareer();
        addCareerPage.setVisible(false);
        addCareerPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addCoursePage = new AddCourse();
        addCoursePage.setVisible(false);
        addCoursePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        career2coursePage = new AddCareer2Course();
        career2coursePage.setVisible(false);
        career2coursePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        editCareerPage = new EditCareer();
        editCareerPage.setVisible(false);
        editCareerPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        bonusFeaturesPage = new BonusFeatures();
        bonusFeaturesPage.setVisible(false);
        bonusFeaturesPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        editCoursePage = new EditCourse();
        editCoursePage.setVisible(false);
        editCoursePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removeCoursePage = new RemoveCourse();
        removeCoursePage.setVisible(false);
        removeCoursePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removeCourseOutcomePage = new RemoveCourseOutcome();
        removeCourseOutcomePage.setVisible(false);
        removeCourseOutcomePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        updateIndustryPage = new UpdateIndustry();
        updateIndustryPage.setVisible(false);
        updateIndustryPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        updateDisciplinePage = new UpdateDiscipline();
        updateDisciplinePage.setVisible(false);
        updateDisciplinePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removeIndustryPage = new RemoveIndustry();
        removeIndustryPage.setVisible(false);
        removeIndustryPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removeDisciplinePage = new RemoveDiscipline();
        removeDisciplinePage.setVisible(false);
        removeDisciplinePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addDisciplinePage = new AddDiscipline();
        addDisciplinePage.setVisible(false);
        addDisciplinePage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removeAdminPage = new RemoveAdmin();
        removeAdminPage.setVisible(false);
        removeAdminPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        listDeactivatedPage = new ListDeactivated();
        listDeactivatedPage.setVisible(false);
        listDeactivatedPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        userAdminPage = new UserAdministrationYB();
        userAdminPage.setVisible(false);
        userAdminPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removeCareerPage = new RemoveCareer();
        removeCareerPage.setVisible(false);
        removeCareerPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addAdminPage = new AddAdmin();
        addAdminPage.setVisible(false);
        addAdminPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        labelPageRefreshed.setVisible(false);
        labelWelcomeMessage.setText("Welcome Back " + name);
        labelWelcomeMessage2.setText("Welcome Back " + name);
        labelWelcomeMessage3.setText("Welcome Back " + name);
        
        // used to display AdminMenuBar to admin only
        if(accountType.equalsIgnoreCase("Admin"))
            adminMenuBar.setVisible(true);
        else
            adminMenuBar.setVisible(false);
        
        
        try
        {
           industries = new Industries();
           industriesRS = industries.listAllIndustries();
           while (industriesRS.next())
           {
               String industryName = industriesRS.getString("industryName");
               comboIndustries.addItem(industryName);
           }
        }
        catch(Exception ex)
        {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            comboIndustries.setEnabled(false);
            labelSelectIndustry.setEnabled(false);
            
            comboDiscipline.setEnabled(false);
            labelSelectDiscipline.setEnabled(false);
            
            comboSelectCareer.setEnabled(false);
            labelSelectCareer.setEnabled(false);
            
            comboSelectOption.setEnabled(false);
            labelOption.setEnabled(false);
            
            comboSelectCourse.setEnabled(false);
            labelSelectCourse.setEnabled(false);
            
            btnRetryConnection.setVisible(true);
            labelConnectError.setVisible(true);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        SelectionPanel = new javax.swing.JPanel();
        panelDisplay = new javax.swing.JPanel();
        comboSelectCareer = new javax.swing.JComboBox();
        comboDiscipline = new javax.swing.JComboBox();
        comboSelectOption = new javax.swing.JComboBox();
        comboIndustries = new javax.swing.JComboBox();
        comboSelectCourse = new javax.swing.JComboBox();
        labelSelectIndustry = new javax.swing.JLabel();
        labelSelectDiscipline = new javax.swing.JLabel();
        labelOption = new javax.swing.JLabel();
        labelSelectCourse = new javax.swing.JLabel();
        labelSelectCareer = new javax.swing.JLabel();
        labelConnectError = new javax.swing.JLabel();
        btnRetryConnection = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnLogout = new javax.swing.JButton();
        labelWelcomeMessage = new javax.swing.JLabel();
        labelPageRefreshed = new javax.swing.JLabel();
        panelDetailsDisplay = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaCareerDescription = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        btnLogout2 = new javax.swing.JButton();
        labelWelcomeMessage2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInDemand = new javax.swing.JTextArea();
        panelSkills = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        btnLogout3 = new javax.swing.JButton();
        labelWelcomeMessage3 = new javax.swing.JLabel();
        btnBackFromEssentialSkills = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaEssentialSkills = new javax.swing.JTextArea();
        adminMenuBar = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        menuAddIndustry = new javax.swing.JMenuItem();
        menuAddDiscipline = new javax.swing.JMenuItem();
        menuAddCareer = new javax.swing.JMenuItem();
        menuAddCourse = new javax.swing.JMenuItem();
        menuAddCareer2Course = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuEditIndustry = new javax.swing.JMenuItem();
        menuEditDiscpline = new javax.swing.JMenuItem();
        menuEditCareer = new javax.swing.JMenuItem();
        menuEditCourse = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuRemoveIndustry = new javax.swing.JMenuItem();
        menuRemoveDiscipline = new javax.swing.JMenuItem();
        menuRemoveCareer = new javax.swing.JMenuItem();
        menuRemoveCourse = new javax.swing.JMenuItem();
        menuRemoveCourseOutcome = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuListDeactivated = new javax.swing.JMenuItem();
        menuUserAccountManagement = new javax.swing.JMenuItem();
        menuAddAdmin = new javax.swing.JMenuItem();
        menuRemoveAdmin = new javax.swing.JMenuItem();
        menuOptions = new javax.swing.JMenu();
        menuRefreshPage = new javax.swing.JMenuItem();
        menuCloseAllOtherWindows = new javax.swing.JMenuItem();
        menuListBonusFeatures = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find My Career - Developed By: Red Team");
        setResizable(false);

        SelectionPanel.setBackground(new java.awt.Color(0, 51, 102));
        SelectionPanel.setLayout(new java.awt.CardLayout());

        panelDisplay.setBackground(new java.awt.Color(0, 51, 102));
        panelDisplay.setAlignmentX(0.0F);
        panelDisplay.setAlignmentY(0.0F);
        panelDisplay.setPreferredSize(new java.awt.Dimension(100, 700));

        comboSelectCareer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSelectCareer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSelectCareer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectCareerActionPerformed(evt);
            }
        });

        comboDiscipline.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDiscipline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboDiscipline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDisciplineActionPerformed(evt);
            }
        });

        comboSelectOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSelectOption.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSelectOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectOptionActionPerformed(evt);
            }
        });

        comboIndustries.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboIndustries.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboIndustries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIndustriesActionPerformed(evt);
            }
        });

        comboSelectCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSelectCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboSelectCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectCourseActionPerformed(evt);
            }
        });

        labelSelectIndustry.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelSelectIndustry.setForeground(new java.awt.Color(255, 255, 255));
        labelSelectIndustry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelectIndustry.setText("Select Industry");

        labelSelectDiscipline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelSelectDiscipline.setForeground(new java.awt.Color(255, 255, 255));
        labelSelectDiscipline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelectDiscipline.setText("Select Discipline");

        labelOption.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelOption.setForeground(new java.awt.Color(255, 255, 255));
        labelOption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOption.setText("Select Option");

        labelSelectCourse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelSelectCourse.setForeground(new java.awt.Color(255, 255, 255));
        labelSelectCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelectCourse.setText("Select Course");
        labelSelectCourse.setToolTipText("");

        labelSelectCareer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelSelectCareer.setForeground(new java.awt.Color(255, 255, 255));
        labelSelectCareer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelectCareer.setText("Possible Careers");

        labelConnectError.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelConnectError.setForeground(new java.awt.Color(255, 255, 255));
        labelConnectError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelConnectError.setText("Error: Unable to connect to the database. Please check your connection");

        btnRetryConnection.setText("Retry");
        btnRetryConnection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRetryConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetryConnectionActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        labelWelcomeMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelWelcomeMessage.setForeground(new java.awt.Color(255, 255, 255));
        labelWelcomeMessage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWelcomeMessage.setText("Welcome! John Smith");

        labelPageRefreshed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPageRefreshed.setForeground(new java.awt.Color(255, 255, 255));
        labelPageRefreshed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPageRefreshed.setText("The page has been refreshed (not displayed by default)");
        labelPageRefreshed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPageRefreshed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPageRefreshedMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelDisplayLayout = new javax.swing.GroupLayout(panelDisplay);
        panelDisplay.setLayout(panelDisplayLayout);
        panelDisplayLayout.setHorizontalGroup(
            panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelDisplayLayout.createSequentialGroup()
                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDisplayLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelWelcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDisplayLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDisplayLayout.createSequentialGroup()
                                .addComponent(labelSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addComponent(labelSelectCareer, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(panelDisplayLayout.createSequentialGroup()
                                .addComponent(comboSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboSelectCareer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(64, 64, 64))
                            .addGroup(panelDisplayLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelSelectIndustry, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                    .addComponent(comboIndustries, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(97, 97, 97)
                                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboDiscipline, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelSelectDiscipline, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboSelectOption, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelOption, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66))))
                    .addGroup(panelDisplayLayout.createSequentialGroup()
                        .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDisplayLayout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(labelConnectError, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDisplayLayout.createSequentialGroup()
                                .addGap(443, 443, 443)
                                .addComponent(btnRetryConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelDisplayLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(labelPageRefreshed, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDisplayLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboSelectCareer, comboSelectCourse});

        panelDisplayLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelSelectCareer, labelSelectCourse});

        panelDisplayLayout.setVerticalGroup(
            panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDisplayLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWelcomeMessage))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(labelPageRefreshed)
                .addGap(18, 18, 18)
                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSelectIndustry)
                    .addComponent(labelSelectDiscipline)
                    .addComponent(labelOption))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboIndustries, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDiscipline, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSelectOption, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSelectCourse)
                    .addComponent(labelSelectCareer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSelectCareer, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(labelConnectError)
                .addGap(18, 18, 18)
                .addComponent(btnRetryConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        panelDisplayLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboDiscipline, comboIndustries, comboSelectOption});

        panelDisplayLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboSelectCareer, comboSelectCourse});

        SelectionPanel.add(panelDisplay, "selection");

        panelDetailsDisplay.setBackground(new java.awt.Color(0, 51, 102));

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setText("Title");

        txtAreaCareerDescription.setEditable(false);
        txtAreaCareerDescription.setBackground(new java.awt.Color(0, 51, 102));
        txtAreaCareerDescription.setColumns(20);
        txtAreaCareerDescription.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAreaCareerDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtAreaCareerDescription.setLineWrap(true);
        txtAreaCareerDescription.setRows(5);
        txtAreaCareerDescription.setWrapStyleWord(true);
        txtAreaCareerDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        txtAreaCareerDescription.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtAreaCareerDescription);

        btnLogout2.setText("Logout");
        btnLogout2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout2ActionPerformed(evt);
            }
        });

        labelWelcomeMessage2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelWelcomeMessage2.setForeground(new java.awt.Color(255, 255, 255));
        labelWelcomeMessage2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWelcomeMessage2.setText("Welcome! John Smith");

        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtAreaInDemand.setBackground(new java.awt.Color(0, 51, 102));
        txtAreaInDemand.setColumns(20);
        txtAreaInDemand.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAreaInDemand.setForeground(new java.awt.Color(255, 255, 255));
        txtAreaInDemand.setLineWrap(true);
        txtAreaInDemand.setRows(5);
        txtAreaInDemand.setWrapStyleWord(true);
        txtAreaInDemand.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Demand", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setViewportView(txtAreaInDemand);

        javax.swing.GroupLayout panelDetailsDisplayLayout = new javax.swing.GroupLayout(panelDetailsDisplay);
        panelDetailsDisplay.setLayout(panelDetailsDisplayLayout);
        panelDetailsDisplayLayout.setHorizontalGroup(
            panelDetailsDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsDisplayLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(panelDetailsDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDetailsDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(panelDetailsDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelWelcomeMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelDetailsDisplayLayout.setVerticalGroup(
            panelDetailsDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetailsDisplayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailsDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWelcomeMessage2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        SelectionPanel.add(panelDetailsDisplay, "careerDetails");

        panelSkills.setBackground(new java.awt.Color(0, 51, 102));

        btnLogout3.setText("Logout");
        btnLogout3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout3ActionPerformed(evt);
            }
        });

        labelWelcomeMessage3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelWelcomeMessage3.setForeground(new java.awt.Color(255, 255, 255));
        labelWelcomeMessage3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWelcomeMessage3.setText("Welcome! John Smith");

        btnBackFromEssentialSkills.setText("Back");
        btnBackFromEssentialSkills.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackFromEssentialSkills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackFromEssentialSkillsActionPerformed(evt);
            }
        });

        txtAreaEssentialSkills.setEditable(false);
        txtAreaEssentialSkills.setBackground(new java.awt.Color(0, 51, 102));
        txtAreaEssentialSkills.setColumns(20);
        txtAreaEssentialSkills.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAreaEssentialSkills.setForeground(new java.awt.Color(255, 255, 255));
        txtAreaEssentialSkills.setLineWrap(true);
        txtAreaEssentialSkills.setRows(5);
        txtAreaEssentialSkills.setText("test text just to see");
        txtAreaEssentialSkills.setWrapStyleWord(true);
        txtAreaEssentialSkills.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Essential Skills", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        txtAreaEssentialSkills.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(txtAreaEssentialSkills);

        javax.swing.GroupLayout panelSkillsLayout = new javax.swing.GroupLayout(panelSkills);
        panelSkills.setLayout(panelSkillsLayout);
        panelSkillsLayout.setHorizontalGroup(
            panelSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(panelSkillsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackFromEssentialSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(labelWelcomeMessage3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelSkillsLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSkillsLayout.setVerticalGroup(
            panelSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSkillsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWelcomeMessage3)
                    .addComponent(btnBackFromEssentialSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        SelectionPanel.add(panelSkills, "cardSkills");

        jMenu5.setText("Add");

        menuAddIndustry.setText("Industry");
        menuAddIndustry.setToolTipText("Add a new industry to the database");
        menuAddIndustry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddIndustryActionPerformed(evt);
            }
        });
        jMenu5.add(menuAddIndustry);

        menuAddDiscipline.setText("Discipline");
        menuAddDiscipline.setToolTipText("Add a new Discipline to the database");
        menuAddDiscipline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddDisciplineActionPerformed(evt);
            }
        });
        jMenu5.add(menuAddDiscipline);

        menuAddCareer.setText("Career");
        menuAddCareer.setToolTipText("Add a new Career to the database");
        menuAddCareer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddCareerActionPerformed(evt);
            }
        });
        jMenu5.add(menuAddCareer);

        menuAddCourse.setText("Course");
        menuAddCourse.setToolTipText("Add a new Course to the database");
        menuAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddCourseActionPerformed(evt);
            }
        });
        jMenu5.add(menuAddCourse);

        menuAddCareer2Course.setText("Course outcome");
        menuAddCareer2Course.setToolTipText("Link a career to a course to indicate it as being a possible career outcome of a particular course");
        menuAddCareer2Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddCareer2CourseActionPerformed(evt);
            }
        });
        jMenu5.add(menuAddCareer2Course);

        adminMenuBar.add(jMenu5);

        jMenu1.setText("Edit");

        menuEditIndustry.setText("Industry");
        menuEditIndustry.setToolTipText("Edit an existing industry");
        menuEditIndustry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditIndustryActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditIndustry);

        menuEditDiscpline.setText("Discipline");
        menuEditDiscpline.setToolTipText("Edit an existing discipline");
        menuEditDiscpline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditDiscplineActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditDiscpline);

        menuEditCareer.setText("Career");
        menuEditCareer.setToolTipText("Edit an existing career");
        menuEditCareer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditCareerActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditCareer);

        menuEditCourse.setText("Course");
        menuEditCourse.setToolTipText("Edit an exisitng course");
        menuEditCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditCourseActionPerformed(evt);
            }
        });
        jMenu1.add(menuEditCourse);

        adminMenuBar.add(jMenu1);

        jMenu6.setText("Remove");

        menuRemoveIndustry.setText("Industry");
        menuRemoveIndustry.setToolTipText("Remove an industry from the database");
        menuRemoveIndustry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveIndustryActionPerformed(evt);
            }
        });
        jMenu6.add(menuRemoveIndustry);

        menuRemoveDiscipline.setText("Discipline");
        menuRemoveDiscipline.setToolTipText("Remove a discipline from the database");
        menuRemoveDiscipline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveDisciplineActionPerformed(evt);
            }
        });
        jMenu6.add(menuRemoveDiscipline);

        menuRemoveCareer.setText("Career");
        menuRemoveCareer.setToolTipText("Remove a career from the database");
        menuRemoveCareer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveCareerActionPerformed(evt);
            }
        });
        jMenu6.add(menuRemoveCareer);

        menuRemoveCourse.setText("Course");
        menuRemoveCourse.setToolTipText("Remove a course from the database");
        menuRemoveCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveCourseActionPerformed(evt);
            }
        });
        jMenu6.add(menuRemoveCourse);

        menuRemoveCourseOutcome.setText("Course outcome");
        menuRemoveCourseOutcome.setToolTipText("Remove a career as a possible job outcome of a particular course");
        menuRemoveCourseOutcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveCourseOutcomeActionPerformed(evt);
            }
        });
        jMenu6.add(menuRemoveCourseOutcome);

        adminMenuBar.add(jMenu6);

        jMenu7.setText("Admin");

        jMenuItem2.setText("View usage history");
        jMenuItem2.setToolTipText("View usage history recorded by the application");
        jMenu7.add(jMenuItem2);

        menuListDeactivated.setText("List recently deactivated accounts");
        menuListDeactivated.setToolTipText("List accounts that have been recently deactivated");
        menuListDeactivated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListDeactivatedActionPerformed(evt);
            }
        });
        jMenu7.add(menuListDeactivated);

        menuUserAccountManagement.setText("User account management");
        menuUserAccountManagement.setToolTipText("Allows the admin to manage all user accounts for this application");
        menuUserAccountManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUserAccountManagementActionPerformed(evt);
            }
        });
        jMenu7.add(menuUserAccountManagement);

        menuAddAdmin.setText("Create admin");
        menuAddAdmin.setToolTipText("Create a new administrator account");
        menuAddAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddAdminActionPerformed(evt);
            }
        });
        jMenu7.add(menuAddAdmin);

        menuRemoveAdmin.setText("Remove Admin");
        menuRemoveAdmin.setToolTipText("Remove an existing administrator account");
        menuRemoveAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoveAdminActionPerformed(evt);
            }
        });
        jMenu7.add(menuRemoveAdmin);

        adminMenuBar.add(jMenu7);

        menuOptions.setText("Options");
        menuOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOptionsActionPerformed(evt);
            }
        });

        menuRefreshPage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuRefreshPage.setText("Refresh Page");
        menuRefreshPage.setToolTipText("Refresh the current page");
        menuRefreshPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRefreshPageActionPerformed(evt);
            }
        });
        menuOptions.add(menuRefreshPage);

        menuCloseAllOtherWindows.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuCloseAllOtherWindows.setText("Close all other windows");
        menuCloseAllOtherWindows.setToolTipText("Close all windows except for this one");
        menuCloseAllOtherWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloseAllOtherWindowsActionPerformed(evt);
            }
        });
        menuOptions.add(menuCloseAllOtherWindows);

        menuListBonusFeatures.setText("List all bonus features");
        menuListBonusFeatures.setToolTipText("View a list of all bonus features added to the application which were not a part of the original requirements");
        menuListBonusFeatures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListBonusFeaturesActionPerformed(evt);
            }
        });
        menuOptions.add(menuListBonusFeatures);

        adminMenuBar.add(menuOptions);

        setJMenuBar(adminMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CardLayout card1 = (CardLayout)SelectionPanel.getLayout();
        card1.show(SelectionPanel, "selection");
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboSelectCareerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelectCareerActionPerformed
        // TODO add your handling code here:
        int index = comboSelectCareer.getSelectedIndex();
        String demandText;
        if (index > 0)
        {
            try {
                careers = new Careers();
                CardLayout card = (CardLayout)SelectionPanel.getLayout();
                card.show(SelectionPanel, "careerDetails");
                String careerChosen = (String) comboSelectCareer.getSelectedItem();
                careersRS = careers.listCareerInfo(careerChosen);
                while (careersRS.next())
                {
                    labelTitle.setText(careerChosen);
                    String result = careersRS.getString("description");
                    txtAreaCareerDescription.setText(result);
                    String inDemand = careersRS.getString("inDemand");
                    if (inDemand.equalsIgnoreCase("Yes"))
                    demandText = careerChosen + " is a skill currently listed to be in demand in Australia according to the Australian Department of Immigrations " +
                    "Skills in Demand list.\n\n For more information visit: https://www.immi.gov.au";
                    else
                    demandText = careerChosen + " is currently not listed as a skill in demand within Australia according to the Australian Department of Immigration " +
                    "Skills in Demand List. \n\n For more information visit: https://www.immi.gov.au";
                    
                     txtAreaInDemand.setText(demandText);

                }
            } catch (SQLException ex) 
            {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                comboIndustries.setEnabled(false);
                labelSelectIndustry.setEnabled(false);

                comboDiscipline.setEnabled(false);
                labelSelectDiscipline.setEnabled(false);

                comboSelectCareer.setEnabled(false);
                labelSelectCareer.setEnabled(false);

                comboSelectOption.setEnabled(false);
                labelOption.setEnabled(false);

                comboSelectCourse.setEnabled(false);
                labelSelectCourse.setEnabled(false);

                btnRetryConnection.setVisible(true);
                labelConnectError.setVisible(true);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

        }
    }//GEN-LAST:event_comboSelectCareerActionPerformed

    private void comboIndustriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIndustriesActionPerformed
        // TODO add your handling code here:
        int index = comboIndustries.getSelectedIndex();
        comboDiscipline.removeAllItems();
        comboDiscipline.addItem("- Select -");
        if (index > 0)
        {
            String industrySelected = (String) comboIndustries.getSelectedItem();
            try
            {
                industries = new Industries();
                disciplines = new Disciplines();
                int industryID = industries.getIndustryIDByName(industrySelected);
                disciplinesRS = disciplines.listDisciplinesByIndustryID(industryID);
                    while(disciplinesRS.next())
                    {
                         String disciplineName = disciplinesRS.getString("disciplineName");
                         comboDiscipline.addItem(disciplineName);
                    }
               comboDiscipline.setEnabled(true);
               labelSelectDiscipline.setEnabled(true);
               labelSelectIndustry.setEnabled(false);
            }
            catch(Exception ex)
            {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                comboIndustries.setEnabled(false);
                labelSelectIndustry.setEnabled(false);

                comboDiscipline.setEnabled(false);
                labelSelectDiscipline.setEnabled(false);

                comboSelectCareer.setEnabled(false);
                labelSelectCareer.setEnabled(false);

                comboSelectOption.setEnabled(false);
                labelOption.setEnabled(false);

                comboSelectCourse.setEnabled(false);
                labelSelectCourse.setEnabled(false);

                btnRetryConnection.setVisible(true);
                labelConnectError.setVisible(true);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        } // end of if
        else
        {
           comboIndustries.setEnabled(true);
           labelSelectIndustry.setEnabled(true);
           comboDiscipline.setEnabled(false);
           labelSelectDiscipline.setEnabled(false);
        }
    }//GEN-LAST:event_comboIndustriesActionPerformed

    private void comboDisciplineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDisciplineActionPerformed
        // TODO add your handling code here:
        int index = comboDiscipline.getSelectedIndex();
        comboSelectOption.removeAllItems();
        comboSelectOption.addItem("- Select -");
        if (index > 0)
        {
            comboSelectOption.addItem("Career Pathways");
            comboSelectOption.addItem(("Essential Skills"));
            comboSelectOption.setEnabled(true);
            labelOption.setEnabled(true);
            labelSelectDiscipline.setEnabled(false);
            
            if(accountType.equalsIgnoreCase("Standard"))
            {
                String disciplineSelected = (String) comboDiscipline.getSelectedItem();
                try
                {
                  disciplines = new Disciplines();
                  disciplines.recordDisciplineSelected(email, disciplineSelected);
                }
                catch(Exception ex){}
            }
        }
        else
        {
            comboSelectOption.setEnabled(false);
            labelOption.setEnabled(false);
        }
    }//GEN-LAST:event_comboDisciplineActionPerformed

    private void comboSelectOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelectOptionActionPerformed
        // TODO add your handling code here:
        int index = comboSelectOption.getSelectedIndex();
        if (index == 1)
        {
            comboSelectCourse.setVisible(true);
            comboSelectCourse.setEnabled(true);
            
            comboSelectCareer.setVisible(true);
            comboSelectCareer.setEnabled(false);
            
            labelOption.setEnabled(false);
            labelSelectCourse.setVisible(true);
            labelSelectCourse.setEnabled(true);
            labelSelectCareer.setVisible(true);
            labelSelectCareer.setEnabled(false);
            
            comboSelectCourse.removeAllItems();
            comboSelectCourse.addItem("- Select -");
            
            String disciplineChosen = (String) comboDiscipline.getSelectedItem();
                try
                {
                    int disciplineID = disciplines.getDisciplineIDByName(disciplineChosen); // getDisciplineIDByName(disciplineChosen);
                    courses = new Courses();
                    coursesRS = courses.listAllCoursesByDisciplineID(disciplineID);
                    while(coursesRS.next())
                    {
                        String courseName = coursesRS.getString("courseName");
                        comboSelectCourse.addItem(courseName);
                    }
                }
                catch(Exception ex)
                {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                    comboIndustries.setEnabled(false);
                    labelSelectIndustry.setEnabled(false);

                    comboDiscipline.setEnabled(false);
                    labelSelectDiscipline.setEnabled(false);

                    comboSelectCareer.setEnabled(false);
                    labelSelectCareer.setEnabled(false);

                    comboSelectOption.setEnabled(false);
                    labelOption.setEnabled(false);

                    comboSelectCourse.setEnabled(false);
                    labelSelectCourse.setEnabled(false);

                    btnRetryConnection.setVisible(true);
                    labelConnectError.setVisible(true);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                }
            
        } // end of if statement
        else if(index == 2)
        {
            comboSelectCourse.setEnabled(false);
            comboSelectCourse.setVisible(false);
            labelSelectCourse.setEnabled(false);
            labelSelectCourse.setVisible(false);
            
            comboSelectCareer.setVisible(false);
            comboSelectCareer.setEnabled(false);
            labelSelectCareer.setVisible(false);
            labelSelectCareer.setEnabled(false);
            // do something
            CardLayout card = (CardLayout)SelectionPanel.getLayout();
            card.show(SelectionPanel, "cardSkills");
            String disciplineChosen = (String)comboDiscipline.getSelectedItem();
                try
                {
                    disciplinesRS = disciplines.listDisciplinesByName(disciplineChosen);
                    while(disciplinesRS.next())
                    {
                        String essentialSkills = disciplinesRS.getString("essentialSkills");
                        txtAreaEssentialSkills.setText("In order to be successful in the discipline of " + disciplineChosen +
                                                        ", applicants must posses the following skills: \n\n" + essentialSkills);

                    }
                }
                catch(Exception ex)
                {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                    comboIndustries.setEnabled(false);
                    labelSelectIndustry.setEnabled(false);

                    comboDiscipline.setEnabled(false);
                    labelSelectDiscipline.setEnabled(false);

                    comboSelectCareer.setEnabled(false);
                    labelSelectCareer.setEnabled(false);

                    comboSelectOption.setEnabled(false);
                    labelOption.setEnabled(false);

                    comboSelectCourse.setEnabled(false);
                    labelSelectCourse.setEnabled(false);

                    btnRetryConnection.setVisible(true);
                    labelConnectError.setVisible(true);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                }
        }
        else
        {
            comboSelectCourse.setEnabled(false);
            comboSelectCourse.setVisible(false);
            labelSelectCourse.setEnabled(false);
            labelSelectCourse.setVisible(false);
            
            comboSelectCareer.setVisible(false);
            comboSelectCareer.setEnabled(false);
            labelSelectCareer.setVisible(false);
            labelSelectCareer.setEnabled(false);
        }
    }//GEN-LAST:event_comboSelectOptionActionPerformed

    private void comboSelectCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSelectCourseActionPerformed
        // TODO add your handling code here:
        int index = comboSelectCourse.getSelectedIndex();
        if (index > 0)
        {
            comboSelectCareer.removeAllItems();
            comboSelectCareer.addItem("- Select -");
            String courseChosen = (String)comboSelectCourse.getSelectedItem();
            try
            {
                c2c = new Careers2Courses();
                c2cRS = c2c.listCareerOutcomeByCourse(courseChosen);
                while(c2cRS.next())
                {
                    String careerOutcome = c2cRS.getString("careerName");
                    comboSelectCareer.addItem(careerOutcome);
                }
                comboSelectCareer.setEnabled(true);
                labelSelectCareer.setEnabled(true);
                labelSelectCourse.setEnabled(false);
            }
            catch(Exception ex)
            {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                comboIndustries.setEnabled(false);
                labelSelectIndustry.setEnabled(false);

                comboDiscipline.setEnabled(false);
                labelSelectDiscipline.setEnabled(false);

                comboSelectCareer.setEnabled(false);
                labelSelectCareer.setEnabled(false);

                comboSelectOption.setEnabled(false);
                labelOption.setEnabled(false);

                comboSelectCourse.setEnabled(false);
                labelSelectCourse.setEnabled(false);

                btnRetryConnection.setVisible(true);
                labelConnectError.setVisible(true);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        }
    }//GEN-LAST:event_comboSelectCourseActionPerformed

    private void btnBackFromEssentialSkillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackFromEssentialSkillsActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)SelectionPanel.getLayout();
        card.show(SelectionPanel, "selection");
        
    }//GEN-LAST:event_btnBackFromEssentialSkillsActionPerformed

    private void btnRetryConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetryConnectionActionPerformed
        // TODO add your handling code here:
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));   
        MainPage PanelHome = new MainPage(); // creates a new window identiacal to the current window
        dispose(); // disposes of the old window
        PanelHome.setVisible(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnRetryConnectionActionPerformed

    private void menuAddIndustryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddIndustryActionPerformed
        // TODO add your handling code here:
        addIndustryPage.setVisible(true);
        addIndustryPage.setState(addIndustryPage.NORMAL);
        addIndustryPage.txtIndustryName.setText("");
    }//GEN-LAST:event_menuAddIndustryActionPerformed

    private void menuOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOptionsActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_menuOptionsActionPerformed

    private void menuCloseAllOtherWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCloseAllOtherWindowsActionPerformed
        // TODO add your handling code here:
        addIndustryPage.setVisible(false);
        addCareerPage.setVisible(false);
        addCoursePage.setVisible(false);
        career2coursePage.setVisible(false);
        editCareerPage.setVisible(false);
        editCoursePage.setVisible(false);
        removeCoursePage.setVisible(false);
        removeCourseOutcomePage.setVisible(false);
        updateDisciplinePage.setVisible(false);
        updateIndustryPage.setVisible(false);
        removeIndustryPage.setVisible(false);
        removeDisciplinePage.setVisible(false);
        addDisciplinePage.setVisible(false);
        removeAdminPage.setVisible(false);
        listDeactivatedPage.setVisible(false);
        userAdminPage.setVisible(false);
        removeCareerPage.setVisible(false);
        addAdminPage.setVisible(false);
        bonusFeaturesPage.setVisible(false);
        // add all other pages that could be open here
    }//GEN-LAST:event_menuCloseAllOtherWindowsActionPerformed

    private void menuRefreshPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRefreshPageActionPerformed
        // TODO add your handling code here:
        try
        {
           setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
           comboIndustries.removeAllItems();
           comboIndustries.addItem("- Select -");
           industries = new Industries();
           industriesRS = industries.listAllIndustries();
           while (industriesRS.next())
           {
               String industryName = industriesRS.getString("industryName");
               comboIndustries.addItem(industryName);
           }
           labelPageRefreshed.setText("The page has been refreshed (click to hide)");
           labelPageRefreshed.setVisible(true);
           setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));   
                                      
        }
        catch(Exception ex)
        {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            comboIndustries.setEnabled(false);
            labelSelectIndustry.setEnabled(false);
            
            comboDiscipline.setEnabled(false);
            labelSelectDiscipline.setEnabled(false);
            
            comboSelectCareer.setEnabled(false);
            labelSelectCareer.setEnabled(false);
            
            comboSelectOption.setEnabled(false);
            labelOption.setEnabled(false);
            
            comboSelectCourse.setEnabled(false);
            labelSelectCourse.setEnabled(false);
            
            btnRetryConnection.setVisible(true);
            labelConnectError.setVisible(true);
            
            labelPageRefreshed.setText("Error: Please check you connection (click to hide)");
            labelPageRefreshed.setVisible(true);
            
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
        
    }//GEN-LAST:event_menuRefreshPageActionPerformed

    private void labelPageRefreshedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPageRefreshedMouseClicked
        // TODO add your handling code here:
        labelPageRefreshed.setVisible(false);
    }//GEN-LAST:event_labelPageRefreshedMouseClicked

    private void menuAddCareerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddCareerActionPerformed
        // TODO add your handling code here:
        addCareerPage.setVisible(true);
        addCareerPage.setState(addCareerPage.NORMAL);
    }//GEN-LAST:event_menuAddCareerActionPerformed

    private void menuAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddCourseActionPerformed
        // TODO add your handling code here:
        addCoursePage.setVisible(true);
        addCoursePage.setState(addCoursePage.NORMAL);
        addCoursePage.comboDiscipline.setSelectedIndex(0);
        addCoursePage.txtCourseName.setText("");
        addCoursePage.labelMessage.setVisible(false);
        addCoursePage.labelRefreshMessage.setVisible(false);
        addCoursePage.labelConfirmationMessage.setVisible(false);
    }//GEN-LAST:event_menuAddCourseActionPerformed

    private void menuAddCareer2CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddCareer2CourseActionPerformed
        // TODO add your handling code here:
        career2coursePage.setVisible(true);
        career2coursePage.setState(addCareerPage.NORMAL);
        career2coursePage.comboCourse.setSelectedIndex(0);
        career2coursePage.labelLinkSuccess.setVisible(false);
    }//GEN-LAST:event_menuAddCareer2CourseActionPerformed

    private void menuEditCareerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditCareerActionPerformed
        // TODO add your handling code here:
        editCareerPage.setVisible(true);
        editCareerPage.setState(addCareerPage.NORMAL);
    }//GEN-LAST:event_menuEditCareerActionPerformed

    private void menuListBonusFeaturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListBonusFeaturesActionPerformed
        // TODO add your handling code here:
        bonusFeaturesPage.setVisible(true);
        bonusFeaturesPage.setState(bonusFeaturesPage.NORMAL);
    }//GEN-LAST:event_menuListBonusFeaturesActionPerformed

    private void menuEditCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditCourseActionPerformed
        // TODO add your handling code here:
        editCoursePage.setVisible(true);
        editCoursePage.setState(editCoursePage.NORMAL);
        editCoursePage.labelCourseName.setEnabled(true);
        editCoursePage.comboCourse.setSelectedIndex(0);
        editCoursePage.labelNewCourseName.setEnabled(false);
        editCoursePage.txtNewCourseName.setEnabled(false);
        editCoursePage.labelMessage.setVisible(false);
        editCoursePage.btnUpdate.setEnabled(false);
    }//GEN-LAST:event_menuEditCourseActionPerformed

    private void menuRemoveCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveCourseActionPerformed
        // TODO add your handling code here:
        removeCoursePage.setVisible(true);
        removeCoursePage.setState(removeCoursePage.NORMAL);
        removeCoursePage.comboCourseName.setSelectedIndex(0);
        removeCoursePage.btnDelete.setEnabled(false);
        removeCoursePage.labelMessage.setVisible(false);
    }//GEN-LAST:event_menuRemoveCourseActionPerformed

    private void menuRemoveCourseOutcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveCourseOutcomeActionPerformed
        // TODO add your handling code here:
        removeCourseOutcomePage.setVisible(true);
        removeCourseOutcomePage.setState(removeCourseOutcomePage.NORMAL);
        removeCourseOutcomePage.labelCourseName.setEnabled(true);
        removeCourseOutcomePage.comboCourseName.setSelectedIndex(0);
        removeCourseOutcomePage.labelCourseOutcome.setEnabled(false);
        removeCourseOutcomePage.comboCourseOutcome.setSelectedIndex(0);
        removeCourseOutcomePage.btnDelete.setEnabled(false);
        removeCourseOutcomePage.labelMessage.setVisible(false);
        removeCourseOutcomePage.labelRefreshMessage.setVisible(false);
    }//GEN-LAST:event_menuRemoveCourseOutcomeActionPerformed

    private void menuAddAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddAdminActionPerformed
        // TODO add your handling code here:
        addAdminPage.setVisible(true);
        addAdminPage.setState(addAdminPage.NORMAL);
    }//GEN-LAST:event_menuAddAdminActionPerformed

    private void menuEditIndustryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditIndustryActionPerformed
        // TODO add your handling code here:
        updateIndustryPage.setVisible(true);
        updateIndustryPage.setState(updateIndustryPage.NORMAL);
    }//GEN-LAST:event_menuEditIndustryActionPerformed

    private void menuEditDiscplineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditDiscplineActionPerformed
        // TODO add your handling code here:
        updateDisciplinePage.setVisible(true);
        updateDisciplinePage.setState(updateDisciplinePage.NORMAL);
        
    }//GEN-LAST:event_menuEditDiscplineActionPerformed

    private void menuRemoveIndustryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveIndustryActionPerformed
        // TODO add your handling code here:
        removeIndustryPage.setVisible(true);
        removeIndustryPage.setState(removeIndustryPage.NORMAL);
    }//GEN-LAST:event_menuRemoveIndustryActionPerformed

    private void menuRemoveDisciplineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveDisciplineActionPerformed
        // TODO add your handling code here:
        removeDisciplinePage.setVisible(true);
        removeDisciplinePage.setState(removeDisciplinePage.NORMAL);
    }//GEN-LAST:event_menuRemoveDisciplineActionPerformed

    private void menuAddDisciplineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddDisciplineActionPerformed
        // TODO add your handling code here:
        addDisciplinePage.setVisible(true);
        addDisciplinePage.setState(addDisciplinePage.NORMAL);
    }//GEN-LAST:event_menuAddDisciplineActionPerformed

    private void menuRemoveAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveAdminActionPerformed
        // TODO add your handling code here:
        removeAdminPage.setVisible(true);
        removeAdminPage.setState(removeAdminPage.NORMAL);
    }//GEN-LAST:event_menuRemoveAdminActionPerformed

    private void menuListDeactivatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListDeactivatedActionPerformed
        // TODO add your handling code here:
        listDeactivatedPage.setVisible(true);
        listDeactivatedPage.setState(listDeactivatedPage.NORMAL);
    }//GEN-LAST:event_menuListDeactivatedActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        UserLoginFormYB loginPage = new UserLoginFormYB();
        loginPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLogout3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout3ActionPerformed
        // TODO add your handling code here:
        UserLoginFormYB loginPage = new UserLoginFormYB();
        loginPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogout3ActionPerformed

    private void btnLogout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout2ActionPerformed
        // TODO add your handling code here:
        UserLoginFormYB loginPage = new UserLoginFormYB();
        loginPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogout2ActionPerformed

    private void menuUserAccountManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUserAccountManagementActionPerformed
        // TODO add your handling code here:
        userAdminPage.setVisible(true);
        userAdminPage.setState(userAdminPage.NORMAL);
    }//GEN-LAST:event_menuUserAccountManagementActionPerformed

    private void menuRemoveCareerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoveCareerActionPerformed
        // TODO add your handling code here:
        removeCareerPage.setVisible(true);
        removeCareerPage.setState(removeCareerPage.NORMAL);
    }//GEN-LAST:event_menuRemoveCareerActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SelectionPanel;
    private javax.swing.JMenuBar adminMenuBar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBackFromEssentialSkills;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout2;
    private javax.swing.JButton btnLogout3;
    private javax.swing.JButton btnRetryConnection;
    private javax.swing.JComboBox comboDiscipline;
    private javax.swing.JComboBox comboIndustries;
    private javax.swing.JComboBox comboSelectCareer;
    private javax.swing.JComboBox comboSelectCourse;
    private javax.swing.JComboBox comboSelectOption;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelConnectError;
    private javax.swing.JLabel labelOption;
    private javax.swing.JLabel labelPageRefreshed;
    private javax.swing.JLabel labelSelectCareer;
    private javax.swing.JLabel labelSelectCourse;
    private javax.swing.JLabel labelSelectDiscipline;
    private javax.swing.JLabel labelSelectIndustry;
    private javax.swing.JLabel labelTitle;
    public javax.swing.JLabel labelWelcomeMessage;
    private javax.swing.JLabel labelWelcomeMessage2;
    private javax.swing.JLabel labelWelcomeMessage3;
    private javax.swing.JMenuItem menuAddAdmin;
    private javax.swing.JMenuItem menuAddCareer;
    private javax.swing.JMenuItem menuAddCareer2Course;
    private javax.swing.JMenuItem menuAddCourse;
    private javax.swing.JMenuItem menuAddDiscipline;
    private javax.swing.JMenuItem menuAddIndustry;
    private javax.swing.JMenuItem menuCloseAllOtherWindows;
    private javax.swing.JMenuItem menuEditCareer;
    private javax.swing.JMenuItem menuEditCourse;
    private javax.swing.JMenuItem menuEditDiscpline;
    private javax.swing.JMenuItem menuEditIndustry;
    private javax.swing.JMenuItem menuListBonusFeatures;
    private javax.swing.JMenuItem menuListDeactivated;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JMenuItem menuRefreshPage;
    private javax.swing.JMenuItem menuRemoveAdmin;
    private javax.swing.JMenuItem menuRemoveCareer;
    private javax.swing.JMenuItem menuRemoveCourse;
    private javax.swing.JMenuItem menuRemoveCourseOutcome;
    private javax.swing.JMenuItem menuRemoveDiscipline;
    private javax.swing.JMenuItem menuRemoveIndustry;
    private javax.swing.JMenuItem menuUserAccountManagement;
    private javax.swing.JPanel panelDetailsDisplay;
    private javax.swing.JPanel panelDisplay;
    private javax.swing.JPanel panelSkills;
    private javax.swing.JTextArea txtAreaCareerDescription;
    private javax.swing.JTextArea txtAreaEssentialSkills;
    private javax.swing.JTextArea txtAreaInDemand;
    // End of variables declaration//GEN-END:variables
}
