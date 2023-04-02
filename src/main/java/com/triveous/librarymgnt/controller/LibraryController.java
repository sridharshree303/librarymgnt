package com.triveous.librarymgnt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.Library;
import com.triveous.librarymgnt.services.LibraryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LibraryController.class);
	
	@Autowired
	private LibraryService libraryservice;	

	
	@PostMapping("/save")
	public Library saveLibrary(@RequestBody Library library) {
		LOG.info("Library controller - saving library");
		Library lib = libraryservice.save(library);
		LOG.info("Library controller - saved library");
		return lib;
	}
	
	@GetMapping("/books")
	public List<Book> listOfBooks(){
		LOG.info("Book controller - requesting library");
		List<Book> list = libraryservice.listBooks();
		LOG.info("Book controller - returned list");
		return list;
	}
}
