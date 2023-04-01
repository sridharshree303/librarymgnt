package com.triveous.librarymgnt.services;

import java.util.List;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.Library;

public interface LibraryService {

	public Library save(Library library);
	
	public List<Book> listBooks();
}
