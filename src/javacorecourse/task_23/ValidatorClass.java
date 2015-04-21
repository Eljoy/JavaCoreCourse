package javacorecourse.task_23;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by IGazdaliev on 21.04.2015.
 */
public  class ValidatorClass {

    public static boolean validateAgainstXSD(InputStream xml, InputStream xsd) {
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

    public static void main(String[] args) throws Exception{
        InputStream xmlFile = new FileInputStream("C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xml");
        InputStream xsdFile = new FileInputStream("C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xsd");
        System.out.println(validateAgainstXSD(xmlFile, xsdFile));


    }
}
