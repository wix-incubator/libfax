
package com.concordfax;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RecipientStatusList" type="{urn:FaxWS}RecipientStatusList" minOccurs="0"/>
 *         &lt;element name="WSError" type="{urn:FaxWS}WSError"/>
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
    "_return",
    "recipientStatusList",
    "wsError"
})
@XmlRootElement(name = "FaxBroadcastStatusResponse")
public class FaxBroadcastStatusResponse {

    @XmlElement(name = "return")
    protected boolean _return;
    @XmlElementRef(name = "RecipientStatusList", namespace = "urn:FaxWS", type = JAXBElement.class, required = false)
    protected JAXBElement<RecipientStatusList> recipientStatusList;
    @XmlElement(name = "WSError", required = true)
    protected WSError wsError;

    /**
     * Gets the value of the return property.
     * 
     */
    public boolean isReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     */
    public void setReturn(boolean value) {
        this._return = value;
    }

    /**
     * Gets the value of the recipientStatusList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RecipientStatusList }{@code >}
     *     
     */
    public JAXBElement<RecipientStatusList> getRecipientStatusList() {
        return recipientStatusList;
    }

    /**
     * Sets the value of the recipientStatusList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RecipientStatusList }{@code >}
     *     
     */
    public void setRecipientStatusList(JAXBElement<RecipientStatusList> value) {
        this.recipientStatusList = value;
    }

    /**
     * Gets the value of the wsError property.
     * 
     * @return
     *     possible object is
     *     {@link WSError }
     *     
     */
    public WSError getWSError() {
        return wsError;
    }

    /**
     * Sets the value of the wsError property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSError }
     *     
     */
    public void setWSError(WSError value) {
        this.wsError = value;
    }

}
