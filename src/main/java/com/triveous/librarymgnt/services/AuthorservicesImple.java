package com.triveous.librarymgnt.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.Author;
import com.triveous.librarymgnt.repository.Authorrepository;

@Service
public class AuthorservicesImple implements Authorservices {

	private static final Logger LOG = LoggerFactory.getLogger(AuthorservicesImple.class);
	
	@Autowired
	private Authorrepository authorrepository;
	
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

}
