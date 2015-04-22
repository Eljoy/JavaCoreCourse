package javacorecourse.task_23;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by IGazdaliev on 21.04.2015.
 */
public  class XMLOperator {

    public static boolean validateAgainstXSD(String xmlLocation, String xsdLocation){
        FileInputStream xml = null;
        FileInputStream xsd = null;
        try {
             xml = new FileInputStream(xmlLocation);
             xsd = new FileInputStream(xsdLocation);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public static void XMLtoHtmlTransform(String xsltAddress, String xmlAddress, String resultAddress) throws TransformerException{
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xsltAddress));
        Transformer transformer = factory.newTransformer(xslt);
        Source text = new StreamSource(new File(xmlAddress));
        transformer.transform(text, new StreamResult(new File(resultAddress)));
    }
//http://www.mkyong.com/java/jaxb-hello-world-example/
    public static void main(String[] args) throws Exception{
        System.out.println(validateAgainstXSD("C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xml", "C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xsd"));
        XMLtoHtmlTransform("C:/JavaCoreCourse/src/javacorecourse/task_23/movies-style.xsl", "C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xml", "C:/JavaCoreCourse/src/javacorecourse/task_23/result.html" );
    }
}
