package com.triveous.librarymgnt.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.Library;
import com.triveous.librarymgnt.repository.BookRepository;
import com.triveous.librarymgnt.repository.LibraryRepository;

@Service
public class LibraryServiceImple implements LibraryService{

	private static final Logger LOG = LoggerFactory.getLogger(LibraryServiceImple.class);
	
	@Autowired
	private LibraryRepository libraryrepository;
	
	@Autowired
	private BookRepository bookrepository;
	
	@Override
	public Library save(Library library) {
		LOG.info("Library services - library created");
		return libraryrepository.save(library);
	}

	@Override
	public List<Book> listBooks() {
		LOG.info("Library services - reqeusted list");
		List<Book> list = bookrepository.findByLibraryId(1);
		LOG.info("Library services - returned list");
		LOG.info(list.toString());
		return list;
	}
	
}
