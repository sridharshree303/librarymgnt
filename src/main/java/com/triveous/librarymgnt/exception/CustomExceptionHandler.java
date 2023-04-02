package com.triveous.librarymgnt.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<Object> handleAuthorNotFoundException(){
		LOG.error("handleAuthorNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		String msg = "Author Not Found in DataBase";
		headers.add("message", "Author Not Found");
		return new ResponseEntity<Object>(msg,headers,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookInputMismatchException.class)
	public ResponseEntity<Object> handleBookInputMismatchException(){
		LOG.error("handleBookInputMismatchException");
		HttpHeaders headers = new HttpHeaders();
		String msg = "Book Input mismatched - Enter correct input";
		headers.add("message", "Enter correct input");
		return new ResponseEntity<Object>(msg,headers,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFoundException(){
		LOG.error("handleBookNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		String msg = "Book Not Found";
		headers.add("message","Book Not Found");
		return new ResponseEntity<Object>(msg,headers,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LibraryNotFoundException.class)
	public ResponseEntity<Object> handleLibraryNotFoundException(){
		LOG.error("handleLibraryNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		String msg = "Library Not Found";
		headers.add("message","Library Not Found");
		return new ResponseEntity<Object>(msg,headers,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookLoanInterruptedException.class)
	public ResponseEntity<Object> handleBookLoanInterruptedException(){
		LOG.error("handleBookLoanInterruptedException");
		HttpHeaders headers = new HttpHeaders();
		String msg = "Book loan input mismatched";
		headers.add("message","Book loan input mismatched");
		return new ResponseEntity<Object>(msg,headers,HttpStatus.NOT_FOUND);
	}

}
