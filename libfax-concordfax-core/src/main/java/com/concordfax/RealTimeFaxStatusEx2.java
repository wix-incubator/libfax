
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RealTimeFaxStatusEx2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RealTimeFaxStatusEx2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FaxJobId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FaxJobStatusId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StatusDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RecipientCurrentPageCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RecipientTotalPageCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FaxDeliveryDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FaxDeliveryDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RemoteFaxCSID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "RealTimeFaxStatusEx2", propOrder = {
    "faxJobId",
    "faxJobStatusId",
    "statusDescription",
    "recipientState",
    "recipientCurrentPageCount",
    "recipientTotalPageCount",
    "faxDeliveryDateTime",
    "faxDeliveryDuration",
    "remoteFaxCSID",
    "referenceId",
    "error"
})
public class RealTimeFaxStatusEx2 {

    @XmlElement(name = "FaxJobId", required = true)
    protected String faxJobId;
    @XmlElement(name = "FaxJobStatusId")
    protected int faxJobStatusId;
    @XmlElement(name = "StatusDescription", required = true)
    protected String statusDescription;
    @XmlElement(name = "RecipientState")
    protected int recipientState;
    @XmlElement(name = "RecipientCurrentPageCount")
    protected int recipientCurrentPageCount;
    @XmlElement(name = "RecipientTotalPageCount")
    protected int recipientTotalPageCount;
    @XmlElement(name = "FaxDeliveryDateTime", required = true)
    protected String faxDeliveryDateTime;
    @XmlElement(name = "FaxDeliveryDuration")
    protected int faxDeliveryDuration;
    @XmlElement(name = "RemoteFaxCSID", required = true)
    protected String remoteFaxCSID;
    @XmlElement(name = "ReferenceId", required = true)
    protected String referenceId;
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
     * Gets the value of the recipientState property.
     * 
     */
    public int getRecipientState() {
        return recipientState;
    }

    /**
     * Sets the value of the recipientState property.
     * 
     */
    public void setRecipientState(int value) {
        this.recipientState = value;
    }

    /**
     * Gets the value of the recipientCurrentPageCount property.
     * 
     */
    public int getRecipientCurrentPageCount() {
        return recipientCurrentPageCount;
    }

    /**
     * Sets the value of the recipientCurrentPageCount property.
     * 
     */
    public void setRecipientCurrentPageCount(int value) {
        this.recipientCurrentPageCount = value;
    }

    /**
     * Gets the value of the recipientTotalPageCount property.
     * 
     */
    public int getRecipientTotalPageCount() {
        return recipientTotalPageCount;
    }

    /**
     * Sets the value of the recipientTotalPageCount property.
     * 
     */
    public void setRecipientTotalPageCount(int value) {
        this.recipientTotalPageCount = value;
    }

    /**
     * Gets the value of the faxDeliveryDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxDeliveryDateTime() {
        return faxDeliveryDateTime;
    }

    /**
     * Sets the value of the faxDeliveryDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxDeliveryDateTime(String value) {
        this.faxDeliveryDateTime = value;
    }

    /**
     * Gets the value of the faxDeliveryDuration property.
     * 
     */
    public int getFaxDeliveryDuration() {
        return faxDeliveryDuration;
    }

    /**
     * Sets the value of the faxDeliveryDuration property.
     * 
     */
    public void setFaxDeliveryDuration(int value) {
        this.faxDeliveryDuration = value;
    }

    /**
     * Gets the value of the remoteFaxCSID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteFaxCSID() {
        return remoteFaxCSID;
    }

    /**
     * Sets the value of the remoteFaxCSID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteFaxCSID(String value) {
        this.remoteFaxCSID = value;
    }

    /**
     * Gets the value of the referenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Sets the value of the referenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceId(String value) {
        this.referenceId = value;
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
