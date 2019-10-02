package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
		
			
			//start a transaction
			session.beginTransaction();
			
			//query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			//query the students
			System.out.println("\n\n Students who have last name of Doe");
			theStudents= session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			
			displayStudents(theStudents);
			
			
			//query the students
			System.out.println("\n\n Students who have last name of Doe or firstName =Daffy");
			theStudents= session.createQuery("from Student s where s.lastName = 'Doe' or firstName = 'Daffy'").getResultList();
			
			displayStudents(theStudents);
			
			
			//query the students where '%luv2code.com'
			theStudents= session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			
			System.out.println("\n students whose email ends with '%luv2code.com'");
			displayStudents(theStudents);
			
			

			//query the students where '%gmail.com'
			theStudents= session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			System.out.println("\n students whose email ends with '%gmail.com'");
			displayStudents(theStudents);
			
			
			//commit  the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		finally {
			
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempstudent : theStudents) {
			System.out.println(tempstudent.toString());
		}
	}

}
