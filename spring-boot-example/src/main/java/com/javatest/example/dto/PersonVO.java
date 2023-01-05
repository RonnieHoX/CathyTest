package com.javatest.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person") // 引入@Table註解，name賦值為表名
public class PersonVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PersonID", nullable = false)
	private Long id;
	private String lastname;
	private String firstname;
	private String address;
	private String city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "person{" + "LastName='" + lastname + '\'' + ", FirstName='" + firstname + '\'' + ", Address='" + address
				+ '\'' + ", City='" + city + '\'' + '}';
	}

}
