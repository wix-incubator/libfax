
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
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FaxCoverList" type="{urn:FaxWS}FaxCoverList"/>
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
    "faxCoverList",
    "wsError"
})
@XmlRootElement(name = "FaxCoverResponse")
public class FaxCoverResponse {

    @XmlElement(name = "return")
    protected boolean _return;
    @XmlElement(name = "FaxCoverList", required = true)
    protected FaxCoverList faxCoverList;
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
     * Gets the value of the faxCoverList property.
     * 
     * @return
     *     possible object is
     *     {@link FaxCoverList }
     *     
     */
    public FaxCoverList getFaxCoverList() {
        return faxCoverList;
    }

    /**
     * Sets the value of the faxCoverList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaxCoverList }
     *     
     */
    public void setFaxCoverList(FaxCoverList value) {
        this.faxCoverList = value;
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
