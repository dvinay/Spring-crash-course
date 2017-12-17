package com.fuppino.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class Test 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
        int resultCount = jdbcTemplate.update(sql, new Integer(1), "Ram", "Reddy");
        System.out.println("Number of records inserted : "+resultCount);
    }
}
