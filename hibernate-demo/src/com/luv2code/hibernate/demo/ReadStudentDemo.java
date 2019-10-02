package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			System.out.println("creating a new student object");
			Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
			
			//start a transaction
			session.beginTransaction();
			
			
			//save the student object
			System.out.println(tempStudent.toString());
			session.save(tempStudent);
			System.out.println("Saving the student...");
			
			//commit  the transaction
			session.getTransaction().commit();
			
			
			//find out the student's ID:primary key
			System.out.println("Saved student. Generated id: " +tempStudent.getId());
			
			//now get a new session and start the transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
			
			
			//retrieve student based on the id:primary key
			System.out.println("\n Getting student with id: "+tempStudent.getId());
			Student student =session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: "+student);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		finally {
			
		}
		
		
	}

}
