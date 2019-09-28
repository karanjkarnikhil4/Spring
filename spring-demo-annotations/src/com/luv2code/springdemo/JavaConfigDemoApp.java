package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from the spring container
		//Coach coach =context.getBean("thatSillyCoach",Coach.class); this is for named bean id
		Coach coach = context.getBean("tennisCoach",Coach.class);
		//call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		// call the method to get the fortune
		System.out.println(coach.getDailyFortune());
		
		//close the context
		context.close();

	}

}
