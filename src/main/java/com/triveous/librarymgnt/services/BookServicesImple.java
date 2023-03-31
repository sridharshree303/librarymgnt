package com.triveous.librarymgnt.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.repository.BookRepository;
import com.triveous.librarymgnt.repository.LibraryRepository;

@Service
public class BookServicesImple implements BookServices {

	private static final Logger LOG = LoggerFactory.getLogger(BookServicesImple.class);
	
	@Autowired
	private BookRepository bookrepository;
	
	
	@Override
	public Book saveBook(Book book) {
		LOG.info("Book service - saving book");
		Book data = bookrepository.save(book);
		LOG.info("Book service - saved book");
		return data;
	}

	@Override
	public List<Book> listAllBooks() {
		LOG.info("Book service - requesting booklist");
		List<Book> list = new ArrayList<>();
		list = bookrepository.findAll();
		LOG.info("Book service - returning booklist");
		return list;
	}

}
