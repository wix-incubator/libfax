
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecipientStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecipientStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FaxJobId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RecipientStatusId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RecipientStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientCompanyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeliveryAttempts" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DeliveryDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DeliverySpeed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ReceiveCSID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PageCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FaxNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecipientStatus", propOrder = {
    "faxJobId",
    "recipientId",
    "recipientStatusId",
    "recipientStatusDescription",
    "recipientName",
    "recipientCompanyName",
    "deliveryAttempts",
    "deliveryDuration",
    "deliverySpeed",
    "receiveCSID",
    "pageCount",
    "faxNumber",
    "startDate",
    "endDate"
})
public class RecipientStatus {

    @XmlElement(name = "FaxJobId", required = true)
    protected String faxJobId;
    @XmlElement(name = "RecipientId")
    protected int recipientId;
    @XmlElement(name = "RecipientStatusId")
    protected int recipientStatusId;
    @XmlElement(name = "RecipientStatusDescription", required = true)
    protected String recipientStatusDescription;
    @XmlElement(name = "RecipientName", required = true)
    protected String recipientName;
    @XmlElement(name = "RecipientCompanyName", required = true)
    protected String recipientCompanyName;
    @XmlElement(name = "DeliveryAttempts")
    protected int deliveryAttempts;
    @XmlElement(name = "DeliveryDuration")
    protected int deliveryDuration;
    @XmlElement(name = "DeliverySpeed")
    protected int deliverySpeed;
    @XmlElement(name = "ReceiveCSID", required = true)
    protected String receiveCSID;
    @XmlElement(name = "PageCount")
    protected int pageCount;
    @XmlElement(name = "FaxNumber", required = true)
    protected String faxNumber;
    @XmlElement(name = "StartDate", required = true)
    protected String startDate;
    @XmlElement(name = "EndDate", required = true)
    protected String endDate;

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
     * Gets the value of the recipientId property.
     * 
     */
    public int getRecipientId() {
        return recipientId;
    }

    /**
     * Sets the value of the recipientId property.
     * 
     */
    public void setRecipientId(int value) {
        this.recipientId = value;
    }

    /**
     * Gets the value of the recipientStatusId property.
     * 
     */
    public int getRecipientStatusId() {
        return recipientStatusId;
    }

    /**
     * Sets the value of the recipientStatusId property.
     * 
     */
    public void setRecipientStatusId(int value) {
        this.recipientStatusId = value;
    }

    /**
     * Gets the value of the recipientStatusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientStatusDescription() {
        return recipientStatusDescription;
    }

    /**
     * Sets the value of the recipientStatusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientStatusDescription(String value) {
        this.recipientStatusDescription = value;
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
     * Gets the value of the recipientCompanyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientCompanyName() {
        return recipientCompanyName;
    }

    /**
     * Sets the value of the recipientCompanyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientCompanyName(String value) {
        this.recipientCompanyName = value;
    }

    /**
     * Gets the value of the deliveryAttempts property.
     * 
     */
    public int getDeliveryAttempts() {
        return deliveryAttempts;
    }

    /**
     * Sets the value of the deliveryAttempts property.
     * 
     */
    public void setDeliveryAttempts(int value) {
        this.deliveryAttempts = value;
    }

    /**
     * Gets the value of the deliveryDuration property.
     * 
     */
    public int getDeliveryDuration() {
        return deliveryDuration;
    }

    /**
     * Sets the value of the deliveryDuration property.
     * 
     */
    public void setDeliveryDuration(int value) {
        this.deliveryDuration = value;
    }

    /**
     * Gets the value of the deliverySpeed property.
     * 
     */
    public int getDeliverySpeed() {
        return deliverySpeed;
    }

    /**
     * Sets the value of the deliverySpeed property.
     * 
     */
    public void setDeliverySpeed(int value) {
        this.deliverySpeed = value;
    }

    /**
     * Gets the value of the receiveCSID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiveCSID() {
        return receiveCSID;
    }

    /**
     * Sets the value of the receiveCSID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiveCSID(String value) {
        this.receiveCSID = value;
    }

    /**
     * Gets the value of the pageCount property.
     * 
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets the value of the pageCount property.
     * 
     */
    public void setPageCount(int value) {
        this.pageCount = value;
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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

}
