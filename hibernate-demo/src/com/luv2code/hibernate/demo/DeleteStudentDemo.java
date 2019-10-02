package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			System.out.println("deleting the student");
			
//			//delete the student
//			System.out.println(student.toString());
//			session.delete(student);
			
			//delete the student where id =2
			System.out.println("Deleting student where id =2");
			session.createQuery("Delete from Student where id =2").executeUpdate();
		    
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		finally {
			
		}
		
		
	}

}
