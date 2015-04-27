package com.wix.restaurants.fax.interfax.sl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @see https://ws-sl.fax.tc/Outbound.asmx?op=QueryList
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "interfax.net", name = "QueryResult")
public class QueryResult {
    @XmlElement
    public Integer ResultCode;

    @XmlElement
    public FaxItems FaxItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryResult that = (QueryResult) o;

        if (ResultCode != null ? !ResultCode.equals(that.ResultCode) : that.ResultCode != null) return false;
        return !(FaxItems != null ? !FaxItems.equals(that.FaxItems) : that.FaxItems != null);

    }

    @Override
    public int hashCode() {
        int result = ResultCode != null ? ResultCode.hashCode() : 0;
        result = 31 * result + (FaxItems != null ? FaxItems.hashCode() : 0);
        return result;
    }
}
