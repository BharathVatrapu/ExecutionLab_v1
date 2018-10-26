package com.ExecutionLab;

import javax.swing.*;

/**
 * Created by bvatrapu on 15-07-2017.
 */
public class MainFrame extends JFrame {

    public TextfileUtils textfileUtils=null;
    public MainFrame() {
        textfileUtils=new TextfileUtils();
        initComponents();
        loadProject();
        GlobalVariables.TestParamsPath= GlobalVariables.PROJECTS_FOLDER_PATH+"\\"+GlobalVariables.ProjectName+"\\"+GlobalVariables.ProjectName+"_"+GlobalVariables.TestParams_File;
        textfileUtils.strTestParams();
    }

    private void initComponents() {

        jMenuBar1 = new JMenuBar();
        jMenuConfiguration = new JMenu();
        jMenuProjectSetup = new JMenu();
        jSeparator3 = new JPopupMenu.Separator();
        jMenuSettings = new JMenu();
        jMenuTestLab = new JMenu();

        jMnItemPrgfromSourcePath = new JMenuItem();
        jSeparator2 = new JPopupMenu.Separator();
      //  jMenuPrgfromVersionControl = new JMenu();
   //     jMnItemGitHub = new JMenuItem();
       // jMnItemSVN = new JMenuItem();
        jMenuRun = new JMenu();
        jMnItemRunAll = new JMenuItem();
        jMnItemRunSelected = new JMenuItem();
        jSeparator1 = new JPopupMenu.Separator();
        jMnItemRefresh = new JMenuItem();
        jSeparator4 = new JPopupMenu.Separator();
        jMnItemStopExecution = new JMenuItem();
        jMenuDashBoard = new JMenu();
        jMnItemResult = new JMenuItem();
        jMenuHelp = new JMenu();
        jMnItemAbout = new JMenuItem();
        jSeparator5 = new JPopupMenu.Separator();
        jMenuSetup = new JMenu();
        jMnItemAddBanner = new JMenuItem();
        jMnItemAddProject = new JMenuItem();
        jMnItemAddRelease = new JMenuItem();
        jMnItemAddMobileDevice = new JMenuItem();
        jMnItemSelectProject = new JMenuItem();
        jMnItemSelectTestNGParams = new JMenuItem();
        jMnItemSelectRelease = new JMenuItem();
        jMnItemSelectAddProject = new JMenuItem();


        setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Exeuction Lab v1.0");

        jMenuConfiguration.setText("Configuration");

        jMenuProjectSetup.setIcon(new ImageIcon(getClass().getResource("/img/project_setup.png")));
        jMenuProjectSetup.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMenuProjectSetup.setText("Project Setup");
        jMnItemSelectProject.setText("Switch Project");
        jMnItemSelectProject.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMnItemSelectProject.setIcon(new ImageIcon(getClass().getResource("/img/Select_Project.png")));
        jMnItemSelectProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectProjectActionPerformed(evt);
            }
        });
        jMenuProjectSetup.add(jMnItemSelectProject);
        jMnItemSelectAddProject.setText("Add New Project");
        jMnItemSelectAddProject.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMnItemSelectAddProject.setIcon(new ImageIcon(getClass().getResource("/img/Add_New_Project.png")));
        jMnItemSelectAddProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewProjectActionPerformed(evt);
            }
        });
        jMenuProjectSetup.add(jMnItemSelectAddProject);
        jMenuConfiguration.add(jMenuProjectSetup);
        jMenuConfiguration.add(jSeparator3);


        // NOI18N
        jMenuSettings.setIcon(new ImageIcon(getClass().getResource("/img/Settings.png")));
        jMenuSettings.setText("Settings");
        jMenuSettings.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMnItemSelectTestNGParams.setText("Test Params");
        jMnItemSelectTestNGParams.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMnItemSelectTestNGParams.setIcon(new ImageIcon(getClass().getResource("/img/TestNg.png")));
        jMnItemSelectTestNGParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItemSelectTestNGParamsActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMnItemSelectTestNGParams);

        jMnItemSelectRelease.setText("Appereance");
        jMnItemSelectRelease.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jMnItemSelectRelease.setIcon(new ImageIcon(getClass().getResource("/img/appearance.png")));

        jMnItemSelectRelease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppereanceActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMnItemSelectRelease);

        jMenuConfiguration.add(jMenuSettings);
        jMenuConfiguration.add(jSeparator5);



        jMenuBar1.add(jMenuConfiguration);

//        jMenuProject.add(jMenuPrgfromVersionControl);

    //    jMenuBar1.add(jMenuProject);





        jMenuTestLab.setText("TestLab");

        jMnItemPrgfromSourcePath.setIcon(new ImageIcon(getClass().getResource("/img/OpenProject.png"))); // NOI18N
        jMnItemPrgfromSourcePath.setText("Project from Existing Source");
        jMnItemPrgfromSourcePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItemOpenProjectActionPerformedActionPerformed(evt);
            }
        });
        jMenuTestLab.add(jMnItemPrgfromSourcePath);
//        jMenuProject.add(jSeparator2);


       // jMenuPrgfromVersionControl.setText("Project from Version Control");

//        jMnItemGitHub.setIcon(new ImageIcon(getClass().getResource("/img/MF/GitHub.png"))); // NOI18N
//        jMnItemGitHub.setText("GitHub");
//        jMenuPrgfromVersionControl.add(jMnItemGitHub);
//
//        jMnItemSVN.setIcon(new ImageIcon(getClass().getResource("/img/MF/SVN.png"))); // NOI18N
//        jMnItemSVN.setText("SVN");
//        jMenuPrgfromVersionControl.add(jMnItemSVN);

        //jMenuProject.add(jMenuPrgfromVersionControl);

        jMenuBar1.add(jMenuTestLab);

        jMenuRun.setText("Run");

        jMnItemRunAll.setIcon(new ImageIcon(getClass().getResource("/img/RunAll.png"))); // NOI18N
        jMnItemRunAll.setText("Run All");
        jMnItemRunAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItemRunAllActionPerformed(evt);
            }
        });
        jMenuRun.add(jMnItemRunAll);

        jMnItemRunSelected.setIcon(new ImageIcon(getClass().getResource("/img/RunSelected.png"))); // NOI18N
        jMnItemRunSelected.setText("Run Selected");
        jMnItemRunSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItemRunSelectedActionPerformed(evt);
            }
        });
        jMenuRun.add(jMnItemRunSelected);
        jMenuRun.add(jSeparator1);

        jMnItemRefresh.setIcon(new ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        jMnItemRefresh.setText("Refresh");
        jMnItemRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItemRefreshActionPerformed(evt);
            }
        });
        jMenuRun.add(jMnItemRefresh);
        jMenuRun.add(jSeparator4);

        jMnItemStopExecution.setIcon(new ImageIcon(getClass().getResource("/img/stop.png"))); // NOI18N
        jMnItemStopExecution.setText("Stop Execution");
        jMenuRun.add(jMnItemStopExecution);

        jMenuBar1.add(jMenuRun);

        jMenuDashBoard.setText("DashBoard");

        jMnItemResult.setIcon(new ImageIcon(getClass().getResource("/img/Results.png"))); // NOI18N
        jMnItemResult.setText("Results");
        jMnItemResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnItemResultActionPerformed(evt);
            }
        });
        jMenuDashBoard.add(jMnItemResult);

        jMenuBar1.add(jMenuDashBoard);

        jMenuHelp.setText("Help");

        jMnItemAbout.setIcon(new ImageIcon(getClass().getResource("/img/About.png"))); // NOI18N
        jMnItemAbout.setText("About");
        jMenuHelp.add(jMnItemAbout);

        jMenuBar1.add(jMenuHelp);




        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();

        setLocationRelativeTo(null);
    }

    private void jMnItemSelectTestNGParamsActionPerformed(java.awt.event.ActionEvent evt) {
        new TestParams().setVisible(true);
    }
    private void jMnItemOpenProjectActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {

        new Lanucher().setVisible(true);
    }
    private void AddNewProjectActionPerformed(java.awt.event.ActionEvent evt) {
            new AddNewProject().setVisible(true);
    }
    private void SelectProjectActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        dispose();
        new Lanucher().setVisible(true);
    }
    private void AppereanceActionPerformed(java.awt.event.ActionEvent evt) {
        new Appereance();
    }


    private void jMnItemRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        TestLab utilities =new TestLab();
        utilities.RefreshResults();

    }
    private void jMnItemRunAllActionPerformed(java.awt.event.ActionEvent evt) {
        TestLab utilities =new TestLab();
        utilities.RunSelectedTestCases("TESTSET", GlobalVariables.PackageName);

    }
    private void jMnItemRunSelectedActionPerformed(java.awt.event.ActionEvent evt) {
        TestLab utilities =new TestLab();
        utilities.RunSelectedTestCases("SELECTED", GlobalVariables.PackageName);
    }


    private void jMenuProjectSetupActionPerformed(java.awt.event.ActionEvent evt) {


    }
    private void jMnItemResultActionPerformed(java.awt.event.ActionEvent evt) {


    }

    private void MnuExitsActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(1);
    }
    private void jMitemProjectfromExistingSourceActionPerformed(java.awt.event.ActionEvent evt){
        loadProject();

    }

    private void loadProject(){
      //  setContentPane(Utilities.createMainDesktopPane());
        setContentPane(TestLab.createMainDesktopPane());
    }





    private void jMitemSetupActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify

    private JMenu jMenuRun;
    private JMenuBar jMenuBar1;
    private JMenu jMenuConfiguration;
    private JMenu jMenuDashBoard;
    private JMenu jMenuHelp;
    private JMenu jMenuPrgfromVersionControl;
    private JMenu jMenuTestLab;
    private JMenu jMenuSettings;
    private JMenuItem jMnItemAbout;
    private JMenu jMenuProjectSetup;
  //  private JMenuItem jMnItemGitHub;
    private JMenuItem jMnItemPrgfromSourcePath;
    private JMenuItem jMnItemRefresh;
    private JMenuItem jMnItemResult;
    private JMenuItem jMnItemRunAll;
    private JMenuItem jMnItemRunSelected;
//    private JMenuItem jMnItemSVN;

    private JMenuItem jMnItemStopExecution;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    private JPopupMenu.Separator jSeparator3;
    private JPopupMenu.Separator jSeparator4;
    private JPopupMenu.Separator jSeparator5;
    private JMenu jMenuSetup;
    private JMenuItem jMnItemAddBanner;
    private JMenuItem jMnItemAddProject;
    private JMenuItem jMnItemAddRelease;
    private JMenuItem jMnItemAddMobileDevice;

    private JMenuItem jMnItemSelectProject;
    private JMenuItem jMnItemSelectTestNGParams;
    private JMenuItem jMnItemSelectRelease;
    private JMenuItem jMnItemSelectAddProject;


    // End of variables declaration
}
