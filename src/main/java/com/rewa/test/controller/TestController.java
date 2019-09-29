package com.rewa.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewa.test.entity.User;
import com.rewa.test.service.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	public static ObjectMapper om = new ObjectMapper();
	
	@RequestMapping("/insert")
	public void insertUser(User user) {
		testService.insertUser(user);
	}
	
	@RequestMapping("/get")
	public User getUser(){
		User byId = testService.getUser();
		return byId;
	}
}
