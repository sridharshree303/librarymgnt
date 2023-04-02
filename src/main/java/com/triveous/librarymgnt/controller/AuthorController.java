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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.exception.AuthorNotFoundException;
import com.triveous.librarymgnt.modal.Author;
import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.services.AuthorServices;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthorController.class);

	@Autowired
	private AuthorServices authorservices;
	
	@PostMapping("/save")
	public Author saveAuthor(@RequestBody Author author) {
		LOG.info("author controller - saving author");
		Author data = authorservices.saveAuthor(author);
		LOG.info("author controller - returned author");
		return data;
	}
	
	@GetMapping("/list")
	public List<Author> getAllAuthors(){
		LOG.info("author controller - requested list");
		List<Author> list = authorservices.viewAuthors();
		LOG.info("author controller - returend list");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		return list;
	}
	 
	@GetMapping("/list/{name}")
	public ResponseEntity<List<Book>> searchByName(@PathVariable String name) throws AuthorNotFoundException{
		LOG.info("author controller - requested author book list");
		List<Book> list = authorservices.viewBooks(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","listed books");
		LOG.info("author controller - returned author book list");
		ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>(list,headers,HttpStatus.OK);
		return response;
	}
}
