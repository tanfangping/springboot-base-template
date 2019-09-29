package com.rewa.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewa.test.entity.User;
import com.rewa.test.service.TestService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class TestController {

	@Autowired
	private TestService testService;
	
	public static ObjectMapper om = new ObjectMapper();
	
	@RequestMapping("/insert")
	public void insertUser(User user) {
		testService.insertUser(user);
	}
	
	@GetMapping("/get")
	public User getUser(String a,String b) throws JsonProcessingException {
		log.error("aaa0");
		User byId = testService.getUser();
		return byId;
	}
}
