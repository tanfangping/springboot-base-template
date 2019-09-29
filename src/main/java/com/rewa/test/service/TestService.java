package com.rewa.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rewa.test.entity.User;
import com.rewa.test.mapper.TestMapper;

@Service
public class TestService extends ServiceImpl<TestMapper, User>{

	@Autowired
	private TestMapper testMapper;
	
	public void insertUser(User user) {
		testMapper.insert(user);
	}

	public User getUser() {
		User selectById = testMapper.selectById("1176801890755252226");
//		try {
//			System.out.println(1/0);
//		}catch (Exception e) {
//			throw new BusinessException(ResultCode.TEST,e);
//			throw new BusinessException(ResultCode.TEST,e,3);
//		}
		return selectById;
	}
}
