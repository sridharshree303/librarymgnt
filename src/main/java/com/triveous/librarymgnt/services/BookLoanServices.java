package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.modal.BookLoan;

public interface BookLoanServices {
	
	public BookLoan takeBook(String bookName);
	
	public List<BookLoan> listOfTransactions();
}
