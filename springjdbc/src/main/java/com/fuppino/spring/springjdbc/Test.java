package com.fuppino.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fuppino.spring.springjdbc.dao.EmployeeDAO;
import com.fuppino.spring.springjdbc.dto.Employee;

/**
 * Hello world!
 *
 */
public class Test 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("employeeDAOImpl");
        Employee employee = new Employee(2,"Ravan","Reddy");
		System.out.println("Number of records inserted : "+employeeDAO.delete(employee));
    }
}
