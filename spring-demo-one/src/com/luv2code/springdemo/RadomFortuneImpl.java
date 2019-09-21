package com.luv2code.springdemo;

public class RadomFortuneImpl implements FortuneService {

  public RadomFortuneImpl() {

    fortunes[0] = "Today is your best day";
    fortunes[1] = "Today is your fansastic day";
    fortunes[2] = "Today is your awesome day";
  }



  private String[] fortunes = new String[3];



  @Override
  public String getFortune() {
    return fortunes[(int) Math.round(Math.random() * 2)];

  }

}
