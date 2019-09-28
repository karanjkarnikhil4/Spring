package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
public class SportConfig {
	//define a bean for sad fortune Service
	
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}
	
	//define a bean for out swim coach and inject dependency
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(new SadFortuneService());
	}

}
