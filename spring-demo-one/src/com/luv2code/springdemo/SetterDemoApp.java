package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

  public static void main(String[] args) {

    // load the spring configuration file
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from the spring container
    Coach coach = applicationContext.getBean("myCricketCoach", Coach.class);

    // call methods on the bean
    System.out.println(coach.getDailyWorkout());

    // lets call our new for fortunes
    System.out.println(coach.getDailyFortune());

    // call ourr new methods to get the literal values
    System.out.println(coach.getEmailAddress());
    System.out.println(coach.getTeam());

    // close the context
    applicationContext.close();

  }

}
