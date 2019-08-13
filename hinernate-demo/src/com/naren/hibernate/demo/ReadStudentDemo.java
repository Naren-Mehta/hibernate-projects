package com.naren.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating a Student object...");
			Student tempStudent = new Student("Ujjwal", "u", "ujjwal@gmail.com");

			System.out.println("Start Student..."+tempStudent.getId());
			
			session.beginTransaction();
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			session.close();
			
			
			System.out.println("Sudent Save Successfully!!!!" + tempStudent.getId());

			
			
			
			
			
			
			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//
//			System.out.println("Getting Student from DB with id " + tempStudent.getId());
//
//			Student myStudent = session.get(Student.class, tempStudent.getId());
//			System.out.println("Get Completed " + myStudent);
//			
//			session.getTransaction().commit();
			
			System.out.println("Done!!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
