package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.exception.BookLoanInterruptedException;
import com.triveous.librarymgnt.modal.BookLoan;

public interface BookLoanServices {
	
	public BookLoan takeBook(String bookName,long studentId,long librarianId) throws  BookLoanInterruptedException;
	
	public List<BookLoan> listOfTransactions();

	public boolean checkBookAvailability(String name);
}
