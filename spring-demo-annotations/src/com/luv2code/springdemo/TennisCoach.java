package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")

@Component //default bean id is tennisCoach
public class TennisCoach implements Coach {
	
	// this is field injeciton 
	// injection is happening on the private field using reflection
	@Autowired
	//@Qualifier("happyFortuneService")
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//Constructor injection
//	@Autowired
//	public TennisCoach(FortuneService fortuneService)
//	{
//		this.fortuneService = fortuneService;
//	}
	
	public  TennisCoach()
	{
	  System.out.println(">> inside default constructor");
	}
	
	//Setter injection
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService)
//	{
//		this.fortuneService = fortuneService;
//		System.out.println(">>inside the setFortuneService method");
//	}
	
	
	// this is method injection
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService)
//	{
//		System.out.println(">>inside the doSomeCrazyStuff method");
////		}
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}
	
	

}
