package com.fuppino.spring.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fuppino.spring.springmvc.dto.Employee;

@Controller
public class ListController {
	
	@RequestMapping("/readList")
	public ModelAndView sendList(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displaylist");
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee1 = new Employee();
		employee1.setId(1234);
		employee1.setName("Ravana");
		employee1.setSalary(200000);
		
		Employee employee2 = new Employee();
		employee2.setId(1235);
		employee2.setName("Laxmana");
		employee2.setSalary(120000);
		
		Employee employee3 = new Employee();
		employee3.setId(1235);
		employee3.setName("Bharata");
		employee3.setSalary(180000);
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		
		modelAndView.addObject("employees",employees);
		
		return modelAndView;
	}
}
