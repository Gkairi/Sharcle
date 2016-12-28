package com.ca.innovate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/test")
	public String home() {
		return "TesT Spring Boot..";
	}

	
}
