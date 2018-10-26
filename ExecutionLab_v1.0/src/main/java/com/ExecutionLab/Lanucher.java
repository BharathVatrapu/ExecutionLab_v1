package com.ExecutionLab;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Lanucher extends JFrame  {

    private JsonUtils jsonUtils=null;

    public Lanucher() {
        initComponents();
        jsonUtils=new JsonUtils();
        loadProjectstoListBox();

    }
    public void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnGrape = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbtnConfigProject = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcmbSelectProject = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtxtReleaseName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbtnlogin = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Welcome to Execution Lab");

        jPanel1.setBackground(java.awt.Color.lightGray);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExecutionLab_Logo.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExutionLab.png"))); // NOI18N

        jbtnGrape.setBackground(java.awt.Color.lightGray);
        jbtnGrape.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jbtnGrape.setForeground(new java.awt.Color(153, 0, 153));
        jbtnGrape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grape.png"))); // NOI18N
        jbtnGrape.setText("Grape");
        jbtnGrape.setBorder(null);
        jbtnGrape.setBorderPainted(false);

        jPanel2.setBackground(java.awt.Color.lightGray);
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(0, 51, 102), null, null));

        jbtnConfigProject.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jbtnConfigProject.setForeground(new java.awt.Color(204, 102, 0));
        jbtnConfigProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configration_setting.png"))); // NOI18N
        jbtnConfigProject.setText("Config New Project");
        jbtnConfigProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigNewProjectActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Select Project:");

        jcmbSelectProject.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jcmbSelectProject.setForeground(new java.awt.Color(0, 102, 204));
        jcmbSelectProject.setMaximumRowCount(50);
        jcmbSelectProject.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Project Release:");

        jtxtReleaseName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jtxtReleaseName.setForeground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jbtnConfigProject))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addGap(30, 30, 30)
                                                .addComponent(jcmbSelectProject, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel4)
                                                .addGap(16, 16, 16)
                                                .addComponent(jtxtReleaseName)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbtnConfigProject)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jcmbSelectProject, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtxtReleaseName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(java.awt.Color.lightGray);
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), null, null));

        jbtnlogin.setBackground(java.awt.Color.lightGray);
        jbtnlogin.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbtnlogin.setForeground(new java.awt.Color(0, 153, 51));
        jbtnlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log_in.png"))); // NOI18N
        jbtnlogin.setText("Login");
        jbtnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jbtnReset.setBackground(java.awt.Color.lightGray);
        jbtnReset.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbtnReset.setForeground(new java.awt.Color(0, 102, 204));
        jbtnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reset.png"))); // NOI18N
        jbtnReset.setText("Reset");
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jbtnlogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(jbtnReset)
                                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbtnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jbtnGrape, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(212, 212, 212)
                                                                        .addComponent(jLabel2))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(127, 127, 127)
                                                                        .addComponent(jLabel3))))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(63, 63, 63)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnGrape)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void LoginActionPerformed(java.awt.event.ActionEvent evt)  {
        if(!jtxtReleaseName.getText().isEmpty()){

            jsonUtils.WriteconfiginiFile(jcmbSelectProject.getSelectedItem().toString(),jtxtReleaseName.getText().toString());
            jsonUtils.ReadconfiginiFile();
           String projectConfigFile = GlobalVariables.PROJECTS_FOLDER +"\\"+ GlobalVariables.ProjectName + "\\" + GlobalVariables.ProjectName + "_" + GlobalVariables.ConfigFolder + ".json";
            jsonUtils.ReadProjectconfigFile(projectConfigFile);
            setVisible(false);

            new MainFrame().setVisible(true);

        } else{
            JOptionPane.showMessageDialog(null,"Enter Release..!!!");
        }

    }

    private void ResetActionPerformed(java.awt.event.ActionEvent evt)  {
        jtxtReleaseName.setText("");
    }
    private void ConfigNewProjectActionPerformed(java.awt.event.ActionEvent evt)  {
        new AddNewProject().setVisible(true);
        setVisible(false);
    }
    public void loadProjectstoListBox(){

        File folder = new File(GlobalVariables.PROJECTS_FOLDER_PATH);
        File[] listOfFiles = folder.listFiles();

        if(listOfFiles.length!=0) {
            String Projects = listOfFiles[0].getName();

            for (int i = 1; i < listOfFiles.length; i++) {
                if (!listOfFiles[i].isFile()) {
                    Projects = Projects + "|" + listOfFiles[i].getName();
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
            String[] listProjectsName = Projects.split("\\|");
            jcmbSelectProject.removeAllItems();
            for (int i = 0; i < listProjectsName.length; i++) {
                jcmbSelectProject.addItem(listProjectsName[i]);
            }
        }

    }

    private void jbtnConfigProjectActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jbtnGrapeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jbtnloginActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(Lanucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lanucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lanucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lanucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lanucher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton jbtnConfigProject;
    private javax.swing.JButton jbtnGrape;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnlogin;
    private javax.swing.JComboBox<String> jcmbSelectProject;
    private javax.swing.JTextField jtxtReleaseName;
    // End of variables declaration
}
