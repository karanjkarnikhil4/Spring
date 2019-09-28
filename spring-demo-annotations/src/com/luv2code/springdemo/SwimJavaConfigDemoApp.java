package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from the spring container
		//Coach coach =context.getBean("thatSillyCoach",Coach.class); this is for named bean id
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);
		//call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		// call the method to get the fortune
		System.out.println(coach.getDailyFortune());
		
		// call the method to get the email
		System.out.println(coach.getEmail());	
				
		// call the method to get the team
		System.out.println(coach.getTeam());	
		
		//close the context
		context.close();

	}

}
