/**
 * 
 */
package com.rewa.test.interceptor;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.rewa.test.annotations.ResponseNature;
import com.rewa.test.util.DBConstants;
import com.rewa.test.util.RequestContextUtil;
/**
 * @Description 
 * @author hero
 * @date 2018年10月11日
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
	

	/**
	 * 拦截请求，如果请求的方法或者类上有ResponseResult注解，那么就在request的attr中加入一个属性标识
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		RequestContextUtil.setRequestId();
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Class<?> clazz = handlerMethod.getBeanType();
			final Method method = handlerMethod.getMethod();
			if (clazz.isAnnotationPresent(ResponseNature.class) ||  method.isAnnotationPresent(ResponseNature.class)) {
				return true;
			}
			request.setAttribute(DBConstants.RESPONSE_RESULT,DBConstants.RESPONSE_RESULT);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}


}
