package com.naren.jb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.entity.Address;
import com.naren.jb.entity.UserDetails;

public class TestApp {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Start transaction...");
			session.beginTransaction();
			
			System.out.println("Create User...");
			UserDetails user = new UserDetails("Naren","Singh","naren@gmail.com");
			
			Address homeAddress= new Address("16th main","Ben","Kar","India");
			
			user.setHomeAddress(homeAddress);
			
			System.out.println("User Created..."+user);
			System.out.println("Start Saving User...");
			session.save(user);
			
			System.out.println("User Saved Successfully...");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
