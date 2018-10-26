package com.ExecutionLab;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bvatrapu on 16-07-2017.
 */
public class JsonUtils{


    public HashMap<String, String> parseJson(String filePath)  {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            //String filePath = GlobalVariables.desktopPath + "\\" + GlobalVariables.configFileName;
            File json = new File(filePath);
            JsonFactory factory = new JsonFactory();
            ObjectMapper mapper = new ObjectMapper(factory);
            JsonNode rootNode = mapper.readTree(json);

            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
            while (fieldsIterator.hasNext()) {
                Map.Entry<String, JsonNode> field = fieldsIterator.next();
                String key = field.getKey().toString();
                String value = field.getValue().toString();
                map.put(key, value);

            }


        }catch (FileNotFoundException ex) {

            ex.printStackTrace();

        } catch (IOException ex) {

            ex.printStackTrace();

        } catch (NullPointerException ex) {

            ex.printStackTrace();

        }

        return map;
    }

    public void writeJson(JSONObject obj,String filePath) {
        try (FileWriter file = new FileWriter(filePath, true)) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteconfiginiFile(String projectName,String releaseName) {
        JSONObject obj = new JSONObject();
        obj.put("ProjectName", projectName);
        obj.put("ReleaseName", releaseName);

        try (FileWriter file = new FileWriter(GlobalVariables.CONFIG_FILE_PATH)) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadconfiginiFile() {
        try {
            FileReader reader = new FileReader(GlobalVariables.CONFIG_FILE_PATH);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            GlobalVariables.ProjectName=(String) jsonObject.get("ProjectName");
            GlobalVariables.ReleaseName=(String) jsonObject.get("ReleaseName");

        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
    public static void WriteProjectconfigFile(String filePath,String projectName,String projectPath,String testScriptPath,String classpath,String pomXmlPath, String SuiteXmlPath,String resultPath) {
        JSONObject obj = new JSONObject();
        obj.put("ProjectName", projectName);
        obj.put("ProjectPath", projectPath);
        obj.put("TestScriptPath", testScriptPath);
        obj.put("ClassPath", classpath);
        obj.put("pomXMLPath", pomXmlPath);
        obj.put("SuiteXMLPath", SuiteXmlPath);
        obj.put("ResultPath", resultPath);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadProjectconfigFile(String filePath) {

        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            GlobalVariables.ProjectPath = (String) jsonObject.get("ProjectPath");
            GlobalVariables.TestScriptPath = (String) jsonObject.get("TestScriptPath");
            GlobalVariables.ProjectClassPath = (String) jsonObject.get("ClassPath");
            GlobalVariables.ProjectPOMPath = (String) jsonObject.get("pomXMLPath");
            GlobalVariables.SuiteXmlFilePath = (String) jsonObject.get("SuiteXMLPath");
            GlobalVariables.ResultsPath = (String) jsonObject.get("ResultPath");

        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}
