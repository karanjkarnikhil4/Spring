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

public class EagerLazyDemo {

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
			
			//start the transaction
			session.beginTransaction();
			
			//get the instructor from the db
			int theId =1;
			
			Instructor tempInstructor =session.get(Instructor.class,theId);
			
			System.out.println("Instructor: " + tempInstructor.toString());
			
			//get the courses for the instructor
			//option 1 call the getter method while session is open
			System.out.println("Courses: "+tempInstructor.getCourses());
		
			
			//commit  the transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\n The session is now closed \n");	
			
			System.out.println("Luv 2 Code Done!");
		}
		
		finally {
			session.close();
			factory.close();
			
		}
		
		
	}

}
