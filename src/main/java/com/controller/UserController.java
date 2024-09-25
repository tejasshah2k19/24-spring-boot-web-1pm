package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/users")
	public String getAllUsers(Model model) {

		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users", users);
		return "ListUser";// jsp
	}

	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		// dao->delete user ->
		userDao.deleteByUserId(userId);
		return "redirect:/users";// method - url
	}

	@GetMapping("/viewuser")
	public String viewUser(@RequestParam("userId") Integer userId,Model model) {
		// dao->get user by id ->
		UserBean user = userDao.getByUserId(userId);
		model.addAttribute("user",user);
		return "ViewUser";// method - url
	}

}
