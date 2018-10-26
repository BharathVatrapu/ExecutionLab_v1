package com.ExecutionLab;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class TextfileUtils {

    public void WriteTextfile(String filePath,String content) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
           // String content = "This is the content to write into file\n";

            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            bw.write(content);

           // System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
    public String ReadTextfile(String filePath) {
        File file = new File(filePath);
        StringBuilder line = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                line.append(text);
                     //   .append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return line.toString();
    }

    public HashMap<String, String> readTestParams(String filePath)  {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            //String filePath = GlobalVariables.desktopPath + "\\" + GlobalVariables.configFileName;
            String readParam = ReadTextfile(filePath);
            String[] testParams=readParam.split("\\|");

            for(int i=0;i<=testParams.length-1;i++){
                String[] eachParam=testParams[i].split("\\:");
                String key = eachParam[0].toString();
                String value = eachParam[1].toString();
                System.out.println("key:"+key+"value:"+value);
                map.put(key, value);
            }


        }catch (NullPointerException ex) {

            ex.printStackTrace();

        }

        return map;
    }
    public void strTestParams()  {
        Generic generic=new Generic();
        if(generic.verifyFileExist(GlobalVariables.TestParamsPath)){
            String readParams = ReadTextfile(GlobalVariables.TestParamsPath);
            GlobalVariables.TestParams=readParams;
        }

    }
}