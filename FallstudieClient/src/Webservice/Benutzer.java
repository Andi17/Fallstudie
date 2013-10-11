
package Webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for benutzer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="benutzer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aktuelleOE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="benutzername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idBenutzer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="passwort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "benutzer", propOrder = {
    "aktuelleOE",
    "benutzername",
    "idBenutzer",
    "passwort"
})
public class Benutzer {

    protected int aktuelleOE;
    protected String benutzername;
    protected int idBenutzer;
    protected String passwort;

    /**
     * Gets the value of the aktuelleOE property.
     * 
     */
    public int getAktuelleOE() {
        return aktuelleOE;
    }

    /**
     * Sets the value of the aktuelleOE property.
     * 
     */
    public void setAktuelleOE(int value) {
        this.aktuelleOE = value;
    }

    /**
     * Gets the value of the benutzername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenutzername() {
        return benutzername;
    }

    /**
     * Sets the value of the benutzername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenutzername(String value) {
        this.benutzername = value;
    }

    /**
     * Gets the value of the idBenutzer property.
     * 
     */
    public int getIdBenutzer() {
        return idBenutzer;
    }

    /**
     * Sets the value of the idBenutzer property.
     * 
     */
    public void setIdBenutzer(int value) {
        this.idBenutzer = value;
    }

    /**
     * Gets the value of the passwort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswort() {
        return passwort;
    }

    /**
     * Sets the value of the passwort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswort(String value) {
        this.passwort = value;
    }

}
