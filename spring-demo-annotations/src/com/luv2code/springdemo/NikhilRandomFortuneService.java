package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NikhilRandomFortuneService implements FortuneService {
	
	private String[] myrandomString;

	public String getPlayerSurname() {
		return playerSurname;
	}

	@Value("${foo.surname}")
	public void setPlayerSdurname(String playerSurname) {
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
	
	
	@Override
	public String getFortune() {
		
		Random random = new Random();
		
		
		return myrandomString[random.nextInt(3)];
	}
	
	@PostConstruct
	private void PostContructingarguments()
	{
		String a = getAge();
		String b = getPlayerPhone();
		String c = getPlayerEmail();
		String d = getPlayerSurname();
		
		myrandomString = new String[4];
		
		myrandomString[0] = a;
		myrandomString[1] = b;
		myrandomString[2] = c;
		myrandomString[3] = d;
		
	}
	
	
	
	
	
}
