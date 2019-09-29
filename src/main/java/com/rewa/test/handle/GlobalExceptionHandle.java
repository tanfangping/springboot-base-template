package com.rewa.test.handle;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.rewa.test.enums.ResultCode;
import com.rewa.test.exception.BusinessException;
import com.rewa.test.msg.response.UnitiveResponse;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandle {

	
    @ExceptionHandler(value = BusinessException.class)
    public UnitiveResponse errorHandler(BusinessException e) {
		log.error("请求id:"+e.getRequestId() + ",错误原因：" + e.getMainCause(),e);
        return UnitiveResponse.error(e);
    }
	
    @ExceptionHandler(value = Exception.class)
    public UnitiveResponse errorHandler(Exception e) {
		BusinessException ex = new BusinessException(ResultCode.SYSTEM_INNER_ERROR,e);
		log.error("错误id:"+ex.getRequestId() + ",错误原因：" + ex.getMainCause(),ex);
		return UnitiveResponse.error(ex);
    }
}
