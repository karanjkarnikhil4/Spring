package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentWithDateDemo {

	public static void main(String[] args) {

		//create the session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class)
				.buildSessionFactory();
		 
		//create session
		Session session =factory.getCurrentSession();
		
		try
		{
	
			
			//create a student object
			System.out.println("creating a new student object with date of birth");
			String dateStr = "31/12/1998";
			Date date = DateUtils.parseDate(dateStr);
			Student tempStudent = new Student("paul","wall","paul@luv2code.com",date);
			
			//start a transaction
			session.beginTransaction();
			
			
			//save the student object
			session.save(tempStudent);
			
			//commit  the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		finally {
			
		}
		
		
	}

}


