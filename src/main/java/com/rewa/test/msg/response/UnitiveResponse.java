/**
 * 
 */
package com.rewa.test.msg.response;

import com.rewa.test.enums.ResultCode;
import com.rewa.test.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author thinker
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UnitiveResponse{

	private Integer code;

	private String msg;

	private Object data;
	
	// 错误原因
	protected String mainCause;
	
	// 详细堆栈信息
	protected String trace;
	
	// 请求id，唯一的
	private Long requestId;
	
	public static UnitiveResponse success() {
		UnitiveResponse result = new UnitiveResponse();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}

	public static UnitiveResponse success(Object data) {
		UnitiveResponse result = new UnitiveResponse();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	private void setResultCode(ResultCode code) {
		this.code = code.code();
		this.msg = code.message();
	}
	
	public static UnitiveResponse error(BusinessException e) {
		UnitiveResponse u = new UnitiveResponse();
		u.setCode(e.getCode());
		u.setMainCause(e.getMainCause());
		u.setMsg(e.getMessage());
		u.setTrace(e.getTrace());
		u.setRequestId(e.getRequestId());
		return u;
	}
}
