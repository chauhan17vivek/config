package com.firstJavaspringwar.vivek.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	
	 
	
	@Value("${app.name}")
	private String appName;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello user "+appName;
		
	}
	
}
