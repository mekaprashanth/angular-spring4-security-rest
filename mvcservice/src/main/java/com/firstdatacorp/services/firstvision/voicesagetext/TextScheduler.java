
package com.firstdatacorp.services.firstvision.voicesagetext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TextSchedulerReq" type="{http://firstdatacorp.com/Services/FirstVision/VoiceSageText}TextSchedulerReq"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "textSchedulerReq"
})
@XmlRootElement(name = "textScheduler")
public class TextScheduler {

    @XmlElement(name = "TextSchedulerReq", required = true, nillable = true)
    protected TextSchedulerReq textSchedulerReq;

    /**
     * Gets the value of the textSchedulerReq property.
     * 
     * @return
     *     possible object is
     *     {@link TextSchedulerReq }
     *     
     */
    public TextSchedulerReq getTextSchedulerReq() {
        return textSchedulerReq;
    }

    /**
     * Sets the value of the textSchedulerReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextSchedulerReq }
     *     
     */
    public void setTextSchedulerReq(TextSchedulerReq value) {
        this.textSchedulerReq = value;
    }

}
