package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.exception.BookInputMismatchException;
import com.triveous.librarymgnt.exception.BookNotFoundException;
import com.triveous.librarymgnt.modal.Book;

public interface BookServices {
	
	public Book saveBook(Book book) throws BookInputMismatchException;
	
	public List<Book> listAllBooks();
	
	public Book viewBook(String name) throws BookNotFoundException ;

}
