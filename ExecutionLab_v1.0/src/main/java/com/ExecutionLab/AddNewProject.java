package com.ExecutionLab;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AddNewProject extends javax.swing.JFrame  {

    private Generic generic=null;
    private XmlUtils xmlUtils=null;
    private JsonUtils jsonUtils=null;

    String projectName=null;
    String projectPath=null;
    String classPath=null;
    String testScriptsPath=null;
    String pomXmlPath=null;
    String suiteXmlPath=null;
    String resultPath=null;

    String projectConfigFile=null;

    public AddNewProject() {
        initComponents();
        generic=new Generic();
        xmlUtils=new XmlUtils();
        jsonUtils=new JsonUtils();

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtProjectName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtTestScript = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtClassPath = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtPomXml = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtSuiteXml = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtResultPath = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtProjectPath = new javax.swing.JTextField();
        jbtnProjectPath = new javax.swing.JButton();
        jbtnTestScript = new javax.swing.JButton();
        jbntClassPath = new javax.swing.JButton();
        jbtnPomXml = new javax.swing.JButton();
        jbtnSuiteXml = new javax.swing.JButton();
        jbtnResultPath = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbtnClearAll = new javax.swing.JButton();
        jbtnSave1 = new javax.swing.JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Configuration New Project");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add_New_Project.png"))); // NOI18N
        jLabel1.setText("Add New Project");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(51, 102, 255), null));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Project Name:");

        jtxtProjectName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtProjectName.setForeground(new java.awt.Color(0, 0, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Project Paths", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 51, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Test Script :");



        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Class Path :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Pom Xml :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Suite Xml :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Result Path :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Project Path :");


        jbtnProjectPath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder_open_add.png")));
        jbtnProjectPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProjectPathActionPerformed(evt);
            }
        });
        jbtnTestScript.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder_open_add.png")));
        jbtnTestScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTestScriptPathActionPerformed(evt);
            }
        });

        jbntClassPath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder_open_add.png")));
        jbntClassPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClassPathActionPerformed(evt);
            }
        });

        jbtnPomXml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder_open_add.png")));
        jbtnPomXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPomXmlPathActionPerformed(evt);
            }
        });

        jbtnSuiteXml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder_open_add.png")));
        jbtnSuiteXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuiteXmlPathActionPerformed(evt);
            }
        });

        jbtnResultPath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder_open_add.png")));
        jbtnResultPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResultPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel4))
                                                        .addGap(293, 293, 293)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jbntClassPath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jbtnPomXml, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jtxtProjectPath, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jbtnProjectPath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(3, 3, 3)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jtxtTestScript, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jtxtPomXml, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                                                .addComponent(jLabel6)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jtxtSuiteXml, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                                                .addComponent(jLabel7)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jtxtResultPath, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addComponent(jtxtClassPath, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jbtnTestScript, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnSuiteXml, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jbtnResultPath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jLabel8)
                                                                                        .addComponent(jtxtProjectPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jbtnProjectPath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(jLabel3)
                                                                                        .addComponent(jtxtTestScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(jbtnTestScript, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jtxtClassPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jbntClassPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jtxtPomXml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jbtnPomXml, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel6)
                                                .addComponent(jtxtSuiteXml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jbtnSuiteXml, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(jtxtResultPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jbtnResultPath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jtxtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jtxtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 153), null));

        jbtnClearAll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnClearAll.setForeground(new java.awt.Color(255, 51, 102));
        jbtnClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_clear.png"))); // NOI18N
        jbtnClearAll.setText("Clear ");
        jbtnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearAllActionPerformed(evt);
            }
        });
        jbtnClearAll.setToolTipText("");

        jbtnSave1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnSave1.setForeground(new java.awt.Color(0, 102, 204));
        jbtnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/filesaveas.png"))); // NOI18N
        jbtnSave1.setText("Save");
        jbtnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });
        jbtnSave1.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jbtnSave1)
                                .addGap(79, 79, 79)
                                .addComponent(jbtnClearAll)
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnClearAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbtnSave1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jbtnProjectPathActionPerformed(java.awt.event.ActionEvent evt)  {
        projectPath = generic.choosefolderPath();
        if(projectPath.toLowerCase().contains("src")){
            loadProjectPaths();
        } else {
            JOptionPane.showMessageDialog(null,"Select Project Directory Path upto 'src'");
        }
    }

    private void jbtnTestScriptPathActionPerformed(java.awt.event.ActionEvent evt)  {
        testScriptsPath = generic.choosefolderPath();
        jtxtTestScript.setText(testScriptsPath);
    }
    private void jbtnClassPathActionPerformed(java.awt.event.ActionEvent evt)  {
        classPath = generic.choosefolderPath();
        jtxtClassPath.setText(classPath);
    }
    private void jbtnPomXmlPathActionPerformed(java.awt.event.ActionEvent evt)  {
        pomXmlPath = generic.choosefolderPath();
        jtxtPomXml.setText(pomXmlPath);
    }
    private void jbtnSuiteXmlPathActionPerformed(java.awt.event.ActionEvent evt)  {
        suiteXmlPath = generic.choosefolderPath();
        jtxtSuiteXml.setText(suiteXmlPath);
    }
    private void jbtnResultPathActionPerformed(java.awt.event.ActionEvent evt)  {
        resultPath = generic.choosefolderPath();
        jtxtResultPath.setText(resultPath);
    }

    private void jbtnClearAllActionPerformed(java.awt.event.ActionEvent evt)  {
        jtxtProjectName.setText("");
        jtxtProjectPath.setText("");
        jtxtTestScript.setText("");
        jtxtClassPath.setText("");
        jtxtPomXml.setText("");
        jtxtSuiteXml.setText("");
        jtxtResultPath.setText("");
    }

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt)  {
                loadTextFields();
                projectConfigFile = GlobalVariables.PROJECTS_FOLDER_PATH +"\\"+ projectName + "\\" + projectName + "_" + GlobalVariables.ConfigFolder + ".json";
                generic.createNewFolder(GlobalVariables.PROJECTS_FOLDER_PATH, projectName);
                generic.createNewFile(projectConfigFile);
                jsonUtils.WriteProjectconfigFile(projectConfigFile, projectName, projectPath, testScriptsPath, classPath, pomXmlPath, suiteXmlPath, resultPath);
                jsonUtils.ReadProjectconfigFile(projectConfigFile);

                setVisible(false);
                new Lanucher().setVisible(true);

    }

    private void loadTextFields(){
        if(verifyTextFieldsIsEmpty()) {
            projectName = jtxtProjectName.getText().toString();
            projectPath = jtxtProjectPath.getText().toString();
            testScriptsPath=jtxtTestScript.getText().toString();
            classPath=jtxtClassPath.getText().toString();
            pomXmlPath=jtxtPomXml.getText().toString();
            suiteXmlPath=jtxtSuiteXml.getText().toString();
            resultPath=jtxtResultPath.getText().toString();

        } else {
            JOptionPane.showMessageDialog(null,"Enter all Fields");
        }

    }
    private void loadProjectPaths(){
        int intpos = projectPath.indexOf("\\src");
        projectPath = projectPath.substring(0, intpos);

        //classPath=projectPath.replace("\\","/")+"/"+"target/test-classes";
        classPath=projectPath+"\\"+"target\\test-classes";
        System.out.println("classPath::"+classPath);
        pomXmlPath=projectPath+"\\"+"pom.xml";
        System.out.println("pomXmlPath::"+pomXmlPath);
        suiteXmlPath=xmlUtils.ReadXMLFile(pomXmlPath,"suiteXmlFiles","suiteXmlFile");
        if(!suiteXmlPath.isEmpty()){
            suiteXmlPath=suiteXmlPath.replace("/","\\");
            suiteXmlPath=projectPath+"\\"+suiteXmlPath;
        }

        testScriptsPath = projectPath+File.separator+"src"+"\\test\\java\\com\\albertsons\\portal\\automation\\testsuites";
        jtxtTestScript.setText(testScriptsPath);
        jtxtProjectPath.setText(projectPath);
        jtxtClassPath.setText(classPath);
        jtxtPomXml.setText(pomXmlPath);
        jtxtSuiteXml.setText(suiteXmlPath);

        projectName=generic.ReadPOMXML(pomXmlPath,"artifactId");
        if(projectName!=null){
            jtxtProjectName.setText("");
            jtxtProjectName.setText(projectName);
            JOptionPane.showMessageDialog(null,"Project Name is updated as per 'pom.xml'... if not please update.");
        }
        System.out.println("LOADprojectName::"+projectName);
        resultPath=projectPath+"\\"+GlobalVariables.ResultsFolder;
        jtxtResultPath.setText(resultPath);
    }
    private boolean verifyTextFieldsIsEmpty(){
        boolean returnStatus=true;
        if(jtxtProjectName.getText().isEmpty()){
            returnStatus=false;
        }
        if(jtxtResultPath.getText().isEmpty()){
            returnStatus=false;
        }
        if(jtxtSuiteXml.getText().isEmpty()){
            returnStatus=false;
        }
        if(jtxtPomXml.getText().isEmpty()){
            returnStatus=false;
        }
        if(jtxtClassPath.getText().isEmpty()){
            returnStatus=false;
        }
        if(jtxtTestScript.getText().isEmpty()){
            returnStatus=false;
        }
        if(jtxtProjectPath.getText().isEmpty()){
            returnStatus=false;
        }
        return returnStatus;
    }





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
            java.util.logging.Logger.getLogger(AddNewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewProject().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbntClassPath;
    private javax.swing.JButton jbtnClearAll;
    private javax.swing.JButton jbtnPomXml;
    private javax.swing.JButton jbtnProjectPath;
    private javax.swing.JButton jbtnResultPath;
    private javax.swing.JButton jbtnSave1;
    private javax.swing.JButton jbtnSuiteXml;
    private javax.swing.JButton jbtnTestScript;
    private javax.swing.JTextField jtxtClassPath;
    private javax.swing.JTextField jtxtPomXml;
    private javax.swing.JTextField jtxtProjectName;
    private javax.swing.JTextField jtxtProjectPath;
    private javax.swing.JTextField jtxtResultPath;
    private javax.swing.JTextField jtxtSuiteXml;
    private javax.swing.JTextField jtxtTestScript;
    // End of variables declaration
}
