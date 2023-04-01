package com.triveous.librarymgnt.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.repository.BooksLoanRepository;

@Service
public class BookLoanServicesImple implements BookLoanServices {
	
	private static final Logger LOG = LoggerFactory.getLogger(BookLoanServicesImple.class);
	
	@Autowired
	private BooksLoanRepository bookloanrepo;

	@Override
	public BookLoan takeBook(String bookName) {
		BookLoan book = new BookLoan();
		LOG.info("BookLoan Services - taking book from library");
		BookLoan res = bookloanrepo.save(book);
		LOG.info("BookLoan Services - took book from library");
		return res;
	}

	@Override
	public List<BookLoan> listOfTransactions() {
		LOG.info("BookLoan Services - requested library transactions");
		List<BookLoan> list = bookloanrepo.findAll();
		LOG.info("BookLoan Services - returned the library transactions");
		return list;
	}
}
