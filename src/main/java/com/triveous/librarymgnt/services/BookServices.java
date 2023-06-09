package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.exception.BookInputMismatchException;
import com.triveous.librarymgnt.exception.BookNotFoundException;
import com.triveous.librarymgnt.modal.Book;

public interface BookServices {
	
	//save a book
	public Book saveBook(Book book) throws BookInputMismatchException;
	
	//list of books
	public List<Book> listAllBooks();
	
	//view book by book name
	public Book viewBook(String name) throws BookNotFoundException ;

}
