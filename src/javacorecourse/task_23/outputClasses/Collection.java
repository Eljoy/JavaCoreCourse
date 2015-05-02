
package javacorecourse.task_23.outputClasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}movie" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}collectionId"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "movie"
})
@XmlRootElement(name = "collection")
public class Collection {



    protected List<Movie> movie;
    @XmlAttribute(name = "collectionId")
    protected String collectionId;

    /**
     * Gets the value of the movie property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the movie property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMovie().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Movie }
     * 
     * 
     */
    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
    public List<Movie> getMovie() {
        if (movie == null) {
            movie = new ArrayList<Movie>();
        }
        return this.movie;
    }

    /**
     * Gets the value of the collectionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionId() {
        return collectionId;
    }

    /**
     * Sets the value of the collectionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionId(String value) {
        this.collectionId = value;
    }

}
