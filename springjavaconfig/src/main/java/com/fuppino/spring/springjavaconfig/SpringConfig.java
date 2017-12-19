package com.fuppino.spring.springjavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig 
{
    @Bean
    public Dao dao(){
    	return new Dao();
    }
    
    @Bean
    public Service service(){
    	return new Service();
    }
}
