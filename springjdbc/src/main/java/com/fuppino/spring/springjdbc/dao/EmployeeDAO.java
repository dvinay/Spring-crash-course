package com.fuppino.spring.springjdbc.dao;

import java.util.List;

import com.fuppino.spring.springjdbc.dto.Employee;

public interface EmployeeDAO {
	int create(Employee employee);
	int update(Employee employee);
	int delete(Employee employee);
	Employee read(int id);
	List<Employee> read();
}
