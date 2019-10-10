package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteCourseAndReviewsDemo {

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
			
			// Get the course
			int theId =10;
			Course course =session.get(Course.class, theId);
			//Get the reviews for the course
			List<Review> reviews=course.getReviews();
			//print out the course reviews
			for (Review review : reviews) {
				System.out.println(review.toString());
			}
			
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
