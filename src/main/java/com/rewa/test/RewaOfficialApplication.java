package com.rewa.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("com.rewa.test.mapper")
public class RewaOfficialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewaOfficialApplication.class, args);
	}
}
