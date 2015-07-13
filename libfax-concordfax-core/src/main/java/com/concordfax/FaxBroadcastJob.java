
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaxBroadcastJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaxBroadcastJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JobScheduleStartType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="JobScheduleStartDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JobExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderCSID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderCompany" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderAddress1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderAddress2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderZip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CoverName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CoverSubject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExceptionDestination" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SenderFax" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SoftwareClient" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CoverText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserField6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserField12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaxBroadcastJob", propOrder = {
    "jobScheduleStartType",
    "jobScheduleStartDate",
    "jobExpiryDate",
    "senderCSID",
    "senderName",
    "senderCompany",
    "senderPhone",
    "senderAddress1",
    "senderAddress2",
    "senderCity",
    "senderState",
    "senderZip",
    "senderCountry",
    "coverName",
    "coverSubject",
    "resolution",
    "userField1",
    "userField2",
    "userField3",
    "userField4",
    "userField5",
    "exceptionDestination",
    "senderFax",
    "softwareClient",
    "coverText",
    "userField6",
    "userField7",
    "userField8",
    "userField9",
    "userField10",
    "userField11",
    "userField12"
})
public class FaxBroadcastJob {

    @XmlElement(name = "JobScheduleStartType")
    protected int jobScheduleStartType;
    @XmlElement(name = "JobScheduleStartDate", required = true)
    protected String jobScheduleStartDate;
    @XmlElement(name = "JobExpiryDate", required = true)
    protected String jobExpiryDate;
    @XmlElement(name = "SenderCSID", required = true)
    protected String senderCSID;
    @XmlElement(name = "SenderName", required = true)
    protected String senderName;
    @XmlElement(name = "SenderCompany", required = true)
    protected String senderCompany;
    @XmlElement(name = "SenderPhone", required = true)
    protected String senderPhone;
    @XmlElement(name = "SenderAddress1", required = true)
    protected String senderAddress1;
    @XmlElement(name = "SenderAddress2", required = true)
    protected String senderAddress2;
    @XmlElement(name = "SenderCity", required = true)
    protected String senderCity;
    @XmlElement(name = "SenderState", required = true)
    protected String senderState;
    @XmlElement(name = "SenderZip", required = true)
    protected String senderZip;
    @XmlElement(name = "SenderCountry", required = true)
    protected String senderCountry;
    @XmlElement(name = "CoverName", required = true)
    protected String coverName;
    @XmlElement(name = "CoverSubject", required = true)
    protected String coverSubject;
    @XmlElement(name = "Resolution", required = true)
    protected String resolution;
    @XmlElement(name = "UserField1")
    protected String userField1;
    @XmlElement(name = "UserField2")
    protected String userField2;
    @XmlElement(name = "UserField3")
    protected String userField3;
    @XmlElement(name = "UserField4")
    protected String userField4;
    @XmlElement(name = "UserField5")
    protected String userField5;
    @XmlElement(name = "ExceptionDestination", required = true)
    protected String exceptionDestination;
    @XmlElement(name = "SenderFax", required = true)
    protected String senderFax;
    @XmlElement(name = "SoftwareClient", required = true)
    protected String softwareClient;
    @XmlElement(name = "CoverText", required = true)
    protected String coverText;
    @XmlElement(name = "UserField6")
    protected String userField6;
    @XmlElement(name = "UserField7")
    protected String userField7;
    @XmlElement(name = "UserField8")
    protected String userField8;
    @XmlElement(name = "UserField9")
    protected String userField9;
    @XmlElement(name = "UserField10")
    protected String userField10;
    @XmlElement(name = "UserField11")
    protected String userField11;
    @XmlElement(name = "UserField12")
    protected String userField12;

    /**
     * Gets the value of the jobScheduleStartType property.
     * 
     */
    public int getJobScheduleStartType() {
        return jobScheduleStartType;
    }

    /**
     * Sets the value of the jobScheduleStartType property.
     * 
     */
    public void setJobScheduleStartType(int value) {
        this.jobScheduleStartType = value;
    }

    /**
     * Gets the value of the jobScheduleStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobScheduleStartDate() {
        return jobScheduleStartDate;
    }

    /**
     * Sets the value of the jobScheduleStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobScheduleStartDate(String value) {
        this.jobScheduleStartDate = value;
    }

    /**
     * Gets the value of the jobExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobExpiryDate() {
        return jobExpiryDate;
    }

    /**
     * Sets the value of the jobExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobExpiryDate(String value) {
        this.jobExpiryDate = value;
    }

    /**
     * Gets the value of the senderCSID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderCSID() {
        return senderCSID;
    }

    /**
     * Sets the value of the senderCSID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderCSID(String value) {
        this.senderCSID = value;
    }

    /**
     * Gets the value of the senderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Sets the value of the senderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderName(String value) {
        this.senderName = value;
    }

    /**
     * Gets the value of the senderCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderCompany() {
        return senderCompany;
    }

    /**
     * Sets the value of the senderCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderCompany(String value) {
        this.senderCompany = value;
    }

    /**
     * Gets the value of the senderPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderPhone() {
        return senderPhone;
    }

    /**
     * Sets the value of the senderPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderPhone(String value) {
        this.senderPhone = value;
    }

    /**
     * Gets the value of the senderAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderAddress1() {
        return senderAddress1;
    }

    /**
     * Sets the value of the senderAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderAddress1(String value) {
        this.senderAddress1 = value;
    }

    /**
     * Gets the value of the senderAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderAddress2() {
        return senderAddress2;
    }

    /**
     * Sets the value of the senderAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderAddress2(String value) {
        this.senderAddress2 = value;
    }

    /**
     * Gets the value of the senderCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderCity() {
        return senderCity;
    }

    /**
     * Sets the value of the senderCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderCity(String value) {
        this.senderCity = value;
    }

    /**
     * Gets the value of the senderState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderState() {
        return senderState;
    }

    /**
     * Sets the value of the senderState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderState(String value) {
        this.senderState = value;
    }

    /**
     * Gets the value of the senderZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderZip() {
        return senderZip;
    }

    /**
     * Sets the value of the senderZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderZip(String value) {
        this.senderZip = value;
    }

    /**
     * Gets the value of the senderCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderCountry() {
        return senderCountry;
    }

    /**
     * Sets the value of the senderCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderCountry(String value) {
        this.senderCountry = value;
    }

    /**
     * Gets the value of the coverName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverName() {
        return coverName;
    }

    /**
     * Sets the value of the coverName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverName(String value) {
        this.coverName = value;
    }

    /**
     * Gets the value of the coverSubject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverSubject() {
        return coverSubject;
    }

    /**
     * Sets the value of the coverSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverSubject(String value) {
        this.coverSubject = value;
    }

    /**
     * Gets the value of the resolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolution(String value) {
        this.resolution = value;
    }

    /**
     * Gets the value of the userField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField1() {
        return userField1;
    }

    /**
     * Sets the value of the userField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField1(String value) {
        this.userField1 = value;
    }

    /**
     * Gets the value of the userField2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField2() {
        return userField2;
    }

    /**
     * Sets the value of the userField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField2(String value) {
        this.userField2 = value;
    }

    /**
     * Gets the value of the userField3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField3() {
        return userField3;
    }

    /**
     * Sets the value of the userField3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField3(String value) {
        this.userField3 = value;
    }

    /**
     * Gets the value of the userField4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField4() {
        return userField4;
    }

    /**
     * Sets the value of the userField4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField4(String value) {
        this.userField4 = value;
    }

    /**
     * Gets the value of the userField5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField5() {
        return userField5;
    }

    /**
     * Sets the value of the userField5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField5(String value) {
        this.userField5 = value;
    }

    /**
     * Gets the value of the exceptionDestination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionDestination() {
        return exceptionDestination;
    }

    /**
     * Sets the value of the exceptionDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionDestination(String value) {
        this.exceptionDestination = value;
    }

    /**
     * Gets the value of the senderFax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderFax() {
        return senderFax;
    }

    /**
     * Sets the value of the senderFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderFax(String value) {
        this.senderFax = value;
    }

    /**
     * Gets the value of the softwareClient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwareClient() {
        return softwareClient;
    }

    /**
     * Sets the value of the softwareClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwareClient(String value) {
        this.softwareClient = value;
    }

    /**
     * Gets the value of the coverText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverText() {
        return coverText;
    }

    /**
     * Sets the value of the coverText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverText(String value) {
        this.coverText = value;
    }

    /**
     * Gets the value of the userField6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField6() {
        return userField6;
    }

    /**
     * Sets the value of the userField6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField6(String value) {
        this.userField6 = value;
    }

    /**
     * Gets the value of the userField7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField7() {
        return userField7;
    }

    /**
     * Sets the value of the userField7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField7(String value) {
        this.userField7 = value;
    }

    /**
     * Gets the value of the userField8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField8() {
        return userField8;
    }

    /**
     * Sets the value of the userField8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField8(String value) {
        this.userField8 = value;
    }

    /**
     * Gets the value of the userField9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField9() {
        return userField9;
    }

    /**
     * Sets the value of the userField9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField9(String value) {
        this.userField9 = value;
    }

    /**
     * Gets the value of the userField10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField10() {
        return userField10;
    }

    /**
     * Sets the value of the userField10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField10(String value) {
        this.userField10 = value;
    }

    /**
     * Gets the value of the userField11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField11() {
        return userField11;
    }

    /**
     * Sets the value of the userField11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField11(String value) {
        this.userField11 = value;
    }

    /**
     * Gets the value of the userField12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserField12() {
        return userField12;
    }

    /**
     * Sets the value of the userField12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserField12(String value) {
        this.userField12 = value;
    }

}
