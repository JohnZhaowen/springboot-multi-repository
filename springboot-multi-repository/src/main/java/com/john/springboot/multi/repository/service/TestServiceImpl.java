package com.john.springboot.multi.repository.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.john.springboot.multi.repository.dal.dao.TestDao;

@Service
public class TestServiceImpl {
	
	@Autowired
    private TestDao dao;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void updateUser(Map m) {
		
		int update = dao.update("update_user", m);
		if(update >= 1) {
			System.out.println("success");
		}
		
		int num = 1 / 0;
		
		System.out.println("success");
	}
	
}
