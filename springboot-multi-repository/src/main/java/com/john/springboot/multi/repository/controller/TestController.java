package com.john.springboot.multi.repository.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.john.springboot.multi.repository.service.TestServiceImpl;

@RestController
public class TestController {
	
	@Autowired
    private TestServiceImpl service;
	
	@RequestMapping("/update")
	public String updateUser(String id, String name) {
		Map m = new HashMap();
		m.put("id", id);
		m.put("name", name);
		service.updateUser(m);
		
		return "success";
	}
}
