package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) throws ParseException {

		//create the session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		 
		//create session
		Session session =factory.getCurrentSession();
		
		try
		{
			
			
			//start the transaction 
			session.beginTransaction();
			
			int theId =4;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);
			
		
				System.out.println("Found InstructorDetail: " +instructorDetail.toString());
				
				
				//print out the associated Instructor as well
				System.out.println("Found Instructor: " +instructorDetail.getInstructor().toString());
				
				//break the link between Instructor and Instructor Detail
				instructorDetail.getInstructor().setDetail(null);
				
				System.out.println("Deleting instructorDetail "+ instructorDetail.toString());
			
				session.delete(instructorDetail);
		
			
			//commit  the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}
		
		
	}

}
