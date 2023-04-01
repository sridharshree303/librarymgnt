package com.triveous.librarymgnt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.services.BookLoanServices;

@RestController
@RequestMapping("/bookloan/")
public class BookLoanController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BookLoanController.class);
	
	@Autowired
	private BookLoanServices bookloanservices;
	
	@GetMapping("/loan/{bookName}")
	@ResponseBody
	public BookLoan takeBook(@PathVariable String bookName) {
		LOG.info("Book Loan Controller - taking book from library");
		BookLoan res = bookloanservices.takeBook(bookName);
		LOG.info("Book Loan Controller - returned the loan trasactions");
		return res;
	}
	
	
	@GetMapping("/list_transactions")
	@ResponseBody
	public List<BookLoan> listOfTrasactions(){
		LOG.info("Book Loan Controller - requesting book loans transactions");
		List<BookLoan> list = bookloanservices.listOfTransactions();
		LOG.info("Book Loan Controller - returned Book loans transactions");
		return list;
	}
}
