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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendCharFaxResponse that = (SendCharFaxResponse) o;

        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}