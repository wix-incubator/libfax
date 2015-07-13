
package com.concordfax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaxJobFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaxJobFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FileTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FileData" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaxJobFile", propOrder = {
    "fileIndex",
    "fileTypeId",
    "fileData"
})
public class FaxJobFile {

    @XmlElement(name = "FileIndex")
    protected int fileIndex;
    @XmlElement(name = "FileTypeId")
    protected int fileTypeId;
    @XmlElement(name = "FileData", required = true)
    protected byte[] fileData;

    /**
     * Gets the value of the fileIndex property.
     * 
     */
    public int getFileIndex() {
        return fileIndex;
    }

    /**
     * Sets the value of the fileIndex property.
     * 
     */
    public void setFileIndex(int value) {
        this.fileIndex = value;
    }

    /**
     * Gets the value of the fileTypeId property.
     * 
     */
    public int getFileTypeId() {
        return fileTypeId;
    }

    /**
     * Sets the value of the fileTypeId property.
     * 
     */
    public void setFileTypeId(int value) {
        this.fileTypeId = value;
    }

    /**
     * Gets the value of the fileData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileData() {
        return fileData;
    }

    /**
     * Sets the value of the fileData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileData(byte[] value) {
        this.fileData = value;
    }

}
