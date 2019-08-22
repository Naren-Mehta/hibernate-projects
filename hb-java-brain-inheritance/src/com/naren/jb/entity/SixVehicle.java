package com.naren.jb.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BUS")

public class SixVehicle extends Vehicle {

	private String steringHandle;

	public String getSteringHandle() {
		return steringHandle;
	}

	public void setSteringHandle(String steringHandle) {
		this.steringHandle = steringHandle;
	}

	public SixVehicle(String steringHandle) {
		super();
		this.steringHandle = steringHandle;
	}

	public SixVehicle() {
		super();
	}

}
