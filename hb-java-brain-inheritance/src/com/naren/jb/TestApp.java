package com.naren.jb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naren.jb.entity.Address;
import com.naren.jb.entity.FourVehicle;
import com.naren.jb.entity.SixVehicle;
import com.naren.jb.entity.TwoVehicle;
import com.naren.jb.entity.UserDetails;
import com.naren.jb.entity.Vehicle;

public class TestApp {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		Vehicle vehicle = new Vehicle("Car");

		FourVehicle car = new FourVehicle("Car steering vehicle ");
		car.setName("Maruti Suziki Shift Desire");

		TwoVehicle bike = new TwoVehicle("Bike Steering vehicle");
		bike.setName("Apache RTR");
		
		SixVehicle bus	= new SixVehicle("Bus Power Steering");
		bus.setName("Volvo");

		try {
			System.out.println("Start transaction...");
			session.beginTransaction();
			session.save(vehicle);
			session.save(car);
			session.save(bike);
			session.save(bus);

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
