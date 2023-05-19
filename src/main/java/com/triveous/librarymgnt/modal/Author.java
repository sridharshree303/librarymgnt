package com.triveous.librarymgnt.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorId;

	@Column(nullable = false)
	private String name;


	//Default constructor
	public Author() {
		super();
	}
	
	//Parameterized constructor
	public Author(Long authorId, String name) {
		super();
		this.authorId = authorId;
		this.name = name;
	}

	//Getters and Setters
	public Long getId() {
		return authorId;
	}

	public void setId(Long authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Author [id=" + authorId + ", name=" + name + "]";
	}
	
}
