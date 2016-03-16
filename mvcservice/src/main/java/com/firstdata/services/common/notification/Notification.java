
package com.firstdata.services.common.notification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Notification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Notification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NotificationHeader" type="{http://com/firstdata/services/common/notification}NotificationHeader"/>
 *         &lt;element name="AdditionalMessageData" type="{http://com/firstdata/services/common/notification}AdditionalMessageData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Notification", propOrder = {
    "notificationHeader",
    "additionalMessageData"
})
public class Notification {

    @XmlElement(name = "NotificationHeader", required = true)
    protected NotificationHeader notificationHeader;
    @XmlElement(name = "AdditionalMessageData")
    protected AdditionalMessageData additionalMessageData;

    /**
     * Gets the value of the notificationHeader property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationHeader }
     *     
     */
    public NotificationHeader getNotificationHeader() {
        return notificationHeader;
    }

    /**
     * Sets the value of the notificationHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationHeader }
     *     
     */
    public void setNotificationHeader(NotificationHeader value) {
        this.notificationHeader = value;
    }

    /**
     * Gets the value of the additionalMessageData property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalMessageData }
     *     
     */
    public AdditionalMessageData getAdditionalMessageData() {
        return additionalMessageData;
    }

    /**
     * Sets the value of the additionalMessageData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalMessageData }
     *     
     */
    public void setAdditionalMessageData(AdditionalMessageData value) {
        this.additionalMessageData = value;
    }

}
