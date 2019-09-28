package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")

@Component //default bean id is tennisCoach
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public  TennisCoach()
	{
	  System.out.println(">> inside default constructor");
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@PostConstruct
	public void domyStartStuff()
	{
		System.out.println("inside do my start up stuff");
	}
	
	@PreDestroy
	public void doMyCleanUpStuff()
	{
		System.out.println("inside clean up stuff");
	}
	
	@Override
	public String getDailyWorkout() {
		return " Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
}
