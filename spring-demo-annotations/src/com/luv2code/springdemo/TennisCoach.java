package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")

@Component //default bean id is tennisCoach
@Scope("prototype")
public class TennisCoach implements Coach {
	
	// this is field injecton 
	// injection is happening on the private field using reflection
	@Autowired
	//@Qualifier("happyFortuneService")
	//@Qualifier("randomFortuneService")
	@Qualifier("nikhilRandomFortuneService")
	private FortuneService fortuneService;
	
	private String playerName;
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	
	public String getPlayerName() {
		return playerName;
	}

	@Value("${foo.name}")
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	
	public String getPlayerSurname() {
		return playerSurname;
	}

	@Value("${foo.surname}")
	public void setPlayerSurname(String playerSurname) {
		this.playerSurname = playerSurname;
	}

	public String getPlayerPhone() {
		return playerPhone;
	}

	@Value("${foo.mobilenumber}")
	public void setPlayerPhone(String playerPhone) {
		this.playerPhone = playerPhone;
	}

	public String getPlayerEmail() {
		return playerEmail;
	}

	@Value("${foo.email}")
	public void setPlayerEmail(String playerEmail) {
		this.playerEmail = playerEmail;
	}

	public String getAge() {
		return age;
	}

	@Value("${foo.age}")
	public void setAge(String age) {
		this.age = age;
	}

	private String playerSurname;
	private String playerPhone;
	private String playerEmail;
	private String age;
	
	
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
		return "Hi "+getPlayerName()+" Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return getPlayerSurname() +" "+"With age "+getAge()+" "+this.fortuneService.getFortune();
	}
	
	

}
