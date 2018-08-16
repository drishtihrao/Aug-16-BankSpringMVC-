package com.moneymoney.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}
	
	@RequestMapping("/deposit")
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping("/fundTransfer")
	public String fundTransfer() {
		return "fundTransfer";
	}
}
