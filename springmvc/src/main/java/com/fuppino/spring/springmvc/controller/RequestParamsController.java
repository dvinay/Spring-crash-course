package com.fuppino.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fuppino.spring.springmvc.dto.User;

@Controller
public class RequestParamsController {
	
	@RequestMapping("/showData")
	public ModelAndView showData(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("email") String email){
		System.out.println("Id : "+id);
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("regresult");
		return modelAndView;
	}
}
