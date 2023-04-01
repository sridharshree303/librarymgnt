package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.modal.Librarian;

public interface LibrarianServices {
	
	public Librarian register(Librarian librarian);
	
	public List<Librarian> listAll();
	
	public List<BookLoan> listOfIssuedBooks(Long librarianId);
}
