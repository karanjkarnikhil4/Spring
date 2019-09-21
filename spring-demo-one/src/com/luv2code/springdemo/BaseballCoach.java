package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

  // define a private field for the dependency
  private FortuneService fortuneService;

  // define a constructor for the dependency injection
  public BaseballCoach(FortuneService fortuneService) {

    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 30 miutes on batting practice";
  }

  @Override
  public String getDailyFortune() {
    // use my fortuneService to get a fortune
    return fortuneService.getFortune();
  }

  @Override
  public String getTeam() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getEmailAddress() {
    // TODO Auto-generated method stub
    return null;
  }

}
