package com.fuppino.spring.springjdbc.dao;

import com.fuppino.spring.springjdbc.dto.Employee;

public interface EmployeeDAO {
	int create(Employee employee);
	int update(Employee employee);
	int delete(Employee employee);
}
