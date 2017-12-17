package com.fuppino.spring.springjdbc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fuppino.spring.springjdbc.dao.EmployeeDAO;
import com.fuppino.spring.springjdbc.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
        int resultCount = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
        return resultCount;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
