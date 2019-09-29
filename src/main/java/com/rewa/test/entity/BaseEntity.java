package com.rewa.test.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rewa.test.handle.Long2StringHandle;

import lombok.Data;

@Data
public class BaseEntity{

	@TableId(type=IdType.ID_WORKER)
	@JsonSerialize(using=Long2StringHandle.class)
	private Long id;
	
	@TableField(fill = FieldFill.INSERT) // 新增执行
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdTime;
	
	@TableField(fill = FieldFill.INSERT_UPDATE) // 新增和修改执行
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedTime;
}
