package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//read the spring config file
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		//retrieve the bean from the spring container
		Coach coach = applicationContext.getBean("tennisCoach",Coach.class);
		
		Coach alphacoach = applicationContext.getBean("tennisCoach",Coach.class);
		
		
		
		//check to see if  they are same
		boolean result = (coach == alphacoach);
		
		
		System.out.println("\nPointing to the same object "+result);
		System.out.println("\nMemory location for coach "+coach);
		System.out.println("\nMemory location for alphaCoach "+alphacoach);
		
		
		//close the context
		applicationContext.close();
		

	}

}
