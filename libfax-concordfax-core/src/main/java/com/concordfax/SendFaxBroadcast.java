
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
 *         &lt;element name="Recipients" type="{urn:FaxWS}FaxJobRecipients"/>
 *         &lt;element name="FaxJobFiles" type="{urn:FaxWS}FaxJobFiles"/>
 *         &lt;element name="JobDetails" type="{urn:FaxWS}FaxBroadcastJob"/>
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
    "recipients",
    "faxJobFiles",
    "jobDetails"
})
@XmlRootElement(name = "SendFaxBroadcast")
public class SendFaxBroadcast {

    @XmlElement(name = "UserID", required = true)
    protected String userID;
    @XmlElement(required = true)
    protected String strPIN;
    @XmlElement(name = "Recipients", required = true)
    protected FaxJobRecipients recipients;
    @XmlElement(name = "FaxJobFiles", required = true)
    protected FaxJobFiles faxJobFiles;
    @XmlElement(name = "JobDetails", required = true)
    protected FaxBroadcastJob jobDetails;

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
     * Gets the value of the recipients property.
     * 
     * @return
     *     possible object is
     *     {@link FaxJobRecipients }
     *     
     */
    public FaxJobRecipients getRecipients() {
        return recipients;
    }

    /**
     * Sets the value of the recipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaxJobRecipients }
     *     
     */
    public void setRecipients(FaxJobRecipients value) {
        this.recipients = value;
    }

    /**
     * Gets the value of the faxJobFiles property.
     * 
     * @return
     *     possible object is
     *     {@link FaxJobFiles }
     *     
     */
    public FaxJobFiles getFaxJobFiles() {
        return faxJobFiles;
    }

    /**
     * Sets the value of the faxJobFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaxJobFiles }
     *     
     */
    public void setFaxJobFiles(FaxJobFiles value) {
        this.faxJobFiles = value;
    }

    /**
     * Gets the value of the jobDetails property.
     * 
     * @return
     *     possible object is
     *     {@link FaxBroadcastJob }
     *     
     */
    public FaxBroadcastJob getJobDetails() {
        return jobDetails;
    }

    /**
     * Sets the value of the jobDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaxBroadcastJob }
     *     
     */
    public void setJobDetails(FaxBroadcastJob value) {
        this.jobDetails = value;
    }

}
