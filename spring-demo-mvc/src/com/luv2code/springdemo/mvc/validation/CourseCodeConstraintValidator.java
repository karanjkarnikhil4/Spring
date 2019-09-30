package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result=true;
		if(theCode!=null)
		{
			result= theCode.startsWith(coursePrefix);
		}
		
		return result;
	}
	
	@Override 
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

}
