
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
 *         &lt;element name="TextSchedulerResp" type="{http://firstdatacorp.com/Services/FirstVision/VoiceSageText}TextSchedulerResp"/>
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
    "textSchedulerResp"
})
@XmlRootElement(name = "textSchedulerResponse")
public class TextSchedulerResponse {

    @XmlElement(name = "TextSchedulerResp", required = true, nillable = true)
    protected TextSchedulerResp textSchedulerResp;

    /**
     * Gets the value of the textSchedulerResp property.
     * 
     * @return
     *     possible object is
     *     {@link TextSchedulerResp }
     *     
     */
    public TextSchedulerResp getTextSchedulerResp() {
        return textSchedulerResp;
    }

    /**
     * Sets the value of the textSchedulerResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextSchedulerResp }
     *     
     */
    public void setTextSchedulerResp(TextSchedulerResp value) {
        this.textSchedulerResp = value;
    }

}
