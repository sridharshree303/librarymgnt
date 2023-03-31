package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.modal.Author;

public interface AuthorServices {
	
	public Author saveAuthor(Author author);
	
	public List<Author> viewAuthors();
}
