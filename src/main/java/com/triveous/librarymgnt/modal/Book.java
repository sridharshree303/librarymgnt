package com.triveous.librarymgnt.modal;

import java.util.Stack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;

	@Column(nullable = false)
	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Author> authors = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;

	@Column(nullable = false)
	private Integer quantity; 

	//default constructor
	public Book() {
		super();
	}

	//parameterized constructor
	public Book(Long bookId, String title, List<Author> authors, Library library, Integer quantity) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authors = authors;
		this.library = library;
		this.quantity = quantity;
	
	}

	//getters and setters
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authors=" + authors + ", library=" + library
				+ ", quantity=" + quantity + "]";
	}

}
