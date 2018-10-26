package com.ExecutionLab;

import javax.swing.*;

/**
 * Created by bvatrapu on 8/18/2017.
 */
public class Settings extends JFrame {

    public Settings() {
        initComponents();
    }
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jRBQI = new JRadioButton();
        jRBQA1 = new JRadioButton();
        jRBQA2 = new JRadioButton();
        jPanel2 = new JPanel();
        jlblSelectBanner = new JLabel();
        jcbSelectBanner = new JComboBox<>();
        jbtnAddBanner = new JButton();
        jPanel3 = new JPanel();
        jrbChrome = new JRadioButton();
        jrbFirefox = new JRadioButton();
        jrbIE11 = new JRadioButton();
        jrbSafari = new JRadioButton();
        jPanel4 = new JPanel();
        jrbDesktop = new JRadioButton();
        jrbMobile = new JRadioButton();
        jPanel5 = new JPanel();
        jlblSelectMobile = new JLabel();
        jcbSelectMobile = new JComboBox<>();
        jrbPrivate = new JRadioButton();
        jrbPublic = new JRadioButton();
        jbtnAddMobile = new JButton();
        jPanel6 = new JPanel();
        jrbON = new JRadioButton();
        jrbOFF = new JRadioButton();
        jbtnClose = new JButton();
        jbtnDefault = new JButton();
        jbtnSave = new JButton();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Settings");

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Environment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jRBQI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBQI.setForeground(new java.awt.Color(0, 102, 102));
        jRBQI.setText("QI");

        jRBQA1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBQA1.setForeground(new java.awt.Color(0, 102, 102));
        jRBQA1.setText("QA1");

        jRBQA2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRBQA2.setForeground(new java.awt.Color(0, 102, 102));
        jRBQA2.setText("QA2");

        ButtonGroup bgEnv = new ButtonGroup();
        bgEnv.add(jRBQI);
        bgEnv.add(jRBQA1);
        bgEnv.add(jRBQA2);
        //jRBQA2.setSelected(true);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jRBQI)
                                .addGap(38, 38, 38)
                                .addComponent(jRBQA1)
                                .addGap(37, 37, 37)
                                .addComponent(jRBQA2)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRBQI)
                                        .addComponent(jRBQA1)
                                        .addComponent(jRBQA2))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Banner", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setToolTipText("");

        jlblSelectBanner.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblSelectBanner.setForeground(new java.awt.Color(0, 102, 102));
        jlblSelectBanner.setText("Select Banner:");

        jbtnAddBanner.setText("Add Banner");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlblSelectBanner)
                                .addGap(18, 18, 18)
                                .addComponent(jcbSelectBanner, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnAddBanner)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlblSelectBanner)
                                        .addComponent(jcbSelectBanner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtnAddBanner))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Desktop Browser", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jrbChrome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbChrome.setForeground(new java.awt.Color(0, 102, 102));
        jrbChrome.setText("Chrome");

        jrbFirefox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbFirefox.setForeground(new java.awt.Color(0, 102, 102));
        jrbFirefox.setText("Firefox");

        jrbIE11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbIE11.setForeground(new java.awt.Color(0, 102, 102));
        jrbIE11.setText("IE11");

        jrbSafari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbSafari.setForeground(new java.awt.Color(0, 102, 102));
        jrbSafari.setText("Safari");

        ButtonGroup bgDesktopBrowser = new ButtonGroup();
        bgDesktopBrowser.add(jrbChrome);
        bgDesktopBrowser.add(jrbFirefox);
        bgDesktopBrowser.add(jrbIE11);
        bgDesktopBrowser.add(jrbSafari);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jrbChrome)
                                .addGap(38, 38, 38)
                                .addComponent(jrbFirefox)
                                .addGap(37, 37, 37)
                                .addComponent(jrbIE11)
                                .addGap(28, 28, 28)
                                .addComponent(jrbSafari)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jrbChrome)
                                        .addComponent(jrbFirefox)
                                        .addComponent(jrbIE11)
                                        .addComponent(jrbSafari))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(BorderFactory.createTitledBorder(null, "PlatformType", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jrbDesktop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbDesktop.setForeground(new java.awt.Color(0, 102, 102));
        jrbDesktop.setText("Desktop");

        jrbMobile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbMobile.setForeground(new java.awt.Color(0, 102, 102));
        jrbMobile.setText("Mobile");

        ButtonGroup bgPlatformType = new ButtonGroup();
        bgPlatformType.add(jrbDesktop);
        bgPlatformType.add(jrbMobile);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jrbDesktop)
                                .addGap(38, 38, 38)
                                .addComponent(jrbMobile)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jrbDesktop)
                                        .addComponent(jrbMobile))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Mobile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jlblSelectMobile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblSelectMobile.setForeground(new java.awt.Color(0, 102, 102));
        jlblSelectMobile.setText("Select Mobile:");

        jrbPrivate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbPrivate.setForeground(new java.awt.Color(0, 102, 102));
        jrbPrivate.setText("Private");

        jrbPublic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbPublic.setForeground(new java.awt.Color(0, 102, 102));
        jrbPublic.setText("Public");

        ButtonGroup bgMobile = new ButtonGroup();
        bgMobile.add(jrbPrivate);
        bgMobile.add(jrbPublic);

        jbtnAddMobile.setText("Add Mobile");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jrbPrivate)
                                                .addGap(38, 38, 38)
                                                .addComponent(jrbPublic))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jlblSelectMobile)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbSelectMobile, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnAddMobile)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jrbPrivate)
                                        .addComponent(jrbPublic))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlblSelectMobile)
                                        .addComponent(jcbSelectMobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtnAddMobile))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.setBorder(BorderFactory.createTitledBorder(null, "ALM Intigration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jrbON.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbON.setForeground(new java.awt.Color(0, 102, 102));
        jrbON.setText("ON");
        jrbON.setToolTipText("");

        jrbOFF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOFF.setForeground(new java.awt.Color(0, 102, 102));
        jrbOFF.setText("OFF");

        ButtonGroup bgALM = new ButtonGroup();
        bgALM.add(jrbON);
        bgALM.add(jrbOFF);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jrbON)
                                .addGap(38, 38, 38)
                                .addComponent(jrbOFF)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jrbON)
                                        .addComponent(jrbOFF))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnClose.setIcon(new ImageIcon(getClass().getResource("/img/Close.png"))); // NOI18N
        jbtnClose.setText("Close");

        jbtnDefault.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDefault.setForeground(new java.awt.Color(0, 153, 0));
        jbtnDefault.setIcon(new ImageIcon(getClass().getResource("/img/Default.png"))); // NOI18N
        jbtnDefault.setText("Default");

        jbtnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSave.setForeground(new java.awt.Color(0, 153, 204));
        jbtnSave.setIcon(new ImageIcon(getClass().getResource("/img/SaveSettings.png"))); // NOI18N
        jbtnSave.setText("Save");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jbtnSave, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jbtnDefault)
                                .addGap(21, 21, 21)
                                .addComponent(jbtnClose, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnClose, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(jbtnDefault, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(jbtnSave, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JRadioButton jRBQA1;
    private JRadioButton jRBQA2;
    private JRadioButton jRBQI;
    private JButton jbtnAddBanner;
    private JButton jbtnAddMobile;
    private JButton jbtnClose;
    private JButton jbtnDefault;
    private JButton jbtnSave;
    private JComboBox<String> jcbSelectBanner;
    private JComboBox<String> jcbSelectMobile;
    private JLabel jlblSelectBanner;
    private JLabel jlblSelectMobile;
    private JRadioButton jrbChrome;
    private JRadioButton jrbDesktop;
    private JRadioButton jrbFirefox;
    private JRadioButton jrbIE11;
    private JRadioButton jrbMobile;
    private JRadioButton jrbOFF;
    private JRadioButton jrbON;
    private JRadioButton jrbPrivate;
    private JRadioButton jrbPublic;
    private JRadioButton jrbSafari;
    // End of variables declaration
}
