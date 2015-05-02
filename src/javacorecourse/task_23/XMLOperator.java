package javacorecourse.task_23;

import javacorecourse.task_23.outputClasses.Collection;
import javacorecourse.task_23.outputClasses.Movie;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
import java.util.LinkedList;
import java.util.List;

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

    //TODO: Никак не абстрагировать??
    public static void convertJavaObjectToXML(String XML_path) throws Exception{
        Collection collection = new Collection();
        collection.setCollectionId("77");
        Movie movie = new Movie();
        movie.setAwards("Oscar");
        movie.setDescription("Just Film");
        movie.setFormat("Blue Ray");
        movie.setGenre("Horror");
        movie.setStars(10);
        movie.setTitle("Perfect comedy");
        movie.setRating("5");
        movie.setYear(1992);
        List movies = new LinkedList<Movie>();
        movies.add(movie);
        collection.setMovie(movies);
        File file = new File(XML_path);
        JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(collection, file);
        marshaller.marshal(collection, System.out);
    }
    //TODO: Узнать, как передать класс и использовать его в методе
    public static Object convertXMLtoJavaObject(String XML_path) throws Exception{
        File file = new File(XML_path);
        JAXBContext jaxbContext = JAXBContext.newInstance(Collection.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return  jaxbUnmarshaller.unmarshal(file);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(validateAgainstXSD("C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xml", "C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xsd"));
        XMLtoHtmlTransform("C:/JavaCoreCourse/src/javacorecourse/task_23/movies-style.xsl", "C:/JavaCoreCourse/src/javacorecourse/task_23/movies.xml", "C:/JavaCoreCourse/src/javacorecourse/task_23/output/result.html" );
        convertJavaObjectToXML("src/javacorecourse/task_23/output/resultCollection.xml");

        Collection collection = (Collection)convertXMLtoJavaObject("src/javacorecourse/task_23/movies.xml");
        System.out.println(collection.getCollectionId());
        for (Movie movie : collection.getMovie()) {
            System.out.println(movie.getTitle());
        }

    }
}
