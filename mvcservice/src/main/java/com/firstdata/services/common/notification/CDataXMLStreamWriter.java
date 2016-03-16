package com.firstdata.services.common.notification;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;

public class CDataXMLStreamWriter extends DelegatingXMLStreamWriter {

	private String currentElementName;

	public CDataXMLStreamWriter(XMLStreamWriter del) {
		super(del);
	}

	@Override
	public void writeCharacters(String text) throws XMLStreamException {
		boolean useCData = checkIfCDATAneededForCurrentElement();
		if (useCData) {
			System.out.println("WritingCData" + text);
			super.writeCData(text);
		} else {
			super.writeCharacters(text);
		}
	}

	private boolean checkIfCDATAneededForCurrentElement() {
		if ("FieldValue".equals(currentElementName))
			return true;
		return false;
	}

	public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException {
		currentElementName = local;
		super.writeStartElement(prefix, local, uri);
	}
}