
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="strPIN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FaxNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TIFFJobFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userID",
    "strPIN",
    "recipientName",
    "faxNumber",
    "tiffJobFile"
})
@XmlRootElement(name = "SimpleSendFax")
public class SimpleSendFax {

    @XmlElement(name = "UserID", required = true)
    protected String userID;
    @XmlElement(required = true)
    protected String strPIN;
    @XmlElement(name = "RecipientName", required = true)
    protected String recipientName;
    @XmlElement(name = "FaxNumber", required = true)
    protected String faxNumber;
    @XmlElement(name = "TIFFJobFile", required = true)
    protected byte[] tiffJobFile;

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the strPIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrPIN() {
        return strPIN;
    }

    /**
     * Sets the value of the strPIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrPIN(String value) {
        this.strPIN = value;
    }

    /**
     * Gets the value of the recipientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientName() {
        return recipientName;
    }

    /**
     * Sets the value of the recipientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientName(String value) {
        this.recipientName = value;
    }

    /**
     * Gets the value of the faxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the value of the faxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNumber(String value) {
        this.faxNumber = value;
    }

    /**
     * Gets the value of the tiffJobFile property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getTIFFJobFile() {
        return tiffJobFile;
    }

    /**
     * Sets the value of the tiffJobFile property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setTIFFJobFile(byte[] value) {
        this.tiffJobFile = value;
    }

}
