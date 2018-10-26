package com.ExecutionLab;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Enumeration;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileReader;


/**
 * Created by BhaRatH on 15-07-2017.
 */
public class Generic {
    private String ResultFileName;
    private TextfileUtils textfileUtils=null;
    private JsonUtils jsonUtils=null;
    public Generic() {
        textfileUtils=new TextfileUtils();
        jsonUtils=new JsonUtils();
    }

    public String ReadPOMXML(String filePath,String keyString){
        String returnValue=null;
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader(filePath));

            switch (keyString) {
                case "artifactId":
                    returnValue = model.getArtifactId();
                    break;
                case "groupId":
                    model.getGroupId();
                    break;
                case "version":
                    model.getVersion();
                    break;
            }

        }catch (Exception e) {
                e.printStackTrace();
            }
        return returnValue;

    }


    public String choosefolderPath(){
       // JOptionPane.showMessageDialog(null,"Select Project Directory upto 'src' Path!");
        String strPath = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Choose Path");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            strPath = chooser.getSelectedFile().toString();
           GlobalVariables.ProjectDirectoryPath = chooser.getCurrentDirectory().toString();
        } else {
            JOptionPane.showMessageDialog(null,"Select Project Directory Path only!");
        }
        System.out.println("strPath::"+strPath);
        return strPath;
    }

    public void loadProjectpaths(){
        if (GlobalVariables.ProjectPath!=null){
        if(GlobalVariables.ProjectPath.contains("src")) {
            int intpos = GlobalVariables.ProjectPath.indexOf("\\src");
            GlobalVariables.ProjectPath = GlobalVariables.ProjectPath.substring(0, intpos);
        } else{
            GlobalVariables.ProjectPath = GlobalVariables.ProjectPath;
        }
        }else {
            new Lanucher().setVisible(true);
        }
        GlobalVariables.ProjectClassPath = GlobalVariables.ProjectPath.replace("\\","/")+"/"+"target/test-classes";
        //GlobalVariables.ProjectClassPath = GlobalVariables.ProjectPath+"\\"+"target\\test-classes";
        GlobalVariables.ProjectPOMPath=GlobalVariables.ProjectPath+"\\"+"pom.xml";
        GlobalVariables.SuiteXmlFilePath=GlobalVariables.ProjectPath.replace("\\","/")+"/src/test/testExecutionDriver/Master/testNG-Master.xml";
        GlobalVariables.TestScriptPath=GlobalVariables.ProjectPath+"\\src\\test\\java\\com\\albertsons\\"+GlobalVariables.ProjectName+"\\automation\\testsuites";
        GlobalVariables.ResultsPath=GlobalVariables.ProjectPath+"\\"+GlobalVariables.ResultsFolder;
    }

    public static void createNewFolder(String folderPath, String folderName) {

        String strfolderPath = folderPath+ "\\" +folderName;
        File file = new File(strfolderPath);
        if (!file.exists()) {
            file.mkdir();
        }

    }

    public static void createFoldersPath(String folderPath) {

        String fstrfolderPath;
        String[] strfolderPath=folderPath.split("\\\\");
        fstrfolderPath=strfolderPath[0];
        for (int j = 1; j <= strfolderPath.length-1; j++) {

            fstrfolderPath=fstrfolderPath+"\\"+strfolderPath[j];
            createNewFolder(fstrfolderPath);
        }

    }


     public static void CmdRun(String content,String batFilePath) throws Exception {

         TextfileUtils readTextfile=new TextfileUtils();
         readTextfile.WriteTextfile(batFilePath,content);
         batFilePath=batFilePath.replace("\\","/");

         ProcessBuilder processBuilder = new ProcessBuilder(batFilePath);
         processBuilder.directory(new File("D:/"));
         File log = new File(GlobalVariables.MVN_Log_File_Path.replace("\\","/"));
         processBuilder.redirectErrorStream(true);
         processBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
         Process p = processBuilder.start();
         p.waitFor();

         BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
         String line;
         while (true) {
           line = r.readLine();
           if (line == null) { break; }
         }
        }

    public static void createNewFolder(String folderPath) {

        File file = new File(folderPath);
        if (!file.exists()) {
            if (file.mkdir()) {
              //  System.out.println("Directory is created!");
            } else {
               // System.out.println("Failed to create directory!");
            }
        }

    }
    public static boolean createNewFile(String filePath, String fileName) {
        boolean returnStatus=true;
        String strfilePath=filePath+ "\\" +fileName;
        File strFileExists;
        strFileExists = new File(strfilePath);
        boolean exists = strFileExists.exists();
        if(!exists) {
            try {
                //String desktopPath = System.getProperty("user.home") + "\\Desktop";
                File file = new File(strfilePath);
                if (file.createNewFile()) {
                    //System.out.println("File is created!");
                    JOptionPane.showMessageDialog(null,"Done");
                } else {
                    //System.out.println("File already exists.");
                    JOptionPane.showMessageDialog(null,"'"+fileName+"': File already exists!");
                    returnStatus=false;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnStatus;
    }

    public static void createNewFile(String filePath) {

        File strFileExists;
        strFileExists = new File(filePath);
        boolean exists = strFileExists.exists();
        if(!exists) {
            try {
                //String desktopPath = System.getProperty("user.home") + "\\Desktop";
                File file = new File(filePath);
                if (file.createNewFile()) {
                    System.out.println("File is created!");
                } else {
                    System.out.println("File already exists.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean verifyFileExist(String filePath) {
        File strFileExists;
        strFileExists = new File(filePath);
        boolean exists = strFileExists.exists();
        return exists;
    }

    public void initSetup(){
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String stryear = String.valueOf(year);
            System.out.println("YEAR::"+year);
            createNewFolder(GlobalVariables.SETUP_FOLDER_PATH, GlobalVariables.ROOT_FOLDER);
            createNewFolder(GlobalVariables.ROOT_FOLDER_PATH, GlobalVariables.CONFIG_FOLDER);
            createNewFolder(GlobalVariables.ROOT_FOLDER_PATH, GlobalVariables.PROJECTS_FOLDER);
            createNewFolder(GlobalVariables.ROOT_FOLDER_PATH, GlobalVariables.TEST_LAB_FOLDER);
            createNewFolder(GlobalVariables.TEST_LAB_FOLDER_PATH, stryear);
            createNewFile(GlobalVariables.MVN_FILE_PATH);
            //createNewFile(GlobalVariables.Config_FilePath);
    }

    public void createDir() throws Exception{
        Path pathToFile = Paths.get("D:\\Dir1\\Dir2\\Dir3");
        Files.createDirectories(pathToFile.getParent());
    }

    public void loadConfigParams(){
        jsonUtils.ReadconfiginiFile();
    }
    public void loadProjectConfigParams(){
        jsonUtils.ReadProjectconfigFile(GlobalVariables.ProjectConfigFilePath);
    }

    public String loadParamsfromTextFile(String filePath){
        TextfileUtils textfile = new TextfileUtils();
        String content=textfile.ReadTextfile(filePath);
        System.out.println("testParam:"+content);
        return content;
    }

    public String getSelectedRadioButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }



    public void WriteTestParamsFile_Safeway(String environment,String browserName,String banner,String platformType,String mobileDevice,String almIntegration) {

        String content = "environment:"+environment+"|"+"browserName:"+browserName+"|"+"banner:"+banner+"|"+"platformType:"+platformType+"|"+"mobileDevice:"+mobileDevice+"|"+"almIntegration:"+almIntegration;

        GlobalVariables.TestParams_Safeway = GlobalVariables.PROJECTS_FOLDER+"\\"+GlobalVariables.ProjectName+"\\"+GlobalVariables.ProjectName+"_"+GlobalVariables.TestParams_File;
        if(!verifyFileExist(GlobalVariables.TestParams_Safeway)){
            createNewFile(GlobalVariables.TestParams_Safeway);
        }
        textfileUtils.WriteTextfile(GlobalVariables.TestParams_Safeway,content);
    }

}
