package com.prash.spring.controller.exception.advice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.prash.spring.model.ErrorDetail;
import com.prash.spring.model.PortalResponse;
import com.prash.spring.service.web.helper.PortalResponseBuilder;

@ControllerAdvice
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
public class ControllerValidationHandler {
	@Autowired
	private MessageSource msgSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	
	public PortalResponse<Void, ErrorDetail> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		
		return processFieldErrors(result.getFieldErrors());
	}

	private PortalResponse<Void, ErrorDetail> processFieldErrors(List<FieldError> errors) {
		List<ErrorDetail> errodDetails = new ArrayList<>();
		PortalResponse<Void, ErrorDetail> portalResponse = PortalResponseBuilder.buildErrorResponse(errodDetails);
		for (FieldError fieldError : errors) {
			Locale currentLocale = LocaleContextHolder.getLocale();
			String msg = msgSource.getMessage(fieldError, currentLocale);
			ErrorDetail errorDetail = PortalResponseBuilder.buildErrorResponse("MPERRV100", msg);
			PortalResponseBuilder.addErrorResponse(portalResponse, errorDetail);
		}
		return portalResponse;
	}
}