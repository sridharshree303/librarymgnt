package com.triveous.librarymgnt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.modal.Librarian;
import com.triveous.librarymgnt.services.LibrarianServices;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LibrarianController.class);
	
	@Autowired
	private LibrarianServices librarianservices;
	
	@PostMapping("/save")
	@ResponseBody
	public Librarian register(@RequestBody Librarian librarian) {
		LOG.info("Librarian controller - saving librarian");
		Librarian lib = librarianservices.register(librarian);
		LOG.info("Librarian controller - saved librarian");
		return lib;
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<Librarian> listOfLibrarians(){
		LOG.info("Librarian controller - Requesting librarian list");
		List<Librarian> list =  librarianservices.listAll();
		LOG.info("Librarian controller - Requesting librarian list");
		return list;
	}
	
}
