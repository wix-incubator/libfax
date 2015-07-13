
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaxBroadcastStatusRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaxBroadcastStatusRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JobId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartRecipientId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EndRecipientId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RecipientStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaxBroadcastStatusRequest", propOrder = {
    "jobId",
    "startRecipientId",
    "endRecipientId",
    "recipientStatus"
})
public class FaxBroadcastStatusRequest {

    @XmlElement(name = "JobId", required = true)
    protected String jobId;
    @XmlElement(name = "StartRecipientId", defaultValue = "-1")
    protected int startRecipientId;
    @XmlElement(name = "EndRecipientId", defaultValue = "-1")
    protected int endRecipientId;
    @XmlElement(name = "RecipientStatus", defaultValue = "-1")
    protected int recipientStatus;

    /**
     * Gets the value of the jobId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * Sets the value of the jobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobId(String value) {
        this.jobId = value;
    }

    /**
     * Gets the value of the startRecipientId property.
     * 
     */
    public int getStartRecipientId() {
        return startRecipientId;
    }

    /**
     * Sets the value of the startRecipientId property.
     * 
     */
    public void setStartRecipientId(int value) {
        this.startRecipientId = value;
    }

    /**
     * Gets the value of the endRecipientId property.
     * 
     */
    public int getEndRecipientId() {
        return endRecipientId;
    }

    /**
     * Sets the value of the endRecipientId property.
     * 
     */
    public void setEndRecipientId(int value) {
        this.endRecipientId = value;
    }

    /**
     * Gets the value of the recipientStatus property.
     * 
     */
    public int getRecipientStatus() {
        return recipientStatus;
    }

    /**
     * Sets the value of the recipientStatus property.
     * 
     */
    public void setRecipientStatus(int value) {
        this.recipientStatus = value;
    }

}
