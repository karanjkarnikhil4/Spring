package com.luv2code.springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService)
	{
		this.fortuneService= fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "swim 1000 metres as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
