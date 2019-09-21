package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

  public static void main(String[] args) {

    // load the spring configuration file
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from the spring container
    Coach coach = applicationContext.getBean("myCoach", Coach.class);

    // call methods on the bean
    System.out.println(coach.getDailyWorkout());

    // lets call our new for fortunes
    System.out.println(coach.getDailyFortune());

    // close the context
    applicationContext.close();
  }

}
