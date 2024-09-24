package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/newuser") // url ->it can be anything -
	public String signup() { // method name can be anything
		System.out.println("NEW USER");
		return "Signup"; // jsp name -- must be your jsp name
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/saveuser")
	public String saveUser(@Validated UserBean user, BindingResult result,Model model) {
		System.out.println("saveuser-->");
		// read -> bean

		// validation
		if (result.hasErrors()) {
//			System.out.println(result.getFieldError("firstName").getDefaultMessage());
			model.addAttribute("result",result);
			return "Signup";
		} else {
			//db insertion 
			userDao.addUser(user);
			System.out.println(user.getFirstName());
			System.out.println(user.getEmail());
			return "Login";

		}
	}
}
