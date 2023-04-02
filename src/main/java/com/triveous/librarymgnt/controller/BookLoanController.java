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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.librarymgnt.exception.BookLoanInterruptedException;
import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.services.BookLoanServices;

@RestController
@RequestMapping("/bookloan/")
public class BookLoanController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BookLoanController.class);
	
	@Autowired
	private BookLoanServices bookloanservices;
	
	@GetMapping("/check/{bookname}")
	public ResponseEntity<Boolean> checkBookAvailability(@PathVariable String bookname) {
		LOG.info("Book Loan Controller - checking book availabilty");
		boolean res = bookloanservices.checkBookAvailability(bookname);
		LOG.info("Book Loan Controller - returned book availabilty");
		HttpHeaders headers = new HttpHeaders();
		if(res) headers.add("message","book is available");
		else headers.add("message","book is not available");
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(res,headers,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/loan/{bookName}/{studentId}/{librarianId}")
	public ResponseEntity<BookLoan> takeBook(@PathVariable String bookName, @PathVariable Long studentId, @PathVariable Long librarianId)
			throws BookLoanInterruptedException {
		LOG.info("Book Loan Controller - taking book from library");
		BookLoan res = bookloanservices.takeBook(bookName,studentId,librarianId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Book loan input mismatch");
		LOG.info("Book Loan Controller - returned the loan trasactions");
		ResponseEntity<BookLoan> response = new ResponseEntity<BookLoan>(res,headers,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/list_transactions")
	public ResponseEntity<List<BookLoan>> listOfTrasactions(){
		LOG.info("Book Loan Controller - requesting book loans transactions");
		List<BookLoan> list = bookloanservices.listOfTransactions();
		LOG.info("Book Loan Controller - returned Book loans transactions");
		HttpHeaders headers = new HttpHeaders();
		headers.add("messgae", "list of book loans ");
		ResponseEntity<List<BookLoan>> response = new ResponseEntity<List<BookLoan>>(list,headers,HttpStatus.OK);
		return response;
	}
}
