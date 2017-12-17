package com.fuppino.spring.springjdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fuppino.spring.springjdbc.dao.EmployeeDAO;
import com.fuppino.spring.springjdbc.dto.Employee;
import com.fuppino.spring.springjdbc.dto.rowmapper.EmployeeRowMapper;

public class EmployeeDAOImpl implements EmployeeDAO{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int create(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
        int resultCount = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
        return resultCount;
	}
	
	@Override
	public int update(Employee employee) {
		String sql = "UPDATE EMPLOYEE SET firstname=?, lastname=? WHERE ID = ?";
        int resultCount = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(),employee.getId());
        return resultCount;
	}

	@Override
	public int delete(Employee employee) {
		String sql = "DELETE FROM EMPLOYEE WHERE ID = ?";
        int resultCount = jdbcTemplate.update(sql, employee.getId());
        return resultCount;
	}
	
	@Override
	public Employee read(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		Employee employee = jdbcTemplate.queryForObject(sql,employeeRowMapper,id);
		return employee;
	}

	@Override
	public List<Employee> read() {
		String sql = "SELECT * FROM EMPLOYEE";
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		List<Employee> employees = jdbcTemplate.query(sql,employeeRowMapper);
		return employees;
	}
}
