package com.triveous.librarymgnt.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.Author;
import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.repository.Authorrepository;
import com.triveous.librarymgnt.repository.BookRepository;

@Service
public class AuthorServicesImple implements AuthorServices {

	private static final Logger LOG = LoggerFactory.getLogger(AuthorServicesImple.class);
	
	@Autowired
	private Authorrepository authorrepository;
	
	@Autowired
	private BookRepository bookrepository;
	
	@Override
	public Author saveAuthor(Author author) {
		LOG.info("author service - saving data");
		Author data = authorrepository.save(author);
		LOG.info("author service - saved data");
		return data;
	}

	@Override
	public List<Author> viewAuthors() {
		LOG.info("author service - list reuqesting");
		List<Author> list = new ArrayList<>();
		list = authorrepository.findAll();
		LOG.info("author service - list returned");
		return list;
	}

	
	@Override
	public List<Book> viewBooks(String name) {
		Author auth = authorrepository.findByName(name);
		LOG.info(auth.toString());
		List<Book> list = bookrepository.findAll();
		List<Book> res = new ArrayList<>();
		for(Book b : list) {
			if(b.getAuthors().contains(auth)) {
				res.add(b);
			}
		}
		return res;
	}
}
