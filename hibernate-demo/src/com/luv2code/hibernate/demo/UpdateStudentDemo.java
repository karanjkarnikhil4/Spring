package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			int studentId =1;
			

			
			//now get a new session and start the transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
			
			
			//find out the student's ID:primary key
			System.out.println("\n Getting student with id: "+studentId);
			Student student =session.get(Student.class, studentId);
			System.out.println("Get Complete: "+student);
			
			
			System.out.println("updating the student");
			//update the firstName to Scooby
			student.setFirstName("Scooby");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			//now get a new session and start the transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("Update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		
		finally {
			
		}
		
		
	}

}
