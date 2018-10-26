package com.ExecutionLab;

/**
 * Created by bvatrapu on 8/22/2017.
 */

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Map;

public class CreateXMLFile {

    //public static void main(String argv[]) {

        public void createxml(Map<String, String> params,String classpaths) {

            try {

                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                // root elements
                Document doc = docBuilder.newDocument();

                Element suiteElement = doc.createElement("suite");
                doc.appendChild(suiteElement);
                // set attribute to staff element
                Attr suiteattr = doc.createAttribute("name");
                suiteattr.setValue("Master suite");
                suiteElement.setAttributeNode(suiteattr);

                // staff elements
                Element testElement = doc.createElement("test");
                suiteElement.appendChild(testElement);

                // set attribute to staff element
                Attr testattr = doc.createAttribute("name");
                testattr.setValue("test_with_browser");
                testElement.setAttributeNode(testattr);


                Element pararm1 = doc.createElement("parameter");
                testElement.appendChild(pararm1);
                // set attribute to staff element
                Attr paramname1 = doc.createAttribute("name");
                paramname1.setValue("environment");
                pararm1.setAttributeNode(paramname1);

                Attr paramvalue1 = doc.createAttribute("value");
                paramvalue1.setValue(params.get("environment"));
                pararm1.setAttributeNode(paramvalue1);


                Element pararm2 = doc.createElement("parameter");
                testElement.appendChild(pararm2);
                // set attribute to staff element
                Attr paramname2 = doc.createAttribute("name");
                paramname2.setValue("platformType");
                pararm2.setAttributeNode(paramname2);

                Attr paramvalue2 = doc.createAttribute("value");
                paramvalue2.setValue(params.get("platformType"));
                pararm2.setAttributeNode(paramvalue2);


                Element pararm3 = doc.createElement("parameter");
                testElement.appendChild(pararm3);
                // set attribute to staff element
                Attr paramname3 = doc.createAttribute("name");
                paramname3.setValue("mobileDevice");
                pararm3.setAttributeNode(paramname3);

                Attr paramvalue3 = doc.createAttribute("value");
                paramvalue3.setValue(params.get("mobileDevice"));
                pararm3.setAttributeNode(paramvalue3);


                Element pararm4 = doc.createElement("parameter");
                testElement.appendChild(pararm4);
                // set attribute to staff element
                Attr paramname4 = doc.createAttribute("name");
                paramname4.setValue("browserName");
                pararm4.setAttributeNode(paramname4);

                Attr paramvalue4 = doc.createAttribute("value");
                paramvalue4.setValue(params.get("browserName"));
                pararm4.setAttributeNode(paramvalue4);


                Element pararm5 = doc.createElement("parameter");
                testElement.appendChild(pararm5);
                // set attribute to staff element
                Attr paramname5 = doc.createAttribute("name");
                paramname5.setValue("banner");
                pararm5.setAttributeNode(paramname5);

                Attr paramvalue5 = doc.createAttribute("value");
                paramvalue5.setValue(params.get("banner"));
                pararm5.setAttributeNode(paramvalue5);

                Element pararm6 = doc.createElement("parameter");
                testElement.appendChild(pararm6);
                // set attribute to staff element
                Attr paramname6 = doc.createAttribute("name");
                paramname6.setValue("almIntegration");
                pararm6.setAttributeNode(paramname6);

                Attr paramvalue6 = doc.createAttribute("value");
                paramvalue6.setValue(params.get("almIntegration"));
                pararm6.setAttributeNode(paramvalue6);

                Element pararm7 = doc.createElement("parameter");
                testElement.appendChild(pararm7);
                // set attribute to staff element
                Attr paramname7 = doc.createAttribute("name");
                paramname7.setValue("resultPath");
                pararm7.setAttributeNode(paramname7);

                Attr paramvalue7 = doc.createAttribute("value");
                paramvalue7.setValue(params.get("resultPath"));
                pararm7.setAttributeNode(paramvalue7);


                Element classes = doc.createElement("classes");
                testElement.appendChild(classes);

                Element class1 = doc.createElement("class");
                classes.appendChild(class1);
                // set attribute to staff element
                Attr paramcalssname = doc.createAttribute("name");
                paramcalssname.setValue(classpaths);
                class1.setAttributeNode(paramcalssname);


                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(GlobalVariables.SuiteXmlFilePath));

                // Output to console for testing
                // StreamResult result = new StreamResult(System.out);

                transformer.transform(source, result);

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }
   // }

}