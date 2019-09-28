package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of Strings
	private String[] data = {"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good lunk",
			"The journey is the record"};
	
	private Random myrandom= new Random();
	
	@Override
	public String getFortune() {
		int index = myrandom.nextInt(data.length);
		return data[index];
	}

}
