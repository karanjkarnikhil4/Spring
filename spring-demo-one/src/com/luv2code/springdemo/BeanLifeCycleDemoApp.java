package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

  public static void main(String[] args) {

    // load the spring configuration file
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

    // retrieve bean from spring container
    Coach coach = applicationContext.getBean("myCoach", Coach.class);


    // call methods on the bean
    System.out.println(coach.getDailyWorkout());

    // close the context
    applicationContext.close();

  }

}
