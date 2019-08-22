package com.naren.jb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.entity.Address;
import com.naren.jb.entity.UserDetails;
import com.naren.jb.entity.Vehicle;

public class TestApp {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start transaction...");
			session.beginTransaction();

			System.out.println("Create User...");
			UserDetails user = new UserDetails("Naren1", "Singh1", "naren1@gmail.com");

			Vehicle vehicle = new Vehicle("Honda");

			user.setVehicle(vehicle);
			session.persist(user);
			
			Thread.sleep(10000);
//			session.save(vehicle);
			System.out.println("User Saved Successfully...");

			session.getTransaction().commit();
			session.close();

			session = factory.getCurrentSession();
			session.beginTransaction();
			
			UserDetails user1 = session.get(UserDetails.class, 1);
			session.delete(user1);
			session.getTransaction().commit();
			System.out.println("Delete successfull");
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
