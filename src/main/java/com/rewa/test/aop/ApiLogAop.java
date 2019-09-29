package com.rewa.test.aop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import com.rewa.test.util.RequestContextUtil;
import lombok.extern.log4j.Log4j2;

@Aspect
@Configuration
@Log4j2
public class ApiLogAop {

	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 定义一个切入点.
     * 解释下:
     *
     */
     @Pointcut("execution(* com.rewa.test.controller.*.*(..))")
     public void webLog(){}
     
     @Around("webLog()")
     public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
    	Object result = null;
    	long startTime = System.currentTimeMillis();
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			logInfo(joinPoint,startTime,false);
			throw e;
		}
		logInfo(joinPoint,startTime,true);
		return result;
     }
     
     public void logInfo (ProceedingJoinPoint joinPoint,long startTime,boolean status) {
    	 long endTime = System.currentTimeMillis();
    	HttpServletRequest request = RequestContextUtil.getRequest();
    	String requestMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    	StringBuffer sb = new StringBuffer("");
    	sb.append("api接口访问日志-----").
    	append("请求id:").append(RequestContextUtil.getRequestId()).append(",").
    	append("执行方法:").append(requestMethod).append(",").
    	append("执行状态:").append(status == true?"成功":"失败").append(",").
    	append("执行时间:").append(dtf.format(LocalDateTime.now())).append(",").
    	append("耗时(毫秒):").append(endTime-startTime).append(",").
    	append("URL:").append(request.getRequestURL().toString()).append(" ").append(request.getMethod()).append(",").
    	append("IP:").append(request.getRemoteAddr()).append(",").
    	append("ARGS:").append(Arrays.toString(joinPoint.getArgs()));
    	log.info(sb.toString());
     }
}
