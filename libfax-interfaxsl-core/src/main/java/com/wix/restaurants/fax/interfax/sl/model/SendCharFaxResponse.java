package com.wix.restaurants.fax.interfax.sl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @see https://ws-sl.fax.tc/Outbound.asmx?op=SendCharFax
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "interfax.net", name = "long")
public class SendCharFaxResponse {
    @XmlValue
    public Long value;
}