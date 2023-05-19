package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.exception.AuthorNotFoundException;
import com.triveous.librarymgnt.modal.Author;
import com.triveous.librarymgnt.modal.Book;

public interface AuthorServices {
	
	public Author saveAuthor(Author author);
	
	//list of authors
	public List<Author> viewAuthors();
	
	//list of books - filter by author
	public List<Book> viewBooks(String name) throws AuthorNotFoundException;

}
