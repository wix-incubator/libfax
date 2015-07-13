
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PortNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="did" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DefaultCSID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SendDeliveryConfirmation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ProcessInbound" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LineSpecificCredentials" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DID", propOrder = {
    "portNumber",
    "did",
    "defaultCSID",
    "sendDeliveryConfirmation",
    "processInbound",
    "lineSpecificCredentials"
})
public class DID {

    @XmlElement(name = "PortNumber")
    protected Integer portNumber;
    @XmlElement(required = true)
    protected String did;
    @XmlElement(name = "DefaultCSID", required = true)
    protected String defaultCSID;
    @XmlElement(name = "SendDeliveryConfirmation")
    protected int sendDeliveryConfirmation;
    @XmlElement(name = "ProcessInbound")
    protected boolean processInbound;
    @XmlElement(name = "LineSpecificCredentials", required = true)
    protected String lineSpecificCredentials;

    /**
     * Gets the value of the portNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPortNumber() {
        return portNumber;
    }

    /**
     * Sets the value of the portNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPortNumber(Integer value) {
        this.portNumber = value;
    }

    /**
     * Gets the value of the did property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDid() {
        return did;
    }

    /**
     * Sets the value of the did property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDid(String value) {
        this.did = value;
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
     * Gets the value of the processInbound property.
     * 
     */
    public boolean isProcessInbound() {
        return processInbound;
    }

    /**
     * Sets the value of the processInbound property.
     * 
     */
    public void setProcessInbound(boolean value) {
        this.processInbound = value;
    }

    /**
     * Gets the value of the lineSpecificCredentials property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineSpecificCredentials() {
        return lineSpecificCredentials;
    }

    /**
     * Sets the value of the lineSpecificCredentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineSpecificCredentials(String value) {
        this.lineSpecificCredentials = value;
    }

}
