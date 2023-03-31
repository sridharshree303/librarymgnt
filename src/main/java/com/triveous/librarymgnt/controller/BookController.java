package com.triveous.librarymgnt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.services.BookServices;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookServices bookServices;
	
	@PostMapping("/save")
	@ResponseBody
	public Book saveBook(@RequestBody Book book) {
		LOG.info("Book controller - saving book");
		Book data = bookServices.saveBook(book);
		LOG.info("Book controller - returning book");
		return data;
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<Book> getAllBooks(){
		LOG.info("Book controller - requesting List");
		List<Book> list = bookServices.listAllBooks();
		LOG.info("Book controller - returning List");
		return list;
	}
	
	@GetMapping("/list/{title}")
	@ResponseBody
	public Book viewBook(@PathVariable String title) {
		LOG.info("Book controller - requesting book object");
		Book book = bookServices.viewBook(title);
		LOG.info("Book controller - returned book object");
		return book;
	}
}
