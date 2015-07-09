package com.wix.fax.interfax.sl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @see <a href="https://ws-sl.fax.tc/Outbound.asmx?op=QueryList">QueryList</a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FaxItems {
    @XmlElement(namespace = "interfax.net")
    public List<FaxItemEx> FaxItem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FaxItems faxItems = (FaxItems) o;

        return !(FaxItem != null ? !FaxItem.equals(faxItems.FaxItem) : faxItems.FaxItem != null);

    }

    @Override
    public int hashCode() {
        return FaxItem != null ? FaxItem.hashCode() : 0;
    }
}