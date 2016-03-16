package com.prash.camel.sample.jaxws;

import javax.jws.WebService;

import com.prash.camel.sample.jaxws.values.CardDetails;
import com.prash.camel.sample.jaxws.values.PersonDetails;


@WebService(targetNamespace="http://jaxws.sample.camel.prash.com/", serviceName="PersonAccountWSService")
public class PersonAccountWS {
	
	public CardDetails getCardDetails(PersonDetails personDetails)	{
		return null;
	}

}
