package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( nullable = false )
	private String name;
	
	@Column( nullable = false )
	private String surName;
	
	@Column( nullable = false, unique = true )
	private String dni;
	
	@Column( nullable = false, unique = true )
	private String email;
	
	private int phoneNumber;
	
	private String address;
	
	private int postalCode;
	
	private String image;
	
		
	





	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getSurName() {
		return surName;
	}




	public void setSurName(String surName) {
		this.surName = surName;
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public int getPostalCode() {
		return postalCode;
	}




	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
