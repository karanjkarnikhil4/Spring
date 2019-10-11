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

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) throws ParseException {

		//create the session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		 
		//create session
		Session session =factory.getCurrentSession();
		
		try
		{
			
			//start the transaction
			session.beginTransaction();
			
			//create a course
			Course course = new Course("Pacman- How to Score One Million Points");
		   
			//save the course
			System.out.println("\nSaving the course");
			session.save(course);
			System.out.println("\nSaved the course" + course);
			
			//create the students
			Student student1 = new Student("John","Doe","john@luv2code.com");
			Student student2 = new Student("Mary","Public","mary@luv2code.com");
			
			
			//add the students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the course and leverage the cascade all
			//saving the course and leverage the cascade all :)
			System.out.println("saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			session.save(student1);
			session.save(student2);
			
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
