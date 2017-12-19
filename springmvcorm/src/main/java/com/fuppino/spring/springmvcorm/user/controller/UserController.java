package com.fuppino.spring.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuppino.spring.springmvcorm.user.entity.User;
import com.fuppino.spring.springmvcorm.user.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/registerationPage")
	public String userRegisteration() {
		return "userreg";
	}
	
	@RequestMapping("/getUsers")
	public String getUsers(ModelMap model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "displayuser";
	}
	
	@RequestMapping("/validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("id") int id) {
		User user = userService.getUser(id);
		String msg = "";
		if(user!=null) {
			msg = id + ": is already exists";
		}
		return msg;
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String userRegisteration(@ModelAttribute("user") User user, ModelMap model ) {
		int result = userService.save(user);
		model.addAttribute("result", "User created with Id : "+result);
		return "userreg";
	}
}
