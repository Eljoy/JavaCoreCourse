
package javacorecourse.task_23.outputClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{}genre"/>
 *         &lt;element ref="{}format"/>
 *         &lt;element ref="{}year"/>
 *         &lt;element ref="{}rating"/>
 *         &lt;element ref="{}stars"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}awards"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}title"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "genre",
    "format",
    "year",
    "rating",
    "stars",
    "description",
    "awards"
})
@XmlRootElement(name = "movie")
public class Movie {

    @XmlElement(required = true)
    protected String genre;
    @XmlElement(required = true)
    protected String format;
    protected int year;
    @XmlElement(required = true)
    protected String rating;
    protected int stars;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String awards;
    @XmlAttribute(name = "title")
    protected String title;

    /**
     * Gets the value of the genre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRating(String value) {
        this.rating = value;
    }

    /**
     * Gets the value of the stars property.
     * 
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     * 
     */
    public void setStars(int value) {
        this.stars = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the awards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwards() {
        return awards;
    }

    /**
     * Sets the value of the awards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwards(String value) {
        this.awards = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
