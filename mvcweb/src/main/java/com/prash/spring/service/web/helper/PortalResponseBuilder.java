/**
 * 
 */
package com.prash.spring.service.web.helper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.prash.spring.model.ErrorDetail;
import com.prash.spring.model.PortalResponse;

/**
 * @author Prashanth_Meka
 *
 */
public class PortalResponseBuilder {

	public static <T> PortalResponse<T, Void> buildSuccessResponse(T t) {
		PortalResponse<T, Void> pr = new PortalResponse<T, Void>();
		pr.setStatus("success");
		pr.setResponse(t);
		return pr;
	}

	public static <A> PortalResponse<Void, A> buildErrorResponse(List<A> v) {
		PortalResponse<Void, A> pr = new PortalResponse<>();
		pr.setStatus("error");
		pr.setErrors(v);
		return pr;
	}

	public static ErrorDetail buildErrorResponse(String errorCode, String errorMessage) {
		ErrorDetail ed = new ErrorDetail();
		ed.setCode(errorCode);
		ed.setMessage(errorMessage);
		return ed;

	}

	public static <T, V> PortalResponse<Void, V> addErrorResponse(PortalResponse<Void, V> pr, V v) {
		pr.addError(v);
		return pr;
	}

	public static void main(String[] args) throws JsonProcessingException {
		 ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		 objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//		 PortalResponse<PortalUser,Void> pr = buildSuccessResponse(new PortalUser());
//		 System.out.println(objectMapper.writeValueAsString(pr));
		
		 List<ErrorDetail> list = new ArrayList<>();
		 ErrorDetail e1 = new ErrorDetail();
		 e1.setCode("MP001");
		 e1.setMessage("message1");
		 ErrorDetail e2 = new ErrorDetail();
		 e2.setCode("MP002");
		 e2.setMessage("message2");
		 list.add(e1);
		 list.add(e2);
		 PortalResponse<Void,ErrorDetail> pr2 = buildErrorResponse(list);
		 pr2 = addErrorResponse(pr2, e2);
		 System.out.println(objectMapper.writeValueAsString(pr2));

//		AuthenticationException ex = new AccountTemporarilyBlockedException("User account is temporariliy Blocked", new Exception());
//		System.out.println(ex.getCause());

	}

}
