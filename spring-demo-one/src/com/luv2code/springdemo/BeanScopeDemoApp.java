package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

  public static void main(String[] args) {

    // load the spring configuration file
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

    // retrieve bean from spring container
    Coach theCoach = applicationContext.getBean("myCoach", Coach.class);

    Coach alphaCoach = applicationContext.getBean("myCoach", Coach.class);


    // check to see if they are the same
    boolean result = (theCoach.equals(alphaCoach));


    System.out.println("\n Pointing to the same object: " + result);

    System.out.println("\n Memory location for theCoach :" + theCoach);
    System.out.println("\n Memory location for alphaCoach :" + alphaCoach);


    // close the context
    applicationContext.close();

  }

}
