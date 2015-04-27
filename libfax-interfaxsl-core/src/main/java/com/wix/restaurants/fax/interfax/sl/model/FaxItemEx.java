package com.wix.restaurants.fax.interfax.sl.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * @see http://www.interfax.net/en/dev/secure_lounge/reference/soap/sending/querylist
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "interfax.net", name = "FaxItem")
public class FaxItemEx {
    @XmlElement
    public Long TransactionID;

    /** Time when the transaction was originally submitted by the client. */
    @XmlElement
    public String SubmitTime;

    /** End time of last of all transmission attempts. */
    @XmlElement
    public String CompletionTime;

    @XmlElement
    public String UserID;

    /** The text which was inserted into the Contacts property upon submission of the fax (available in select submission methods only). */
    @XmlElement
    public String Contact;

    /**
     * The fax number in a canonical format
     * @see http://www.interfax.net/en/dev/secure_lounge/reference/soap/special_formats
     */
    @XmlElement
    public String DestinationFax;

    /** Receiving party CSID (up to 20 characters). */
    @XmlElement
    public String RemoteCSID;

    /** Number of successfully sent pages. */
    @XmlElement
    public Short PagesSent;

    @XmlElement
    public Integer Status;

    /** Transmission time in seconds. */
    @XmlElement
    public Integer Duration;

    /** Original value as submitted. */
    @XmlElement
    public String Subject;

    /** Number of pages originally submitted. */
    @XmlElement
    public Short PagesSubmitted;

    /** CSID of calling party. */
    @XmlElement
    public String SenderCSID;

    /** Priority assigned to the fax. */
    @XmlElement
    public Short Priority;

    /** Number of units to be billed (pages or tenths of minutes). */
    @XmlElement
    public BigDecimal Units;

    /** Monetary units, in account currency. Multiply this by 'Units' to get the cost of the fax. */
    @XmlElement
    public BigDecimal CostPerUnit;

    /** @see PageSize */
    @XmlElement
    public String PageSize;

    /** @see PageOrientation */
    @XmlElement
    public String PageOrientation;

    /** @see PageResolution */
    @XmlElement
    public String PageResolution;

    /** @see RenderingQuality */
    @XmlElement
    public String RenderingQuality;

    /** Header overlaid on fax. */
    @XmlElement
    public String PageHeader;

    /** Retry attempts requested. */
    @XmlElement
    public Short RetriesToPerform;

    /** Retry attempts actually performed. */
    @XmlElement
    public Short TrialsPerformed;

    /** For internal use. */
    @XmlElement
    public Integer LocaleID;

    /** For internal use. */
    @XmlElement
    public Integer GMTBias;

    /** Interval in minutes between retries. */
    @XmlElement
    public Integer RetriesInterval;

    /** Reserved for future use. */
    @XmlElement
    public String UserData;

    /**
     * Was the fax sent with 'delete image after usage' set?
     * @see Boolean
     */
    @XmlElement
    public String DeleteAfterUsage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FaxItemEx faxItemEx = (FaxItemEx) o;

        if (TransactionID != null ? !TransactionID.equals(faxItemEx.TransactionID) : faxItemEx.TransactionID != null) return false;
        if (SubmitTime != null ? !SubmitTime.equals(faxItemEx.SubmitTime) : faxItemEx.SubmitTime != null) return false;
        if (CompletionTime != null ? !CompletionTime.equals(faxItemEx.CompletionTime) : faxItemEx.CompletionTime != null) return false;
        if (UserID != null ? !UserID.equals(faxItemEx.UserID) : faxItemEx.UserID != null) return false;
        if (Contact != null ? !Contact.equals(faxItemEx.Contact) : faxItemEx.Contact != null) return false;
        if (DestinationFax != null ? !DestinationFax.equals(faxItemEx.DestinationFax) : faxItemEx.DestinationFax != null) return false;
        if (RemoteCSID != null ? !RemoteCSID.equals(faxItemEx.RemoteCSID) : faxItemEx.RemoteCSID != null) return false;
        if (PagesSent != null ? !PagesSent.equals(faxItemEx.PagesSent) : faxItemEx.PagesSent != null) return false;
        if (Status != null ? !Status.equals(faxItemEx.Status) : faxItemEx.Status != null) return false;
        if (Duration != null ? !Duration.equals(faxItemEx.Duration) : faxItemEx.Duration != null) return false;
        if (Subject != null ? !Subject.equals(faxItemEx.Subject) : faxItemEx.Subject != null) return false;
        if (PagesSubmitted != null ? !PagesSubmitted.equals(faxItemEx.PagesSubmitted) : faxItemEx.PagesSubmitted != null) return false;
        if (SenderCSID != null ? !SenderCSID.equals(faxItemEx.SenderCSID) : faxItemEx.SenderCSID != null) return false;
        if (Priority != null ? !Priority.equals(faxItemEx.Priority) : faxItemEx.Priority != null) return false;
        if (Units != null ? !Units.equals(faxItemEx.Units) : faxItemEx.Units != null) return false;
        if (CostPerUnit != null ? !CostPerUnit.equals(faxItemEx.CostPerUnit) : faxItemEx.CostPerUnit != null) return false;
        if (PageSize != null ? !PageSize.equals(faxItemEx.PageSize) : faxItemEx.PageSize != null) return false;
        if (PageOrientation != null ? !PageOrientation.equals(faxItemEx.PageOrientation) : faxItemEx.PageOrientation != null) return false;
        if (PageResolution != null ? !PageResolution.equals(faxItemEx.PageResolution) : faxItemEx.PageResolution != null) return false;
        if (RenderingQuality != null ? !RenderingQuality.equals(faxItemEx.RenderingQuality) : faxItemEx.RenderingQuality != null) return false;
        if (PageHeader != null ? !PageHeader.equals(faxItemEx.PageHeader) : faxItemEx.PageHeader != null) return false;
        if (RetriesToPerform != null ? !RetriesToPerform.equals(faxItemEx.RetriesToPerform) : faxItemEx.RetriesToPerform != null) return false;
        if (TrialsPerformed != null ? !TrialsPerformed.equals(faxItemEx.TrialsPerformed) : faxItemEx.TrialsPerformed != null) return false;
        if (LocaleID != null ? !LocaleID.equals(faxItemEx.LocaleID) : faxItemEx.LocaleID != null) return false;
        if (GMTBias != null ? !GMTBias.equals(faxItemEx.GMTBias) : faxItemEx.GMTBias != null) return false;
        if (RetriesInterval != null ? !RetriesInterval.equals(faxItemEx.RetriesInterval) : faxItemEx.RetriesInterval != null) return false;
        if (UserData != null ? !UserData.equals(faxItemEx.UserData) : faxItemEx.UserData != null) return false;
        return !(DeleteAfterUsage != null ? !DeleteAfterUsage.equals(faxItemEx.DeleteAfterUsage) : faxItemEx.DeleteAfterUsage != null);

    }

    @Override
    public int hashCode() {
        int result = TransactionID != null ? TransactionID.hashCode() : 0;
        result = 31 * result + (SubmitTime != null ? SubmitTime.hashCode() : 0);
        result = 31 * result + (CompletionTime != null ? CompletionTime.hashCode() : 0);
        result = 31 * result + (UserID != null ? UserID.hashCode() : 0);
        result = 31 * result + (Contact != null ? Contact.hashCode() : 0);
        result = 31 * result + (DestinationFax != null ? DestinationFax.hashCode() : 0);
        result = 31 * result + (RemoteCSID != null ? RemoteCSID.hashCode() : 0);
        result = 31 * result + (PagesSent != null ? PagesSent.hashCode() : 0);
        result = 31 * result + (Status != null ? Status.hashCode() : 0);
        result = 31 * result + (Duration != null ? Duration.hashCode() : 0);
        result = 31 * result + (Subject != null ? Subject.hashCode() : 0);
        result = 31 * result + (PagesSubmitted != null ? PagesSubmitted.hashCode() : 0);
        result = 31 * result + (SenderCSID != null ? SenderCSID.hashCode() : 0);
        result = 31 * result + (Priority != null ? Priority.hashCode() : 0);
        result = 31 * result + (Units != null ? Units.hashCode() : 0);
        result = 31 * result + (CostPerUnit != null ? CostPerUnit.hashCode() : 0);
        result = 31 * result + (PageSize != null ? PageSize.hashCode() : 0);
        result = 31 * result + (PageOrientation != null ? PageOrientation.hashCode() : 0);
        result = 31 * result + (PageResolution != null ? PageResolution.hashCode() : 0);
        result = 31 * result + (RenderingQuality != null ? RenderingQuality.hashCode() : 0);
        result = 31 * result + (PageHeader != null ? PageHeader.hashCode() : 0);
        result = 31 * result + (RetriesToPerform != null ? RetriesToPerform.hashCode() : 0);
        result = 31 * result + (TrialsPerformed != null ? TrialsPerformed.hashCode() : 0);
        result = 31 * result + (LocaleID != null ? LocaleID.hashCode() : 0);
        result = 31 * result + (GMTBias != null ? GMTBias.hashCode() : 0);
        result = 31 * result + (RetriesInterval != null ? RetriesInterval.hashCode() : 0);
        result = 31 * result + (UserData != null ? UserData.hashCode() : 0);
        result = 31 * result + (DeleteAfterUsage != null ? DeleteAfterUsage.hashCode() : 0);
        return result;
    }
}