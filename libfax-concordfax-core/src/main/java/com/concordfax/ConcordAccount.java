
package com.concordfax;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConcordAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConcordAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultCSID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SendDeliveryConfirmation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DIDList" type="{urn:FaxWS}DIDList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConcordAccount", propOrder = {
    "userId",
    "pin",
    "defaultCSID",
    "sendDeliveryConfirmation",
    "didList"
})
public class ConcordAccount {

    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "Pin")
    protected String pin;
    @XmlElement(name = "DefaultCSID", required = true)
    protected String defaultCSID;
    @XmlElement(name = "SendDeliveryConfirmation")
    protected int sendDeliveryConfirmation;
    @XmlElementRef(name = "DIDList", namespace = "urn:FaxWS", type = JAXBElement.class, required = false)
    protected JAXBElement<DIDList> didList;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin(String value) {
        this.pin = value;
    }

    /**
     * Gets the value of the defaultCSID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultCSID() {
        return defaultCSID;
    }

    /**
     * Sets the value of the defaultCSID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultCSID(String value) {
        this.defaultCSID = value;
    }

    /**
     * Gets the value of the sendDeliveryConfirmation property.
     * 
     */
    public int getSendDeliveryConfirmation() {
        return sendDeliveryConfirmation;
    }

    /**
     * Sets the value of the sendDeliveryConfirmation property.
     * 
     */
    public void setSendDeliveryConfirmation(int value) {
        this.sendDeliveryConfirmation = value;
    }

    /**
     * Gets the value of the didList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DIDList }{@code >}
     *     
     */
    public JAXBElement<DIDList> getDIDList() {
        return didList;
    }

    /**
     * Sets the value of the didList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DIDList }{@code >}
     *     
     */
    public void setDIDList(JAXBElement<DIDList> value) {
        this.didList = value;
    }

}
