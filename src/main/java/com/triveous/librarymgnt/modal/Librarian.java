package com.triveous.librarymgnt.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Librarian{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long librarianId;
	
	@Column(nullable = false)
    private String name;
	
	@ManyToOne
	@JoinColumn(name = "library_lid")
	private Library library;

	//default constructor
	public Librarian() {
		super();
	}

	//parameterized constructor
	public Librarian(Long librarianId, String name, Library library) {
		super();
		this.librarianId = librarianId;
		this.name = name;
		this.library = library;
	}

	//getters and setters
	public Long getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(Long librarianId) {
		this.librarianId = librarianId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Librarian [librarianId=" + librarianId + ", name=" + name + ", library=" + library + "]";
	}
	
}
