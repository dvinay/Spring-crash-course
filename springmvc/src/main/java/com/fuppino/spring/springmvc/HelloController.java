package com.fuppino.spring.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView process(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}
