package com.triveous.librarymgnt.modal;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookLoan { 
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "librarian_id", nullable = false)
    private Librarian librarian;
    
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book; 
    
    @Column(nullable = false)
    private LocalDate loanDate;
    
    @Column(nullable = false)
    private Boolean returned;

	public BookLoan() {
		super();
	}

	public BookLoan(Long loanId, Student student, Librarian librarian, Book book, LocalDate loanDate, Boolean returned) {
		super();
		this.loanId = loanId;
		this.student = student;
		this.librarian = librarian;
		this.book = book;
		this.loanDate = loanDate;
		this.returned = returned;
	}

	

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public Boolean getReturned() {
		return returned;
	}

	public void setReturned(Boolean returned) {
		this.returned = returned;
	}

	@Override
	public String toString() {
		return "BookLoan [loanId=" + loanId + ", student=" + student + ", librarian=" + librarian + ", book=" + book
				+ ", loanDate=" + loanDate + ", returned=" + returned + "]";
	}
    
}
