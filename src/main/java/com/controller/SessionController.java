package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.MailService;

import jakarta.mail.MessagingException;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@Autowired
	MailService mailService;

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
	public String saveUser(@Validated UserBean user, BindingResult result, Model model) {
		System.out.println("saveuser-->");
		// read -> bean

		// validation
		if (result.hasErrors()) {
//			System.out.println(result.getFieldError("firstName").getDefaultMessage());
			model.addAttribute("result", result);
			return "Signup";
		} else {
			// db insertion

			System.out.println(user.getProfilePic().getOriginalFilename());//

			// copy file into webapp/profilepic
			File file = new File("C:\\sts\\24-spring-boot-web-1pm\\src\\main\\webapp\\profilepic\\",
					user.getProfilePic().getOriginalFilename());

			try {
				FileUtils.writeByteArrayToFile(file, user.getProfilePic().getBytes(), false);
				user.setProfilePicPath("profilepic/" + user.getProfilePic().getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}

			userDao.addUser(user);

			// mail send
			mailService.sendWelcomeEmail(user.getEmail(), user.getFirstName());
//			

			try {
				mailService.sendWelcomeEmailTemplate(user.getEmail(), user.getFirstName());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Login";

		}
	}

	@PostMapping("/authenticate")
	public String authenticate(UserBean user,Model model) {// email password
		UserBean dbUser = userDao.getUserByEmail(user.getEmail());
		model.addAttribute("user",dbUser);
		return "Home";
	}
}
