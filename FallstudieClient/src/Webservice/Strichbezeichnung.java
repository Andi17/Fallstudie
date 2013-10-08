
package Webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for strichbezeichnung complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="strichbezeichnung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idStrichart" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="strichbez" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zustand" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "strichbezeichnung", propOrder = {
    "idStrichart",
    "strichbez",
    "zustand"
})
public class Strichbezeichnung {

    protected int idStrichart;
    protected String strichbez;
    protected int zustand;

    /**
     * Gets the value of the idStrichart property.
     * 
     */
    public int getIdStrichart() {
        return idStrichart;
    }

    /**
     * Sets the value of the idStrichart property.
     * 
     */
    public void setIdStrichart(int value) {
        this.idStrichart = value;
    }

    /**
     * Gets the value of the strichbez property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrichbez() {
        return strichbez;
    }

    /**
     * Sets the value of the strichbez property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrichbez(String value) {
        this.strichbez = value;
    }

    /**
     * Gets the value of the zustand property.
     * 
     */
    public int getZustand() {
        return zustand;
    }

    /**
     * Sets the value of the zustand property.
     * 
     */
    public void setZustand(int value) {
        this.zustand = value;
    }

}
