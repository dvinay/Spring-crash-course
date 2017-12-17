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
//        int result = employeeDAO.create(employee); 
//        int result = employeeDAO.update(employee);
//        int reslt = employeeDAO.delete(employee);
//		System.out.println("Number of records inserted : "+result);
//        System.out.println("Employee : "+employeeDAO.read(2));
        System.out.println("Employee : "+employeeDAO.read());
    }
}
