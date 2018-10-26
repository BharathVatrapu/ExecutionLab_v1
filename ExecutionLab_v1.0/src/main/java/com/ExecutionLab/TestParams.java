package com.ExecutionLab;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by bvatrapu on 7/14/2017.
 */
public class TestParams extends JFrame {
    DefaultListModel  model1= new DefaultListModel();
    String testParam=null;
    public TextfileUtils textfileUtils=null;
    private Generic generic =null;
    String testparamsFilePath = GlobalVariables.PROJECTS_FOLDER_PATH+"\\"+GlobalVariables.ProjectName+"\\"+GlobalVariables.ProjectName+"_"+GlobalVariables.TestParams_File;

    public TestParams() {
        initComponents();
        loadDefaultTestParams();
        textfileUtils=new TextfileUtils();
        generic =new Generic();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jbtnClose = new JButton();
        jPanel1 = new JPanel();
        jLabel10 = new JLabel();
        jtxtName = new JTextField();
        jLabel11 = new JLabel();
        jtxtValue = new JTextField();
        jbtnAdd = new JButton();
        jScrollPane1 = new JScrollPane();
        jlstParams = new JList();
        jbtnSave = new JButton();
        jbtnRemove = new JButton();
        jbtnUpdate = new JButton();
        jbtnClear = new JButton();

        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("TestParams setup");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("TestNG Parameters");
        jLabel1.setToolTipText("");

        jbtnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnClose.setForeground(new java.awt.Color(255, 0, 51));
        //jbtnClose.setIcon(new ImageIcon(getClass().getResource("/close_32.png"))); // NOI18N
        jbtnClose.setText("Close");
        jbtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCloseActionPerformed(evt);
            }
        });

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "TestNG Params", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14), new java.awt.Color(102, 102, 255))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Name:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Value:");

        jbtnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAdd.setForeground(new java.awt.Color(0, 153, 153));
        //jbtnAdd.setIcon(new ImageIcon(getClass().getResource("/Add_create_new_math_sign_cross_plus-16.png"))); // NOI18N
        jbtnAdd.setText("Add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

//        jlstParams.setModel(new javax.swing.AbstractListModel<String>() {
//            //String[] strings = {  };
//            public int getSize() { return strings.leng); }
//            public String getElementAt(int i) { return listItems[i]; }
//        });
        jScrollPane1.setViewportView(jlstParams);

        jbtnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSave.setForeground(new java.awt.Color(0, 153, 153));
       // jbtnSave.setIcon(new ImageIcon(getClass().getResource("/file_documents-11-16.png"))); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });
        jbtnRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRemove.setForeground(new java.awt.Color(255, 0, 0));
    //    jbtnRemove.setIcon(new ImageIcon(getClass().getResource("/minus-16.png"))); // NOI18N
        jbtnRemove.setText("Remove");
        jbtnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveActionPerformed(evt);
            }
        });


        jbtnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnUpdate.setForeground(new java.awt.Color(102, 102, 102));
      //  jbtnUpdate.setIcon(new ImageIcon(getClass().getResource("/db_update.png"))); // NOI18N
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });


        jbtnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnClear.setForeground(new java.awt.Color(255, 102, 51));
      //  jbtnClear.setIcon(new ImageIcon(getClass().getResource("/edit-clear.png"))); // NOI18N
        jbtnClear.setText("Clear All");
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(jbtnAdd))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jbtnSave)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnRemove)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnUpdate)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnClear)))
                                .addContainerGap(22, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jtxtName, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jtxtValue, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))
                                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxtValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnAdd)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnSave)
                                        .addComponent(jbtnRemove)
                                        .addComponent(jbtnUpdate)
                                        .addComponent(jbtnClear))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbtnClose)
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnClose)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jbtnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        // Close project
        this.setVisible(false);
    }
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {
       boolean flag=true;
        String txtName=null;
        String txtValue=null;
        txtName=jtxtName.getText();
        txtValue=jtxtValue.getText();
        if (txtName.isEmpty()==true)
        {
            JOptionPane.showMessageDialog(null,"Enter Param Name");

            flag=false;
            return;
        }
        if (txtValue.isEmpty()==true)
        {
            JOptionPane.showMessageDialog(null,"Enter Param Value");

            flag=false;
            return;
        }
        if(flag==true) {
            testParam = txtName + ":" + txtValue;
            model1.addElement(testParam);
            jlstParams.setModel(model1);
            jlstParams.setSelectedIndex(0);
            jtxtName.setText("");
            jtxtValue.setText("");
        }
    }

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String testParams;
        testParams = jlstParams.getModel().getElementAt(0).toString();
        for(int i = 1; i< jlstParams.getModel().getSize();i++){
            testParams=testParams+"|"+jlstParams.getModel().getElementAt(i).toString();
        }
        textfileUtils.WriteTextfile(testparamsFilePath,testParams);
        JOptionPane.showMessageDialog(null,"Successfully Saved");
        setVisible(false);
    }

    private void jbtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        model1.removeElement(jlstParams.getSelectedValue());

    }

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag=true;
        String selectValue;

        selectValue = jlstParams.getSelectedValue().toString();
        if(selectValue.isEmpty()==false) {
            String[] selectTestNGParam = selectValue.split("\\:");
            jtxtName.setText(selectTestNGParam[0]);
            jtxtValue.setText(selectTestNGParam[1]);

            model1.removeElement(jlstParams.getSelectedValue());
        }else {
            JOptionPane.showMessageDialog(null,"Select Param Name&value");
        }
    }

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {
        jtxtName.setText("");
        jtxtValue.setText("");
        model1.removeAllElements();
    }


    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        this.setLocationRelativeTo(null);

    }

    private void loadDefaultTestParams() {
        String params=null;
        if(generic.verifyFileExist(testparamsFilePath)){


            String[] readParams=GlobalVariables.TestParams.split("\\|");
            for(int i = 0; i< readParams.length-1;i++){
                testParam = readParams[i];
                model1.addElement(testParam);
                jlstParams.setModel(model1);
                jlstParams.setSelectedIndex(0);
                jtxtName.setText("");
                jtxtValue.setText("");
            }
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new TestParams().setVisible(true);


            }
        });
    }

    // Variables declaration - do not modify
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton jbtnAdd;
    private JButton jbtnClear;
    private JButton jbtnClose;
    private JButton jbtnRemove;
    private JButton jbtnSave;
    private JButton jbtnUpdate;
    private JList jlstParams;
    private JTextField jtxtName;
    private JTextField jtxtValue;
    // End of variables declaration

}
