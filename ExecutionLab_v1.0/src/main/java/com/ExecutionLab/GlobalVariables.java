package com.ExecutionLab;

import java.io.File;

/**
 * Created by bvatrapu on 7/14/2017.
 */
public class GlobalVariables {

    public static String FS = File.separator;



    //Folder Names
    public static final String ROOT_FOLDER = "ExecutionLab";
    public static String CONFIG_FOLDER = "Config";
    public static String PROJECTS_FOLDER = "Projects";
    public static String TEST_LAB_FOLDER = "TestLab";
    public static String RESULTS_FOLDER = "ExecutionLab_Results";

    //File Names
    public static String MVN_File = "mvn.bat";
    public static String Config_File = "ExecutionLab_ini.json";
    public static String TestParams_File = "TestParams.txt";

    //Paths
    public static String SETUP_FOLDER_PATH = System.getProperty("user.home") +FS+"Documents";
    public static String ROOT_FOLDER_PATH = SETUP_FOLDER_PATH+FS+ROOT_FOLDER;
    public static String CONFIG_FOLDER_PATH = ROOT_FOLDER_PATH+FS+CONFIG_FOLDER;
    public static String PROJECTS_FOLDER_PATH = ROOT_FOLDER_PATH+"\\"+PROJECTS_FOLDER;
    public static String TEST_LAB_FOLDER_PATH = ROOT_FOLDER_PATH+FS+TEST_LAB_FOLDER;



    public static String CONFIG_FILE_PATH = CONFIG_FOLDER_PATH+FS+Config_File;
    public static String MVN_FILE_PATH = ROOT_FOLDER_PATH+"\\"+MVN_File;
    public static String MVN_Log_File_Path = ROOT_FOLDER_PATH+"\\MVN_Log.txt";




    public static String ConfigFolder = "Config";
    public static String ProjectsFolder = "Projects";
    public static String ResultsFolder = "ExecutionLab_Results";

    public static String D_DrivePath = "D:\\";
    public static String Documents_Path = System.getProperty("user.home") +"\\Documents"+"\\";




    public static String MobileType_File = "MobileType.txt";





    public static String TestParams_Safeway = null;

    public static String ResultsPath = null;
    public static String ResultsFullPath = null;
    public static String ProjectPath=null;
    public static String SuiteXmlFilePath=null;
    public static String TestScriptPath=null;


    public static String ProjectName=null;
    public static String ReleaseName = null;
    public static String ProjectSourcePath=null;
    public static String ProjectClassPath=null;
    public static String ProjectPOMPath=null;

    public static String ProjectDirectoryPath=null;

    public static String environment=null;
    public static String browserName=null;
    public static String banner=null;
    public static String platformType=null;
    public static String mobileDevice=null;
    public static String almIntegration=null;

    public static String PackageName=null;


    public static String MVN_bat_Content="cd %MAVEN_HOME%/bin\n" +
            "call mvn clean compile test -X -f ";
    public static String ProjectConfigFilePath=null;


    public static String TestParamsPath=null;
    public static String TestParams=null;

}
