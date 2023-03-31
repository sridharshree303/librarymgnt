package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.modal.Author;
import com.triveous.librarymgnt.modal.Book;

public interface AuthorServices {
	
	public Author saveAuthor(Author author);
	
	public List<Author> viewAuthors();
	
	public List<Book> viewBooks(String name);

}
