package com.triveous.librarymgnt.modal;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lid;
	
	@OneToMany
	private List<Book> books;

	//default constructor 
	public Library() {
		super();
	}

	public Library(long lid, List<Book> books) {
		super();
		this.lid = lid;
		this.books = books;
	}

	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
