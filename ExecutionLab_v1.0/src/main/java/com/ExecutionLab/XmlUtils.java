package com.ExecutionLab;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class XmlUtils {

    public String ReadXMLFile(String filePath,String node,String element){
        String returnValue=null;

        try {

            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();



            NodeList nList = doc.getElementsByTagName(node);



            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);



                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    returnValue=eElement.getElementsByTagName(element).item(0).getTextContent();


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnValue;
    }


}
