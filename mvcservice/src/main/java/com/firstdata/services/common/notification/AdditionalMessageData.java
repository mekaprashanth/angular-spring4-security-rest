
package com.firstdata.services.common.notification;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdditionalMessageData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdditionalMessageData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgField" type="{http://com/firstdata/services/common/notification}MsgField" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalMessageData", propOrder = {
    "msgField"
})
public class AdditionalMessageData {

    @XmlElement(name = "MsgField")
    protected List<MsgField> msgField;

    /**
     * Gets the value of the msgField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the msgField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMsgField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MsgField }
     * 
     * 
     */
    public List<MsgField> getMsgField() {
        if (msgField == null) {
            msgField = new ArrayList<MsgField>();
        }
        return this.msgField;
    }

}
