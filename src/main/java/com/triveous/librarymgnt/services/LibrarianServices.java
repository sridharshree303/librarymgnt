package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.exception.LibraryNotFoundException;
import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.modal.Librarian;

public interface LibrarianServices {
	
	public Librarian register(Librarian librarian) throws LibraryNotFoundException;
	
	public List<Librarian> listAll();
	
	public List<BookLoan> listOfIssuedBooks(Long librarianId);
}
