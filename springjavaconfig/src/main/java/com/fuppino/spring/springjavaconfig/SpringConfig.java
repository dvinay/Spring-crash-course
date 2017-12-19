package com.fuppino.spring.springjavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.fuppino.spring.springjavaconfig.dao.DaoConfig;

@Configuration
@Import(DaoConfig.class)
public class SpringConfig {
	@Bean
	@Scope("prototype")
	public Service service() {
		return new Service();
	}
}
