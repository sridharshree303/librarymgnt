package com.triveous.librarymgnt.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.Library;
import com.triveous.librarymgnt.repository.LibraryRepository;

@Service
public class LibraryServiceImple implements LibraryService{

	private static final Logger LOG = LoggerFactory.getLogger(LibraryServiceImple.class);
	
	@Autowired
	private LibraryRepository libraryrepository;
	
	@Override
	public Library save(Library library) {
		LOG.info("Library services - library created");
		return libraryrepository.save(library);
	}
	
}
