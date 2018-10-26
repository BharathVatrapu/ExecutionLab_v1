package com.ExecutionLab;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestLab {

    // public static String ReleaseName;
    public static int gbltestExecutioncnt = 0;
    //public static String ProjectJavaSourcePath;
    //public static String ProjectJavaBinPath;
    //public static String TestResultPath;
    public static String TestLabselectedPath = "";
    public static String testResultTestCompletePath;
    public static String testResultTestRunPath;
    public static String testcurrentStatus;
    public static String TestName;
    public static boolean gblTestRunning = false;
    public static TreePath TestLabSelectedPathforReSelect;
    public static JTree GblTestLabTree;
    public static JTable testAutomaticRunnerTable;
    public static JTable testInstancesView;
    public static JSplitPane TestLabBottomDataTestcaseSplit;
    public static JTable testLabTestcaseNames;
    public static JTabbedPane testCaseResultTabbedPane;
    public static DefaultTableModel TestAtomaticRunnerModel;
    public static JSplitPane AutRunnerSplitPane;
    public static JSplitPane viewTestInstancesSplitPane;
    //public JEngine JIterface = new JEngine();
    public static JButton jbRunTestSet;
    public static JButton jbRunSelected;
    public static JButton RunAllButton;
    public static JButton RunSelectedButton;
    public static int gblTestCount;
    public static int gblTestPassed;
    public static int gblTestFailed;
    public static int gblTestNoRun;





    @SuppressWarnings("serial")
    protected static JTable createDummyTable() {
        DefaultTableModel TesttableModel = new DefaultTableModel(new Object[]{"#", "Test Name", "Status", "Tester", "Exec Date", "Exec Time"}, 0);
        JTable t = new JTable(TesttableModel);
        return t;
    }

    protected static JTable CreateTestCasesJTable() {
        DefaultTableModel TesttableModel = new DefaultTableModel(new Object[]{"#", "Test Name", "Status", "Tester", "Exec Date", "Exec Time"}, 0);
        testLabTestcaseNames = new JTable(TesttableModel);
        TesttableModel = UpdateTestCaseNamesforSelectedTree(TesttableModel);
        TableColumn col = testLabTestcaseNames.getColumnModel().getColumn(2);
        col.setCellRenderer(new CustomRenderer());
        ListSelectionModel cellSelectionModel = testLabTestcaseNames.getSelectionModel();
        testLabTestcaseNames.setRowSelectionAllowed(true);
        testLabTestcaseNames.setAutoCreateRowSorter(true);
        cellSelectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    String TestResultTestName = testLabTestcaseNames.getValueAt(testLabTestcaseNames.getSelectedRow(), 1).toString();
                    String tmpPackageName1 = GlobalVariables.TestScriptPath;
                    int intpos = tmpPackageName1.indexOf("\\src") + 4;
                    String tmpPackageName2 = tmpPackageName1.substring(intpos);
                    if (tmpPackageName2.length() > 0) {
                        tmpPackageName1 = tmpPackageName2.substring(1) + "\\" + TestLabselectedPath;
                    } else {
                        tmpPackageName1 = TestLabselectedPath;
                    }


                    testResultTestCompletePath = GlobalVariables.ResultsPath + "\\" + GlobalVariables.ReleaseName + "\\" + TestLabselectedPath + "\\" + TestResultTestName;
                    // testResultTestCompletePath = GlobalVariables.ResultsPath + "\\" + TestResultTestName;
                    TestLabBottomDataTestcaseSplit.setRightComponent(addTestCaseResults(testResultTestCompletePath));
                }
            }
        });

        testLabTestcaseNames.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        testLabTestcaseNames.getColumnModel().getColumn(0).setPreferredWidth(30);
        testLabTestcaseNames.getColumnModel().getColumn(1).setPreferredWidth(400);
        return testLabTestcaseNames;
    }

    protected static DefaultTableModel UpdateTestCaseNamesforSelectedTree(DefaultTableModel testNames) {
        String testStatus = "";
        String tester = "";
        String strDate = "";
        String strTime = "";
        File directory = new File(GlobalVariables.TEST_LAB_FOLDER + "\\" + TestLabselectedPath);
        File[] fList = directory.listFiles();
        int cnt = 1;
        for (File file : fList) {
            if (file.isFile()) {

                String tmpPackageName1 = GlobalVariables.TEST_LAB_FOLDER;
                int intpos = tmpPackageName1.indexOf("\\src") + 4;
                String tmpPackageName2 = tmpPackageName1.substring(intpos);
                if (tmpPackageName2.length() > 0) {
                    tmpPackageName1 = tmpPackageName2.substring(1) + "\\" + TestLabselectedPath;
                } else {
                    tmpPackageName1 = TestLabselectedPath;
                }

                String filename = GlobalVariables.ResultsPath + "\\" + GlobalVariables.ReleaseName + "\\" + TestLabselectedPath + "\\" + file.getName().toString().replace(".java", "");
                String a = getTestResultFileAttributes(filename, true);



                if (a != null) {
                    Object[] testDetails = a.split("\\|");
                    testStatus = testDetails[0].toString();
                    tester = testDetails[1].toString();
                    strDate = testDetails[2].toString();
                    strTime = testDetails[3].toString();
                    if (testStatus.contains("Passed")) {
                        gblTestPassed = gblTestPassed + 1;
                    } else {
                        gblTestFailed = gblTestFailed + 1;
                    }
                } else {
                    gblTestNoRun = gblTestNoRun + 1;
                    testStatus = "No Run";
                    tester = "";
                    strDate = "";
                    strTime = "";
                }
                Object[] row = {cnt, file.getName().toString().replace(".java", ""), testStatus, tester, strDate, strTime};
                cnt++;
                testNames.addRow(row);

            }
        }
        return testNames;
    }
    protected static JDesktopPane createMainDesktopPane() {

        JDesktopPane dtp = new JDesktopPane();

        //dtp.setBackground(Color.GREEN);

        JInternalFrame mboxFrame = new JInternalFrame(GlobalVariables.TEST_LAB_FOLDER, true,
                true, true, true);

        mboxFrame.setMaximizable(true);
        mboxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mboxFrame.setLayout(new BorderLayout());

        mboxFrame.add(TestLab.testLabData());
        //mainFrame.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        mboxFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        mboxFrame.setSize(1280,919);

        //mboxFrame.setResizable(false);
        // mboxFrame.setSize(dtp.getWidth(),dtp.getHeight());


        mboxFrame.setLocation(0, 0);
        // mboxFrame.add(Utilities.testLabData());
        mboxFrame.setVisible(true);

        dtp.add(mboxFrame);
        dtp.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        dtp.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        return dtp;
    }

    protected static JFrame createMainFrame() {
        JFrame mainFrame = new JFrame("SAFEWAY");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        mainFrame.add(TestLab.testLabData());
        //mainFrame.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        mainFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return mainFrame;
    }

    /*protected static JTabbedPane createMianTabbedPane(){
        JTabbedPane MaintabbedPane = new JTabbedPane();
        MaintabbedPane.add("TestEx Lab",testLabData());
        return MaintabbedPane;
    }*/

    protected static JSplitPane testLabData() {

        JSplitPane TestLabSplit = new JSplitPane((JSplitPane.VERTICAL_SPLIT));
        TestLabSplit.setDividerLocation(.1);
        TestLabSplit.setRightComponent(testLabBottomData());
        TestLabSplit.setLeftComponent(testLabTopData());

        return TestLabSplit;
    }

    protected static JPanel testLabTopData() {
        //TestEx Lab Top split window
        JPanel testLabLeftPannel = new JPanel();
        JLabel lbltestLab = new JLabel("Project: "+GlobalVariables.ProjectName+"  -  "+"Release:  "+GlobalVariables.ReleaseName);
        lbltestLab.setFont(lbltestLab.getFont().deriveFont(20.0f));
        lbltestLab.setHorizontalAlignment(SwingConstants.LEFT);
        lbltestLab.setForeground(Color.BLUE);

//
//
        testLabLeftPannel.setLayout(new BoxLayout(testLabLeftPannel, BoxLayout.X_AXIS));
        testLabLeftPannel.add(lbltestLab);
//

        GlobalVariables.PackageName = TestLabselectedPath;

//

        return testLabLeftPannel;
    }
    public void RefreshResults(){
        TreePath ParentPath = TestLabSelectedPathforReSelect.getParentPath();
        GblTestLabTree.setSelectionPath(ParentPath);
        GblTestLabTree.setSelectionPath(TestLabSelectedPathforReSelect);
    }

    protected static JSplitPane testLabBottomData() {

        JSplitPane TestLabBottomSplit = new JSplitPane((JSplitPane.HORIZONTAL_SPLIT));
        TestLabBottomSplit.setDividerSize(2);
        TestLabBottomSplit.setDividerLocation(200);
        TestLabBottomSplit.setRightComponent(testLabBottomDataTestcases());
        TestLabBottomSplit.setLeftComponent(new JScrollPane(testLabBottomdataTree()));
        return TestLabBottomSplit;
    }

    protected static JTree testLabBottomdataTree() {
        //  JTree GblTestLabTree = CreateJTree();
        JTree TestLabTree = CreateJTree();

        GblTestLabTree = TestLabTree;
        GblTestLabTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) GblTestLabTree.getLastSelectedPathComponent();

                int k = GblTestLabTree.getModel().getChildCount(selectedNode);
                if (k == 0) {
                    TestLabselectedPath = evt.getPath().toString();
                    TestLabSelectedPathforReSelect = evt.getPath();
                    TestLabselectedPath = TestLabselectedPath.replace(", ", "\\");
                    TestLabselectedPath = TestLabselectedPath.replace("[", "");
                    TestLabselectedPath = TestLabselectedPath.replace("]", "");
                    TestLabselectedPath = TestLabselectedPath.replace("Root\\", "");
                    TestLabselectedPath = TestLabselectedPath.replace("Root", "");
                    gblTestCount = 0;
                    gblTestPassed = 0;
                    gblTestFailed = 0;
                    gblTestNoRun = 0;

                    JScrollPane jsTestLabtestcases1 = new JScrollPane((CreateTestCasesJTable()));
                    jsTestLabtestcases1.getViewport().setBackground(Color.WHITE);
                    //**********
                    JSplitPane jtestCaseSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

                    jtestCaseSplitPane.setDividerSize(0);
                    jtestCaseSplitPane.setDividerLocation(475);

                    jtestCaseSplitPane.setLeftComponent(jsTestLabtestcases1);
                    JPanel testLabLeftPannel1 = new JPanel();
                    int Totalcnt = gblTestPassed + gblTestFailed + gblTestNoRun;
                    JLabel TestCount = new JLabel("Test Count:" + Totalcnt);
                    JLabel TestPassed = new JLabel("Test Passed:" + gblTestPassed);
                    JLabel TestFailed = new JLabel("Test Failed" + gblTestFailed);
                    JLabel TestNoRun = new JLabel("Test No Run:" + gblTestNoRun);
                    testLabLeftPannel1.add(TestCount);
                    testLabLeftPannel1.add(Box.createGlue());
                    testLabLeftPannel1.add(TestPassed);
                    testLabLeftPannel1.add(Box.createGlue());
                    testLabLeftPannel1.add(TestFailed);
                    testLabLeftPannel1.add(Box.createGlue());
                    testLabLeftPannel1.add(TestNoRun);

                    jtestCaseSplitPane.setRightComponent(testLabLeftPannel1);
                    //**********************************
                    TestLabBottomDataTestcaseSplit.setLeftComponent(jtestCaseSplitPane);
                    //
                    TestLabBottomDataTestcaseSplit.setDividerLocation(500);

                } else {
                    //
                    TestLabselectedPath = evt.getPath().toString();
                    TestLabselectedPath = TestLabselectedPath.replace(", ", "\\");
                    TestLabselectedPath = TestLabselectedPath.replace("[", "");
                    TestLabselectedPath = TestLabselectedPath.replace("]", "");
                    TestLabselectedPath = TestLabselectedPath.replace("Root\\", "");
                    TestLabselectedPath = TestLabselectedPath.replace("Root", "");
                }


            }
        });

        return GblTestLabTree;
    }

    protected static JSplitPane testLabBottomDataTestcases() {
        TestLabBottomDataTestcaseSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        TestLabBottomDataTestcaseSplit.setDividerSize(2);
        TestLabBottomDataTestcaseSplit.setDividerLocation(500);
        JPanel left = content("Select Tree for Test Cases");
        TestLabBottomDataTestcaseSplit.setLeftComponent(left);
        JPanel left1 = content("Select Table for Result");
        TestLabBottomDataTestcaseSplit.setLeftComponent(left1);

        return TestLabBottomDataTestcaseSplit;
    }

    protected static JTree CreateJTree() {

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
        String TreeSourcePath = GlobalVariables.TEST_LAB_FOLDER;

        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        addFolders(TreeSourcePath, rootNode);
        JTree TestFoldersTree = new JTree(model);
        return TestFoldersTree;
    }

    protected static JTabbedPane addTestCaseResults(String testcaseResultPath) {

        String latestFileName = getTestResultFileName(testcaseResultPath);
        if (latestFileName == null) {
            testCaseResultTabbedPane = new JTabbedPane();
            JPanel left1 = content("No Result found for test case");
            testCaseResultTabbedPane.addTab("Results", left1);
            return testCaseResultTabbedPane;

        }
        File tempFile = new File(latestFileName);
        //
        boolean exists = tempFile.exists();
        if (exists) {
            JEditorPane tLogResultsEdPane = new JEditorPane();
            tLogResultsEdPane.setEditable(false);
            try {
                //
                tLogResultsEdPane.setPage(new URL("file://localhost/" + tempFile));
            } catch (MalformedURLException e) {
                //
                e.printStackTrace();
            } catch (IOException e) {
                //
                e.printStackTrace();
            }
            JScrollPane tLogResultsScrPane = new JScrollPane(tLogResultsEdPane);
            testCaseResultTabbedPane = new JTabbedPane();
            testCaseResultTabbedPane.addTab("Results", tLogResultsScrPane);

        } else {
            testCaseResultTabbedPane = new JTabbedPane();
            JPanel left1 = content("No Results Found for testcase");
            testCaseResultTabbedPane.addTab("Results", left1);

        }

        return testCaseResultTabbedPane;
    }

    protected static JTabbedPane addTestCaseResultForFile(String testcaseResultPath) {

        File tmpFile = new File(testcaseResultPath);
        //
        boolean exists = tmpFile.exists();
        if (exists) {
            JEditorPane tLogResultsEdPane = new JEditorPane();
            tLogResultsEdPane.setEditable(false);
            try {
                //
                tLogResultsEdPane.setPage(new URL("file://localhost/" + tmpFile));
            } catch (MalformedURLException e) {
                //
                e.printStackTrace();
            } catch (IOException e) {
                //
                e.printStackTrace();
            }
            JScrollPane tLogResultsScrPane = new JScrollPane(tLogResultsEdPane);
            testCaseResultTabbedPane = new JTabbedPane();
            testCaseResultTabbedPane.addTab("Results", tLogResultsScrPane);

        } else {
            testCaseResultTabbedPane = new JTabbedPane();
            JPanel left1 = content("No Results Found for test Case");
            testCaseResultTabbedPane.addTab("Results", left1);

        }

        return testCaseResultTabbedPane;
    }


    public static String getTestResultFileName(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        String fileFullpath = dirPath + "\\" + lastModifiedFile.getName().toString();
        return fileFullpath;
    }

    public static String getTestResultFileAttributes(String dirPath, boolean lastModified) {
        String ReturnFileAttributes;
        String lastModifiedFilename = "";
        String filePath1 = "";

        if (lastModified) {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();

            if (files == null || files.length == 0) {
                return null;
            }

            File lastModifiedFile = files[0];
            for (int i = 1; i < files.length; i++) {
                if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                    lastModifiedFile = files[i];

                }
            }
            lastModifiedFilename = lastModifiedFile.getName().toString();
        }


        if (lastModifiedFilename.length() > 0) {
            filePath1 = dirPath + "\\" + lastModifiedFilename;
        } else {
            filePath1 = dirPath;
        }


        String TestStatus;
        TestStatus = "";

        File input = new File(filePath1);



        //String latestFileName = getTestResultFileName(filePath1);
        try {
            if (input.exists()) {

                //  File inputlatest = new File(latestFileName);
                Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

                //Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

                Elements content = doc.getElementsByAttributeValue("color", "red");



                if (content != null && content.size() > 0) {
                    TestStatus = "Failed";
                } else {
                    TestStatus = "Passed";
                }

            }


        } catch (IOException e) {
            //
            e.printStackTrace();
        }

        File tempFile = null;

        tempFile = new File(filePath1);

        //Get Time
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String strTime = sdf.format(tempFile.lastModified());
        strTime = strTime.substring(strTime.lastIndexOf(" "));

        //Date

        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String strDate = sdf1.format(tempFile.lastModified());
        strDate = strDate.substring(0, strDate.lastIndexOf(" "));
        //


        //Owner
        Path path = Paths.get(filePath1);
        String strOwner = "";
        FileOwnerAttributeView view = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        UserPrincipal userPrincipal;
        try {
            userPrincipal = view.getOwner();
            strOwner = userPrincipal.getName();
            strOwner = strOwner.substring(7);

        } catch (IOException e) {
            //
            e.printStackTrace();
        }



        ReturnFileAttributes = TestStatus + "|" + strOwner + "|" + strDate.trim() + "|" + strTime.trim();

        return ReturnFileAttributes;
    }



    protected static void addFolders(String directoryName1, DefaultMutableTreeNode rootNode1) {

        File directory = new File(directoryName1);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            Path path = Paths.get(file.getAbsolutePath());
            if (file.isDirectory()) {
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(file.getName());
                rootNode1.add(child);
                addFolders(file.getAbsolutePath(), child);
            }
        }
    }

    protected static void RunSelectedTestCases(String strPerform, String PackageName) {

        switch (strPerform) {
            case "SELECTED":

                String tmpPackagename1 = GlobalVariables.TEST_LAB_FOLDER;
                int intpos = tmpPackagename1.indexOf("\\src") + 4;
                String tmpPackageName2 = tmpPackagename1.substring(intpos);
                if (tmpPackageName2.length() > 0) {
                    PackageName = tmpPackageName2.substring(1) + "\\" + PackageName;
                } else {
                }
                if (testLabTestcaseNames.getRowCount() > 0) {
                    if (testLabTestcaseNames.getSelectedRowCount() > 0) {
                        TestAtomaticRunnerModel = new DefaultTableModel(new Object[]{"Test Name", "Status", "Package", "Result"}, 0);
                        int selectedRow[] = testLabTestcaseNames.getSelectedRows();
                        for (int j = 0; j <= selectedRow.length - 1; j++) {
                            Object[] row = {testLabTestcaseNames.getValueAt(selectedRow[j], 1).toString(), "No Run", PackageName, ""};
                            TestAtomaticRunnerModel.addRow(row);
                        }
                        CreateAutomaticRunnerFrame();
                    }
                }
                break;
            case "TESTSET":
                String directoryName = GlobalVariables.TEST_LAB_FOLDER + "\\" + TestLabselectedPath;

                DefaultTableModel TestCaseListmodel = new DefaultTableModel(new Object[]{"Test Name", "Status", "Package", "Result"}, 0);
                TestCaseListmodel = CreateTestCaseModel(directoryName, TestCaseListmodel);
                CreateAutomaticRunnerFrame_TestSet(TestCaseListmodel);
                break;
        }


    }

    protected static DefaultTableModel CreateTestCaseModel(String directoryName1, DefaultTableModel TestCaseListModel) {
        File directory = new File(directoryName1);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            //
            if (file.isFile()) {
                String filePath = file.getAbsolutePath().toString();
                String pkgName = filePath.substring(filePath.indexOf("\\src") + 5).replace("\\" + file.getName().toString(), "");
                pkgName = pkgName.replace("\\", ".");
                Object[] row = {file.getName().toString().replace(".java", ""), "No Run", pkgName};
                TestCaseListModel.addRow(row);
            } else {
                CreateTestCaseModel(file.getAbsolutePath(), TestCaseListModel);
            }
        }
        return TestCaseListModel;
    }

    protected static void CreateAutomaticRunnerFrame() {
        final JFrame AutRunnerframe = new JFrame("Automatic Runner" + "<Root\\" + TestLabselectedPath + ">");
        AutRunnerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AutRunnerSplitPane = new JSplitPane();
        AutRunnerSplitPane.setDividerSize(2);
        AutRunnerSplitPane.setDividerLocation(10);
        AutRunnerSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);


//        JButton RunAllButton = new JButton("Run ALL");
//        RunAllButton.setForeground(Color.BLUE);
//
//        JButton RunSelectedButton = new JButton("Run Selected");
//        RunSelectedButton.setForeground(Color.BLUE);

        JButton StopNextButton = new JButton("Stop Next");
        StopNextButton.setForeground(Color.BLACK);

        JPanel testLabLeftPannel = new JPanel();

        testLabLeftPannel.setLayout(new BoxLayout(testLabLeftPannel, BoxLayout.X_AXIS));

//        testLabLeftPannel.add(Box.createGlue());
//        testLabLeftPannel.add(RunAllButton);
//        testLabLeftPannel.add(Box.createGlue());
//        testLabLeftPannel.add(RunSelectedButton);
        testLabLeftPannel.add(Box.createGlue());
        testLabLeftPannel.add(StopNextButton);
        testLabLeftPannel.add(Box.createGlue());


        AutRunnerSplitPane.setLeftComponent(testLabLeftPannel);
        testAutomaticRunnerTable = new JTable(TestAtomaticRunnerModel);
        AutRunnerSplitPane.setRightComponent(new JScrollPane(testAutomaticRunnerTable));
        AutRunnerframe.add(AutRunnerSplitPane);
        AutRunnerframe.pack();
        AutRunnerframe.setVisible(true);
        AutRunnerframe.setLocationRelativeTo(null);
        AutRunnerframe.setSize(600, 400);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                gbltestExecutioncnt = 0;
                runsynchronoustest_All(0);
            }
        });
        t1.start();

//
        StopNextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gblTestRunning = false;
                DefaultTableModel GlobalModel1 = (DefaultTableModel) testAutomaticRunnerTable.getModel();
                for (int i = gbltestExecutioncnt + 1; i < testAutomaticRunnerTable.getRowCount(); i++) {
                    String SelectedStatus = GlobalModel1.getValueAt(i, 1).toString();
                    if (SelectedStatus.contains("waiting")) {
                        GlobalModel1.setValueAt("Stoped", i, 1);
                        GlobalModel1.fireTableRowsUpdated(i, i);
                    }
                }
            }
        });

        AutRunnerframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (gblTestRunning == true) {
                    JFrame joption = new JFrame();
                    JOptionPane.showMessageDialog(joption, "Still Running test Scripts", "Warning", JOptionPane.OK_OPTION);
                    AutRunnerframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                if (gblTestRunning == false) {
//                    jbRunTestSet.setEnabled(true);
//                    jbRunSelected.setEnabled(true);
                    TreePath ParentPath = TestLabSelectedPathforReSelect.getParentPath();
                    GblTestLabTree.setSelectionPath(ParentPath);
                    GblTestLabTree.setSelectionPath(TestLabSelectedPathforReSelect);
                    AutRunnerframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }

            }

        });


    }

    protected static void CreateAutomaticRunnerFrame_TestSet(DefaultTableModel TestCaseListModel) {
        final JFrame AutRunnerframe = new JFrame("Automatic Runner" + "<Root\\" + TestLabselectedPath + ">");
        AutRunnerSplitPane = new JSplitPane();
        AutRunnerSplitPane.setDividerSize(2);
        AutRunnerSplitPane.setDividerLocation(10);
        AutRunnerSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        AutRunnerframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



        JButton StopNextButton = new JButton("Stop Next");
        StopNextButton.setForeground(Color.BLUE);

        JPanel testLabLeftPannel = new JPanel();

        testLabLeftPannel.setLayout(new BoxLayout(testLabLeftPannel, BoxLayout.X_AXIS));

        testLabLeftPannel.add(Box.createGlue());
        testLabLeftPannel.add(StopNextButton);
        testLabLeftPannel.add(Box.createGlue());


        AutRunnerSplitPane.setLeftComponent(testLabLeftPannel);
        testAutomaticRunnerTable = new JTable(TestCaseListModel);
        AutRunnerSplitPane.setRightComponent(new JScrollPane(testAutomaticRunnerTable));
        AutRunnerframe.add(AutRunnerSplitPane);
        AutRunnerframe.pack();
        AutRunnerframe.setVisible(true);
        AutRunnerframe.setLocationRelativeTo(null);
        AutRunnerframe.setSize(600, 400);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                gbltestExecutioncnt = 0;
                runsynchronoustest_All(0);
            }
        });
        t1.start();
        StopNextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gblTestRunning = false;
                DefaultTableModel GlobalModel1 = (DefaultTableModel) testAutomaticRunnerTable.getModel();
                for (int i = gbltestExecutioncnt + 1; i < testAutomaticRunnerTable.getRowCount(); i++) {
                    String SelectedStatus = GlobalModel1.getValueAt(i, 1).toString();
                    if (SelectedStatus.contains("waiting")) {
                        GlobalModel1.setValueAt("Stoped", i, 1);
                        GlobalModel1.fireTableRowsUpdated(i, i);
                    }
                }
            }
        });

        AutRunnerframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (gblTestRunning == true) {
                    JFrame joption = new JFrame();
                    JOptionPane.showMessageDialog(joption, "Still Running test Scripts", "Warning", JOptionPane.OK_OPTION);
                    AutRunnerframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                if (gblTestRunning == false) {
//                    jbRunTestSet.setEnabled(true);
//                    jbRunSelected.setEnabled(true);
                    TreePath ParentPath = TestLabSelectedPathforReSelect.getParentPath();
                    GblTestLabTree.setSelectionPath(ParentPath);
                    GblTestLabTree.setSelectionPath(TestLabSelectedPathforReSelect);
                    AutRunnerframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }

        });
    }


    protected static void runsynchronoustest_All(int runRow) {
        gblTestRunning = true;

        if (gbltestExecutioncnt == 0) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    for (int i = 0; i < testAutomaticRunnerTable.getRowCount(); i++) {
                        DefaultTableModel GlobalModel1 = (DefaultTableModel) testAutomaticRunnerTable.getModel();
                        GlobalModel1.setValueAt("Waiting...", i, 1);
                        GlobalModel1.fireTableRowsUpdated(i, i);
                    }
                }
            });
        }

        try {
            String TestResultTestName = testAutomaticRunnerTable.getValueAt(runRow, 0).toString();
            TestLab ut = new TestLab();
            ut.RunEachTestCase(TestResultTestName, runRow);
        } finally {
            if (runRow < testAutomaticRunnerTable.getRowCount() - 1 && gblTestRunning == true) {
                runRow = runRow + 1;
                gbltestExecutioncnt = gbltestExecutioncnt + 1;
                runsynchronoustest_All(runRow);
            } else {

                gblTestRunning = false;
            }
        }
    }


    protected static void runsynchronoustest_Selected(int runRow, int[] selectedRow) {
        gblTestRunning = true;

        if (gbltestExecutioncnt == 0) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    int selectedRows[] = testAutomaticRunnerTable.getSelectedRows();
                    for (int i = 0; i < selectedRows.length; i++) {
                        DefaultTableModel GlobalModel1 = (DefaultTableModel) testAutomaticRunnerTable.getModel();
                        GlobalModel1.setValueAt("waiting...", selectedRows[i], 1);
                        GlobalModel1.fireTableRowsUpdated(selectedRows[i], selectedRows[i]);
                    }
                }
            });
        }

        try {
            String TestResultTestName = testAutomaticRunnerTable.getValueAt(selectedRow[runRow], 0).toString();
            TestLab ut = new TestLab();
            ut.RunEachTestCase(TestResultTestName, selectedRow[runRow]);
        } finally {
            if (runRow < selectedRow.length - 1 && gblTestRunning == true) {
                runRow = runRow + 1;
                runsynchronoustest_Selected(runRow, selectedRow);
            } else {
                gblTestRunning = false;
            }
        }
    }

    protected void RunEachTestCase(String TestResultTestName, int runRow) {
        Generic generic=new Generic();
        DefaultTableModel GlobalModel1 = (DefaultTableModel) testAutomaticRunnerTable.getModel();

        GlobalModel1.setValueAt("Running", runRow, 1);
        GlobalModel1.fireTableRowsUpdated(runRow, runRow);
        String TestPkgName = testAutomaticRunnerTable.getValueAt(runRow, 2).toString();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        testResultTestRunPath = GlobalVariables.ResultsFullPath + "\\" + TestLabselectedPath + "\\" + TestResultTestName;
        //  .println("testResultTestRunPath::"+testResultTestRunPath);
        generic.createFoldersPath(testResultTestRunPath);
        HTMLUtils.createHTMLReport();
        // generic.ReportEvent("Started", "", "Done");
        try {
            testNGrun(TestResultTestName, TestPkgName);
        } finally {
            //  generic.ReportEvent("Ended", "", "Ends");
            HTMLUtils.closeHTMLFiles();
            GlobalModel1.setValueAt("Completed", runRow, 1);
            GlobalModel1.fireTableRowsUpdated(runRow, runRow);

        }


    }

    protected static void testNGrun(String TestName, String PkgName) {

        PkgName = PkgName + "." + TestName;
        String tmpPackageName1=GlobalVariables.TEST_LAB_FOLDER;

        int intpos = tmpPackageName1.indexOf("\\src")+4;
        String tmpPackageName= tmpPackageName1.substring(intpos);


        String FinalPackgName="";

        if(tmpPackageName.length() > 0){
            FinalPackgName=tmpPackageName.replace("\\",".") + "." + TestLabselectedPath.replace("\\",".") + "." + TestName;

            FinalPackgName = FinalPackgName.substring(FinalPackgName.indexOf("com."));
        } else{
            FinalPackgName=TestLabselectedPath.replace("\\",".") + "." + TestName;
            FinalPackgName = FinalPackgName.substring(FinalPackgName.indexOf("com."));

        }

        File root = new File(GlobalVariables.ProjectClassPath);



        try {
            CreateXMLFile createXMLFile =new CreateXMLFile();
            Map<String, String> params = new HashMap<String, String>();

            JsonUtils jsonUtils=new JsonUtils();
            jsonUtils.ReadconfiginiFile();
            TextfileUtils textfileUtils=new TextfileUtils();

            //HashMap<String, String> hashMap = jsonUtils.parseJson(GlobalVariables.TestNGParamsPath);
            HashMap<String, String> hashMap = textfileUtils.readTestParams(GlobalVariables.TestParamsPath);
            for(HashMap.Entry<String, String> entry : hashMap.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                value=value.replace("\"", "");
                params.put(key, value);
            }
            params.put("resultPath",testResultTestCompletePath);


            createXMLFile.createxml(params,FinalPackgName);
            Generic generic=new Generic();
            GlobalVariables.MVN_bat_Content = GlobalVariables.MVN_bat_Content+GlobalVariables.ProjectPOMPath;
            generic.CmdRun(GlobalVariables.MVN_bat_Content,GlobalVariables.MVN_FILE_PATH);

            //program.testRunner(params,FinalPackgName);

            // }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static JPanel content(String s) {
        final JLabel label = new JLabel(s, JLabel.CENTER);
        JPanel panel = new JPanel((new GridLayout())) {

            @Override
            public Dimension getPreferredSize() {
                Dimension d = label.getPreferredSize();
                return new Dimension(d.width * 2, d.height * 3);
            }
        };
        panel.setOpaque(true);
        panel.setBackground(Color.white);
        panel.add(label);
        return panel;

    }

    private static void ViewTestRun(JTable TestCaseList) {
        if (TestCaseList.getRowCount() > 0) {
            if (TestCaseList.getSelectedRowCount() > 0) {
                int selectedRows[] = TestCaseList.getSelectedRows();
                String TestResultTestName = TestCaseList.getValueAt(selectedRows[0], 1).toString();

                String tmpPackageName1 = GlobalVariables.TEST_LAB_FOLDER;
                int intpos = tmpPackageName1.indexOf("\\src") + 4;
                String tmpPackageName2 = tmpPackageName1.substring(intpos);
                if (tmpPackageName2.length() > 0) {
                    tmpPackageName1 = tmpPackageName2.substring(1) + "\\" + TestLabselectedPath;
                } else {
                    tmpPackageName1 = TestLabselectedPath;
                }
                testResultTestCompletePath = GlobalVariables.ResultsPath + "\\" + GlobalVariables.ReleaseName + "\\" + tmpPackageName1 + "\\" + TestResultTestName;

                File folder = new File(testResultTestCompletePath);
                File[] listOfFiles = folder.listFiles();

                DefaultTableModel TestRuntableModel = new DefaultTableModel(new Object[]{"#", "Run Name", "Status", "Date", "Time", "Tester"}, 0);

                for (int i = 0; i <= listOfFiles.length - 1; i++) {

                    String testStatus = "";
                    String tester = "";
                    String strDate = "";
                    String strTime = "";

                    String filename = listOfFiles[i].toString();
                    String a = getTestResultFileAttributes(filename, false);
                    if (a != null) {
                        Object[] testDetails = a.split("\\|");
                        testStatus = testDetails[0].toString();
                        tester = testDetails[1].toString();
                        strDate = testDetails[2].toString();
                        strTime = testDetails[3].toString();
                    }
                    Object[] row = {i + 1, listOfFiles[i].getName(), testStatus, strDate, strTime, tester};
                    TestRuntableModel.addRow(row);
                }
                testInstancesView = new JTable(TestRuntableModel);
                TableColumn col = testInstancesView.getColumnModel().getColumn(2);
                col.setCellRenderer(new CustomRenderer());
                testInstancesView.setAutoCreateRowSorter(true);

                //
                testInstancesView.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                testInstancesView.setCellSelectionEnabled(true);
                ListSelectionModel TestRuncellSelectionModel2 = testInstancesView.getSelectionModel();

                TestRuncellSelectionModel2.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        String TestResultTestName = testInstancesView.getValueAt(testInstancesView.getSelectedRow(), 1).toString();
                        viewTestInstancesSplitPane.setRightComponent(addTestCaseResultForFile(testResultTestCompletePath + "\\" + TestResultTestName));
                    }
                });
                JFrame ViewTestRunFrme = new JFrame("View Test Runs" + TestResultTestName);
                viewTestInstancesSplitPane = new JSplitPane();
                viewTestInstancesSplitPane.setDividerSize(2);
                viewTestInstancesSplitPane.setDividerLocation(300);
                viewTestInstancesSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
                viewTestInstancesSplitPane.setLeftComponent(new JScrollPane(testInstancesView));
                testCaseResultTabbedPane = new JTabbedPane();
                JPanel left1 = content("No Results Found for test Cases");
                testCaseResultTabbedPane.addTab("Results", left1);
                viewTestInstancesSplitPane.setRightComponent(testCaseResultTabbedPane);
                ViewTestRunFrme.add(viewTestInstancesSplitPane);
                ViewTestRunFrme.pack();
                ViewTestRunFrme.setVisible(true);
                ViewTestRunFrme.setLocationRelativeTo(null);
                ViewTestRunFrme.setSize(800, 600);
                ViewTestRunFrme.setAlwaysOnTop(true);


            }
        }
    }
    public void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
