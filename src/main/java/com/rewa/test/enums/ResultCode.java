/**
 * 
 */
package com.rewa.test.enums;

/**
 * @author thinker
 *
 */
public enum ResultCode {
	/* 成功状态码 */
	SUCCESS(0, "成功"),
	
	/* 系统错误码 */
	SYSTEM_INNER_ERROR(-1, "The system is busy, please try again"),
	
	
	//前端错误
	
	
	//后端错误
	TEST(2,"test fail {}");
	
	private Integer code;

	private String message;

	public Integer code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}
	
	ResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public static String getMessage(String name) {
		for (ResultCode item : ResultCode.values()) {
			if (item.name().equals(name)) {
				return item.message;
			}
		}
		return name;
	}
	
	public static Integer getCode(String name) {
		for (ResultCode item : ResultCode.values()) {
			if (item.name().equals(name)) {
				return item.code;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.name();
	}
}
