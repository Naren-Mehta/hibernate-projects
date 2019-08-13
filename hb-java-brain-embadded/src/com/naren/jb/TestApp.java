package com.naren.jb;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.entity.Address;
import com.naren.jb.entity.UserDetails;

public class TestApp {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Start transaction...");
			session.beginTransaction();

			System.out.println("Create User...");
			UserDetails user = new UserDetails("Naren", "Singh", "naren@gmail.com");

			Address homeAddress = new Address("16th main", "Ben", "Kar", "India");
			Address officeAddress = new Address("4A AMR tech Park", "Ben", "Kar", "India");

			Set<Address> addressList= new HashSet<Address>();
			addressList.add(officeAddress);
			addressList.add(homeAddress);
			
			user.setListOfAddress(addressList);
			
			user.getPhoneNumbers().add("750000000");
			user.getPhoneNumbers().add("799900900");

			System.out.println("User Created..." + user);
			System.out.println("Start Saving User...");
			
			
			session.save(user);
			session.getTransaction().commit();
			
			System.out.println(user.getListOfAddress());

			System.out.println("User Saved Successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
