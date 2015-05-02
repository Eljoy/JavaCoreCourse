
package javacorecourse.task_23.outputClasses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the task_23.output package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Year_QNAME = new QName("", "year");
    private final static QName _Awards_QNAME = new QName("", "awards");
    private final static QName _Genre_QNAME = new QName("", "genre");
    private final static QName _Format_QNAME = new QName("", "format");
    private final static QName _Rating_QNAME = new QName("", "rating");
    private final static QName _Description_QNAME = new QName("", "description");
    private final static QName _Stars_QNAME = new QName("", "stars");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: task_23.output
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Collection }
     * 
     */
    public Collection createCollection() {
        return new Collection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "year")
    public JAXBElement<Integer> createYear(Integer value) {
        return new JAXBElement<Integer>(_Year_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "awards")
    public JAXBElement<String> createAwards(String value) {
        return new JAXBElement<String>(_Awards_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "genre")
    public JAXBElement<String> createGenre(String value) {
        return new JAXBElement<String>(_Genre_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "format")
    public JAXBElement<String> createFormat(String value) {
        return new JAXBElement<String>(_Format_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rating")
    public JAXBElement<String> createRating(String value) {
        return new JAXBElement<String>(_Rating_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "stars")
    public JAXBElement<Integer> createStars(Integer value) {
        return new JAXBElement<Integer>(_Stars_QNAME, Integer.class, null, value);
    }

}
