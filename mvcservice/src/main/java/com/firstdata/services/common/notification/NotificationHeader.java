
package com.firstdata.services.common.notification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotificationHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotificationHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NotifyTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SequenceNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProcessID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PlatformCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CategoryKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KeyLookup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionNeeded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationHeader", propOrder = {
    "notifyTime",
    "sequenceNum",
    "eventTime",
    "processID",
    "eventCode",
    "platformCode",
    "categoryCode",
    "categoryKey",
    "keyLookup",
    "actionNeeded"
})
public class NotificationHeader {

    @XmlElement(name = "NotifyTime", required = true)
    protected String notifyTime;
    @XmlElement(name = "SequenceNum")
    protected String sequenceNum;
    @XmlElement(name = "EventTime", required = true)
    protected String eventTime;
    @XmlElement(name = "ProcessID")
    protected String processID;
    @XmlElement(name = "EventCode", required = true)
    protected String eventCode;
    @XmlElement(name = "PlatformCode")
    protected String platformCode;
    @XmlElement(name = "CategoryCode")
    protected String categoryCode;
    @XmlElement(name = "CategoryKey")
    protected String categoryKey;
    @XmlElement(name = "KeyLookup")
    protected String keyLookup;
    @XmlElement(name = "ActionNeeded", required = true)
    protected String actionNeeded;

    /**
     * Gets the value of the notifyTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotifyTime() {
        return notifyTime;
    }

    /**
     * Sets the value of the notifyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotifyTime(String value) {
        this.notifyTime = value;
    }

    /**
     * Gets the value of the sequenceNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceNum() {
        return sequenceNum;
    }

    /**
     * Sets the value of the sequenceNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceNum(String value) {
        this.sequenceNum = value;
    }

    /**
     * Gets the value of the eventTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * Sets the value of the eventTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventTime(String value) {
        this.eventTime = value;
    }

    /**
     * Gets the value of the processID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessID() {
        return processID;
    }

    /**
     * Sets the value of the processID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessID(String value) {
        this.processID = value;
    }

    /**
     * Gets the value of the eventCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventCode() {
        return eventCode;
    }

    /**
     * Sets the value of the eventCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventCode(String value) {
        this.eventCode = value;
    }

    /**
     * Gets the value of the platformCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * Sets the value of the platformCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformCode(String value) {
        this.platformCode = value;
    }

    /**
     * Gets the value of the categoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
    }

    /**
     * Gets the value of the categoryKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryKey() {
        return categoryKey;
    }

    /**
     * Sets the value of the categoryKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryKey(String value) {
        this.categoryKey = value;
    }

    /**
     * Gets the value of the keyLookup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyLookup() {
        return keyLookup;
    }

    /**
     * Sets the value of the keyLookup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyLookup(String value) {
        this.keyLookup = value;
    }

    /**
     * Gets the value of the actionNeeded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionNeeded() {
        return actionNeeded;
    }

    /**
     * Sets the value of the actionNeeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionNeeded(String value) {
        this.actionNeeded = value;
    }

}
