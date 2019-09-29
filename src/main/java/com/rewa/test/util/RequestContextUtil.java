/**
 * 
 */
package com.rewa.test.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Description
 * @author hero
 * @date 2018年9月29日
 */
public class RequestContextUtil {
	public static HttpServletRequest getRequest() {
		return getRequestAttributes().getRequest();
	}

	public static HttpServletResponse getResponse() {
		return getRequestAttributes().getResponse();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static ServletRequestAttributes getRequestAttributes() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
	}

	public static ServletContext getServletContext() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext();
	}
	
	public static Long getRequestId () {
		 return (Long) getRequest().getAttribute(DBConstants.REQUEST_ID);
	}
	
	public static void setRequestId () {
		getRequest().setAttribute(DBConstants.REQUEST_ID, System.currentTimeMillis());
	}
}
