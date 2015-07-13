
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaxCover complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaxCover">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FaxCoverName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaxCover", propOrder = {
    "faxCoverName"
})
public class FaxCover {

    @XmlElement(name = "FaxCoverName", required = true)
    protected String faxCoverName;

    /**
     * Gets the value of the faxCoverName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxCoverName() {
        return faxCoverName;
    }

    /**
     * Sets the value of the faxCoverName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxCoverName(String value) {
        this.faxCoverName = value;
    }

}
