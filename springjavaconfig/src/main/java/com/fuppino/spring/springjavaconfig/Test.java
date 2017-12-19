package com.fuppino.spring.springjavaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fuppino.spring.springjavaconfig.dao.Dao;

public class Test 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao dao = config.getBean(Dao.class);
        dao.create();
        
        Service service1 = config.getBean(Service.class);
        service1.save();
        System.out.println(service1.hashCode());
        
        Service service2 = config.getBean(Service.class);
        service2.save();
        System.out.println(service2.hashCode());
    }
}
