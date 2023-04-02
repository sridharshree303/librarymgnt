package com.triveous.librarymgnt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.exception.LibraryNotFoundException;
import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.modal.Librarian;
import com.triveous.librarymgnt.services.LibrarianServices;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LibrarianController.class);
	
	@Autowired
	private LibrarianServices librarianservices;
	
	@PostMapping("/save")
	public ResponseEntity<Librarian> register(@RequestBody Librarian librarian) throws LibraryNotFoundException {
		LOG.info("Librarian controller - saving librarian");
		Librarian lib = librarianservices.register(librarian);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Librarian details saved");
		ResponseEntity<Librarian> response = new ResponseEntity<Librarian>(lib,headers,HttpStatus.OK);
		LOG.info("Librarian controller - saved librarian");
		return response;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Librarian>> listOfLibrarians(){
		LOG.info("Librarian controller - Requesting librarian list");
		List<Librarian> list =  librarianservices.listAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "list of librarians");
		LOG.info("Librarian controller - Requesting librarian list");
		return new ResponseEntity<List<Librarian>>(list,headers,HttpStatus.OK);
	}
	
	@GetMapping("/list/{librarianId}")
	public ResponseEntity<List<BookLoan>> issuedListByLibrarianId(@PathVariable long librarianId){
		LOG.info("Librarian controller - Requesting librarian list");
		List<BookLoan> list = librarianservices.listOfIssuedBooks(librarianId);
		LOG.info("Librarian controller - returned librarian list");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","list of book loans given librarian");
		return new ResponseEntity<List<BookLoan>>(list,headers,HttpStatus.OK);
	}
	
}
