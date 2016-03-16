package com.firstdata.services.common.notification;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterCDATA extends XmlAdapter<String, String> {

    @Override
    public String marshal(String arg0) throws Exception {
    	
    	
        return new String(("<![CDATA[" + arg0 + "]]>").getBytes(), "UTF-8");
    }
    @Override
    public String unmarshal(String arg0) throws Exception {
        return arg0;
    }

}