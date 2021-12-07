package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table( name = "roles")
public class Rol implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String rolName;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRolName() {
		return rolName;
	}


	public void setRolName(String rolName) {
		this.rolName = rolName;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
