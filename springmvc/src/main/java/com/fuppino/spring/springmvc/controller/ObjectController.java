package com.fuppino.spring.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fuppino.spring.springmvc.dto.Employee;

@Controller
public class ObjectController {
	
	@RequestMapping("/readObject")
	public ModelAndView sendObject(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayobject");
		Employee employee = new Employee();
		employee.setId(1234);
		employee.setName("Ravana");
		employee.setSalary(200000);
		
		modelAndView.addObject("employee",employee);
		
		return modelAndView;
	}
}
