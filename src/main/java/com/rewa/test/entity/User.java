package com.rewa.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value="user")
@Data
public class User extends BaseEntity{
	private String name;
	private String phone;
}
