package com.naren.jb.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
public class TwoVehicle extends Vehicle {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	public TwoVehicle(String steeringHandle) {
		super();
		this.steeringHandle = steeringHandle;
	}

	public TwoVehicle() {
		super();
	}

}
