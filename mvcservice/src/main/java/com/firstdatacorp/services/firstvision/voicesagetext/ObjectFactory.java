
package com.firstdatacorp.services.firstvision.voicesagetext;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.firstdatacorp.services.firstvision.common.FVApplicationFault;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.firstdatacorp.services.firstvision.voicesagetext package. 
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

    private final static QName _Operation1Fault1PerformTextSchedulerFault_QNAME = new QName("http://firstdatacorp.com/Services/FirstVision/VoiceSageText", "operation1Fault1_PerformTextSchedulerFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.firstdatacorp.services.firstvision.voicesagetext
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TextSchedulerResponse }
     * 
     */
    public TextSchedulerResponse createTextSchedulerResponse() {
        return new TextSchedulerResponse();
    }

    /**
     * Create an instance of {@link TextSchedulerResp }
     * 
     */
    public TextSchedulerResp createTextSchedulerResp() {
        return new TextSchedulerResp();
    }

    /**
     * Create an instance of {@link TextScheduler }
     * 
     */
    public TextScheduler createTextScheduler() {
        return new TextScheduler();
    }

    /**
     * Create an instance of {@link TextSchedulerReq }
     * 
     */
    public TextSchedulerReq createTextSchedulerReq() {
        return new TextSchedulerReq();
    }

    /**
     * Create an instance of {@link Schedules }
     * 
     */
    public Schedules createSchedules() {
        return new Schedules();
    }

    /**
     * Create an instance of {@link Errors }
     * 
     */
    public Errors createErrors() {
        return new Errors();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link Keyvaluepair }
     * 
     */
    public Keyvaluepair createKeyvaluepair() {
        return new Keyvaluepair();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FVApplicationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://firstdatacorp.com/Services/FirstVision/VoiceSageText", name = "operation1Fault1_PerformTextSchedulerFault")
    public JAXBElement<FVApplicationFault> createOperation1Fault1PerformTextSchedulerFault(FVApplicationFault value) {
        return new JAXBElement<FVApplicationFault>(_Operation1Fault1PerformTextSchedulerFault_QNAME, FVApplicationFault.class, null, value);
    }

}
