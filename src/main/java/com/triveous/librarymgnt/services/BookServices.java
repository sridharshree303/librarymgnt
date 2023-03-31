package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.modal.Book;

public interface BookServices {
	
	public Book saveBook(Book book);
	
	public List<Book> listAllBooks();

}
