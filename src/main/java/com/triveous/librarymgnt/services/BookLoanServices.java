package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.exception.BookLoanInterruptedException;
import com.triveous.librarymgnt.modal.BookLoan;

public interface BookLoanServices {
	
	//borrow a book from library
	public BookLoan takeBook(String bookName,long studentId,long librarianId) throws  BookLoanInterruptedException;
	
	//total list of book loans
	public List<BookLoan> listOfTransactions();

	//check book availability
	public boolean checkBookAvailability(String name);
}
