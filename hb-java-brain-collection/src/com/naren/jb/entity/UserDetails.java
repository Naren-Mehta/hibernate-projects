package com.naren.jb.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "home_street")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state")),
			@AttributeOverride(name = "country", column = @Column(name = "home_country")) })
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "office_street")),
		@AttributeOverride(name = "city", column = @Column(name = "office_city")),
		@AttributeOverride(name = "state", column = @Column(name = "office_state")),
		@AttributeOverride(name = "country", column = @Column(name = "office_country")) })
	private Address officeAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public UserDetails() {
		super();
	}

	public UserDetails(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

}
