package com.naren.jb.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")

public class FourVehicle extends Vehicle {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

	public FourVehicle(String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}

	public FourVehicle() {
		super();
	}
	
	

}
