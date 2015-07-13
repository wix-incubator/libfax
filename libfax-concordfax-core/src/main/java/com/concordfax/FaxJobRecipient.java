
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaxJobRecipient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaxJobRecipient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecipFaxNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipCompany" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipSecureCSID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipZipcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipVoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecipField12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaxJobRecipient", propOrder = {
    "recipFaxNumber",
    "recipCompany",
    "recipTitle",
    "recipName",
    "recipSecureCSID",
    "recipFirstName",
    "recipLastName",
    "recipAddress1",
    "recipAddress2",
    "recipCity",
    "recipState",
    "recipZipcode",
    "recipCountry",
    "recipVoiceNumber",
    "recipField1",
    "recipField2",
    "recipField3",
    "recipField4",
    "recipField5",
    "recipField6",
    "recipField7",
    "recipField8",
    "recipField9",
    "recipField10",
    "recipField11",
    "recipField12"
})
public class FaxJobRecipient {

    @XmlElement(name = "RecipFaxNumber", required = true)
    protected String recipFaxNumber;
    @XmlElement(name = "RecipCompany", required = true)
    protected String recipCompany;
    @XmlElement(name = "RecipTitle", required = true)
    protected String recipTitle;
    @XmlElement(name = "RecipName", required = true)
    protected String recipName;
    @XmlElement(name = "RecipSecureCSID", required = true)
    protected String recipSecureCSID;
    @XmlElement(name = "RecipFirstName")
    protected String recipFirstName;
    @XmlElement(name = "RecipLastName")
    protected String recipLastName;
    @XmlElement(name = "RecipAddress1")
    protected String recipAddress1;
    @XmlElement(name = "RecipAddress2")
    protected String recipAddress2;
    @XmlElement(name = "RecipCity")
    protected String recipCity;
    @XmlElement(name = "RecipState")
    protected String recipState;
    @XmlElement(name = "RecipZipcode")
    protected String recipZipcode;
    @XmlElement(name = "RecipCountry")
    protected String recipCountry;
    @XmlElement(name = "RecipVoiceNumber")
    protected String recipVoiceNumber;
    @XmlElement(name = "RecipField1")
    protected String recipField1;
    @XmlElement(name = "RecipField2")
    protected String recipField2;
    @XmlElement(name = "RecipField3")
    protected String recipField3;
    @XmlElement(name = "RecipField4")
    protected String recipField4;
    @XmlElement(name = "RecipField5")
    protected String recipField5;
    @XmlElement(name = "RecipField6")
    protected String recipField6;
    @XmlElement(name = "RecipField7")
    protected String recipField7;
    @XmlElement(name = "RecipField8")
    protected String recipField8;
    @XmlElement(name = "RecipField9")
    protected String recipField9;
    @XmlElement(name = "RecipField10")
    protected String recipField10;
    @XmlElement(name = "RecipField11")
    protected String recipField11;
    @XmlElement(name = "RecipField12")
    protected String recipField12;

    /**
     * Gets the value of the recipFaxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipFaxNumber() {
        return recipFaxNumber;
    }

    /**
     * Sets the value of the recipFaxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipFaxNumber(String value) {
        this.recipFaxNumber = value;
    }

    /**
     * Gets the value of the recipCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipCompany() {
        return recipCompany;
    }

    /**
     * Sets the value of the recipCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipCompany(String value) {
        this.recipCompany = value;
    }

    /**
     * Gets the value of the recipTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipTitle() {
        return recipTitle;
    }

    /**
     * Sets the value of the recipTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipTitle(String value) {
        this.recipTitle = value;
    }

    /**
     * Gets the value of the recipName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipName() {
        return recipName;
    }

    /**
     * Sets the value of the recipName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipName(String value) {
        this.recipName = value;
    }

    /**
     * Gets the value of the recipSecureCSID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipSecureCSID() {
        return recipSecureCSID;
    }

    /**
     * Sets the value of the recipSecureCSID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipSecureCSID(String value) {
        this.recipSecureCSID = value;
    }

    /**
     * Gets the value of the recipFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipFirstName() {
        return recipFirstName;
    }

    /**
     * Sets the value of the recipFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipFirstName(String value) {
        this.recipFirstName = value;
    }

    /**
     * Gets the value of the recipLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipLastName() {
        return recipLastName;
    }

    /**
     * Sets the value of the recipLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipLastName(String value) {
        this.recipLastName = value;
    }

    /**
     * Gets the value of the recipAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipAddress1() {
        return recipAddress1;
    }

    /**
     * Sets the value of the recipAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipAddress1(String value) {
        this.recipAddress1 = value;
    }

    /**
     * Gets the value of the recipAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipAddress2() {
        return recipAddress2;
    }

    /**
     * Sets the value of the recipAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipAddress2(String value) {
        this.recipAddress2 = value;
    }

    /**
     * Gets the value of the recipCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipCity() {
        return recipCity;
    }

    /**
     * Sets the value of the recipCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipCity(String value) {
        this.recipCity = value;
    }

    /**
     * Gets the value of the recipState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipState() {
        return recipState;
    }

    /**
     * Sets the value of the recipState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipState(String value) {
        this.recipState = value;
    }

    /**
     * Gets the value of the recipZipcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipZipcode() {
        return recipZipcode;
    }

    /**
     * Sets the value of the recipZipcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipZipcode(String value) {
        this.recipZipcode = value;
    }

    /**
     * Gets the value of the recipCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipCountry() {
        return recipCountry;
    }

    /**
     * Sets the value of the recipCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipCountry(String value) {
        this.recipCountry = value;
    }

    /**
     * Gets the value of the recipVoiceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipVoiceNumber() {
        return recipVoiceNumber;
    }

    /**
     * Sets the value of the recipVoiceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipVoiceNumber(String value) {
        this.recipVoiceNumber = value;
    }

    /**
     * Gets the value of the recipField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField1() {
        return recipField1;
    }

    /**
     * Sets the value of the recipField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField1(String value) {
        this.recipField1 = value;
    }

    /**
     * Gets the value of the recipField2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField2() {
        return recipField2;
    }

    /**
     * Sets the value of the recipField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField2(String value) {
        this.recipField2 = value;
    }

    /**
     * Gets the value of the recipField3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField3() {
        return recipField3;
    }

    /**
     * Sets the value of the recipField3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField3(String value) {
        this.recipField3 = value;
    }

    /**
     * Gets the value of the recipField4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField4() {
        return recipField4;
    }

    /**
     * Sets the value of the recipField4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField4(String value) {
        this.recipField4 = value;
    }

    /**
     * Gets the value of the recipField5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField5() {
        return recipField5;
    }

    /**
     * Sets the value of the recipField5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField5(String value) {
        this.recipField5 = value;
    }

    /**
     * Gets the value of the recipField6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField6() {
        return recipField6;
    }

    /**
     * Sets the value of the recipField6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField6(String value) {
        this.recipField6 = value;
    }

    /**
     * Gets the value of the recipField7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField7() {
        return recipField7;
    }

    /**
     * Sets the value of the recipField7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField7(String value) {
        this.recipField7 = value;
    }

    /**
     * Gets the value of the recipField8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField8() {
        return recipField8;
    }

    /**
     * Sets the value of the recipField8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField8(String value) {
        this.recipField8 = value;
    }

    /**
     * Gets the value of the recipField9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField9() {
        return recipField9;
    }

    /**
     * Sets the value of the recipField9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField9(String value) {
        this.recipField9 = value;
    }

    /**
     * Gets the value of the recipField10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField10() {
        return recipField10;
    }

    /**
     * Sets the value of the recipField10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField10(String value) {
        this.recipField10 = value;
    }

    /**
     * Gets the value of the recipField11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField11() {
        return recipField11;
    }

    /**
     * Sets the value of the recipField11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField11(String value) {
        this.recipField11 = value;
    }

    /**
     * Gets the value of the recipField12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipField12() {
        return recipField12;
    }

    /**
     * Sets the value of the recipField12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipField12(String value) {
        this.recipField12 = value;
    }

}
