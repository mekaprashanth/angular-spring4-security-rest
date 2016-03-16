
package com.firstdata.services.common.notification;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.firstdata.services.common.notification package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PublishFault1NotificationFault_QNAME = new QName("http://com/firstdata/services/common/notification", "publishFault1_notificationFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.firstdata.services.common.notification
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PublishResponse }
     * 
     */
    public PublishResponse createPublishResponse() {
        return new PublishResponse();
    }

    /**
     * Create an instance of {@link NotificationResponse }
     * 
     */
    public NotificationResponse createNotificationResponse() {
        return new NotificationResponse();
    }

    /**
     * Create an instance of {@link NotificationFault }
     * 
     */
    public NotificationFault createNotificationFault() {
        return new NotificationFault();
    }

    /**
     * Create an instance of {@link Publish }
     * 
     */
    public Publish createPublish() {
        return new Publish();
    }

    /**
     * Create an instance of {@link Notification }
     * 
     */
    public Notification createNotification() {
        return new Notification();
    }

    /**
     * Create an instance of {@link AdditionalMessageData }
     * 
     */
    public AdditionalMessageData createAdditionalMessageData() {
        return new AdditionalMessageData();
    }

    /**
     * Create an instance of {@link NotificationHeader }
     * 
     */
    public NotificationHeader createNotificationHeader() {
        return new NotificationHeader();
    }

    /**
     * Create an instance of {@link MsgField }
     * 
     */
    public MsgField createMsgField() {
        return new MsgField();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com/firstdata/services/common/notification", name = "publishFault1_notificationFault")
    public JAXBElement<NotificationFault> createPublishFault1NotificationFault(NotificationFault value) {
        return new JAXBElement<NotificationFault>(_PublishFault1NotificationFault_QNAME, NotificationFault.class, null, value);
    }

}
