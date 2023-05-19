package com.triveous.librarymgnt.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lid;

	//default constructor 
	public Library() {
		super();
	}

	//parameterized constructor
	public Library(long lid) {
		super();
		this.lid = lid;
	}

	//getters and setters
	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
	}

}
