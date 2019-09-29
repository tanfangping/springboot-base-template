package com.rewa.test.handle;

import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import com.rewa.test.msg.response.UnitiveResponse;
import com.rewa.test.util.DBConstants;
import com.rewa.test.util.RequestContextUtil;

@ControllerAdvice
public class ResponseResultHandle implements ResponseBodyAdvice<Object>{

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		HttpServletRequest request = RequestContextUtil.getRequest();
		String flag = (String) request.getAttribute(DBConstants.RESPONSE_RESULT);
		return flag != null && flag.equals(DBConstants.RESPONSE_RESULT);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof UnitiveResponse) {
			return body;
		} else {
			return UnitiveResponse.success(body);
		} 
	}
}
