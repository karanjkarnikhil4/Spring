package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) throws ParseException {

		//create the session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		 
		//create session
		Session session =factory.getCurrentSession();
		
		try
		{
			//create the objects
			Instructor tempInstructor = new Instructor("Susan","Public","susan.public@luv2code.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/youtube","Video Games");
			
			tempInstructor.setDetail(instructorDetail);
			
			//associate the objects
		
			//start the transaction
			//Note: this will also save the details object
			//
			System.out.println("Saving instructor: " +tempInstructor);
			session.beginTransaction();
			
			//save the transaction
			session.save(tempInstructor);
			
			//commit  the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		finally {
			session.close();
			factory.close();
			
		}
		
		
	}

}
