package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

	@GetMapping("/newuser")//url ->it can be anything -
	public String signup() { //method name can be anything 
		System.out.println("NEW USER");
		return "Signup"; //jsp name  -- must be your jsp name 
	}
}
