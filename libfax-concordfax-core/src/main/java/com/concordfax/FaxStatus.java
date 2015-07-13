
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaxStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaxStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FaxJobId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FaxJobStatusId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StatusDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Error" type="{urn:FaxWS}WSError"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaxStatus", propOrder = {
    "faxJobId",
    "faxJobStatusId",
    "statusDescription",
    "error"
})
public class FaxStatus {

    @XmlElement(name = "FaxJobId", required = true)
    protected String faxJobId;
    @XmlElement(name = "FaxJobStatusId")
    protected int faxJobStatusId;
    @XmlElement(name = "StatusDescription", required = true)
    protected String statusDescription;
    @XmlElement(name = "Error", required = true)
    protected WSError error;

    /**
     * Gets the value of the faxJobId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxJobId() {
        return faxJobId;
    }

    /**
     * Sets the value of the faxJobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxJobId(String value) {
        this.faxJobId = value;
    }

    /**
     * Gets the value of the faxJobStatusId property.
     * 
     */
    public int getFaxJobStatusId() {
        return faxJobStatusId;
    }

    /**
     * Sets the value of the faxJobStatusId property.
     * 
     */
    public void setFaxJobStatusId(int value) {
        this.faxJobStatusId = value;
    }

    /**
     * Gets the value of the statusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * Sets the value of the statusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDescription(String value) {
        this.statusDescription = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link WSError }
     *     
     */
    public WSError getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSError }
     *     
     */
    public void setError(WSError value) {
        this.error = value;
    }

}
