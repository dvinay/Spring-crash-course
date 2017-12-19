package com.fuppino.spring.springjavaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao dao = config.getBean(Dao.class);
        dao.create();
        
        Service service = config.getBean(Service.class);
        service.save();
    }
}
