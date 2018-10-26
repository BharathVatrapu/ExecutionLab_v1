package com.ExecutionLab;



import java.io.*;
import java.sql.Timestamp;
import java.util.Calendar;

//import java.security.Timestamp;

/**
 * Created by BhaRatH on 18-06-2017.
 */
public class HTMLUtils {

    public static PrintWriter writer = null;
    public static String strHTMLFile = "";
    public static String strlogResultPath = "";

    public static void createHTMLReport(){

        String[] strDateTime = getDateTime().split(";");
        String strDate = strDateTime[0].toString();
        String strTime = strDateTime[1].toString();
        strDate = strDate.replace("-","");
        strTime = strTime.replace("-","");
        try{
            createHTMLFile(strDate + "_" +strTime);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void createHTMLFile(String strResult) throws IOException{

        writer = createHTMLWriter(GlobalVariables.ResultsPath,"Result" + strResult + ".html");

        writer.println("<table style=\"table-layout:fixed\"; border=\"2\" CELLPADDING=\"1\" CELLSPACING=\"1\">"
                + "<col width=\"500px\"><col width=\"500px\"><col width=\"500px\"><col width=\"100px\"><col width=\"100px\"><col width=\"100px\">"
                + "<tr align=\"center\" bgcolor=\"#BCBCB3\">"
                + "<td><b>Step #</b></td>"
                + "<td><b>Step Description</b></td>"
                + "<td><b>Step Expected</b></td>"
                + "<td><b>Status</b></td>"
                + "<td><b>Exec Date</b></td>"
                + "<td><b>ExecTime</b></td></tr>");
    }
    private static PrintWriter createHTMLWriter(String outdir,String filename) throws IOException{
        new File(outdir).mkdirs();
        return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir,filename))));
    }
    public static String getDateTime(){
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new Timestamp(calendar.getTime().getTime());
        String strDateTimeStamp = currentTimestamp.toString().replaceAll("[.]"," ");
        String[] arrDateTimeStamp = strDateTimeStamp.split(" ");
        String strDate = arrDateTimeStamp[0].toString();
        String strTime = arrDateTimeStamp[1].toString().replaceAll("[:]","-");
        return  strDate + ";" + strTime;

    }






    public static void closeHTMLFiles(){
        writer.println("</table>");
        writer.flush();
        writer.close();
    }


}
