package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) throws ParseException {

		//create the session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		 
		//create session
		Session session =factory.getCurrentSession();
		
		try
		{
			
			//start the transaction
			session.beginTransaction();
			
			//create a course
			Course course = new Course("Pacman- How to Score One Million Points");
			
			//add some reviews 
			course.addReview(new Review("Great course.. loved it!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dumb course, you are an idiot"));
			
			//save the course and leverage the cascade all
			//saving the course and leverage the cascade all :)
			System.out.println("saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			session.save(course);
			
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
