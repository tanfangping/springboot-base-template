package com.rewa.test.util;

import java.time.LocalDateTime;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Component
public class MetaHandler implements MetaObjectHandler{

	public static final String CREATED_TIME = "createdTime";
	
	public static final String UPDATED_TIME = "updatedTime";
	
	@Override
	public void insertFill(MetaObject metaObject) {
		fillCreatedTime(metaObject);
		fillUpdatedTime(metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		fillUpdatedTime(metaObject);
	}

	private void fillUpdatedTime(MetaObject metaObject) {
		this.setFieldValByName(UPDATED_TIME, LocalDateTime.now(), metaObject);
	}

	private void fillCreatedTime(MetaObject metaObject) {
		this.setFieldValByName(CREATED_TIME, LocalDateTime.now(), metaObject);
	}
}
