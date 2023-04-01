package com.triveous.librarymgnt.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.modal.Librarian;
import com.triveous.librarymgnt.repository.LibrarianRepository;

@Service
public class LibrarianServicesImple implements LibrarianServices {
	
	private static final Logger LOG = LoggerFactory.getLogger(LibrarianServicesImple.class);
	
	@Autowired
	private LibrarianRepository librarianrepo;

	@Override
	public Librarian register(Librarian librarian) {
		LOG.info("Librarian service - saving librarain");
		Librarian lib = librarianrepo.save(librarian);
		LOG.info("Librarian service - saved librarain");
		return lib;
	}

	@Override
	public List<Librarian> listAll() {
		LOG.info("Librarian service - requesting librarain list");
		List<Librarian> list = librarianrepo.findAll();
		LOG.info("Librarian service - returned librarain list");
		return list;
	}

}
