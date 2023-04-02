package com.triveous.librarymgnt.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.exception.LibraryNotFoundException;
import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.modal.Librarian;
import com.triveous.librarymgnt.modal.Library;
import com.triveous.librarymgnt.repository.BooksLoanRepository;
import com.triveous.librarymgnt.repository.LibrarianRepository;
import com.triveous.librarymgnt.repository.LibraryRepository;

@Service
public class LibrarianServicesImple implements LibrarianServices {
	
	private static final Logger LOG = LoggerFactory.getLogger(LibrarianServicesImple.class);
	
	@Autowired
	private LibrarianRepository librarianrepo;
	
	@Autowired
	private BooksLoanRepository bookloanrepository;
	
	@Autowired
	private LibraryRepository libraryrepository;

	@Override
	public Librarian register(Librarian librarian) throws LibraryNotFoundException {
		LOG.info("Librarian service - saving librarain");
		
		//checking library valid or not
		boolean libraryStatus = false;
		Library lib = librarian.getLibrary();
		Library temp = libraryrepository.findByLid(lib.getLid());
		
		if(temp != null) {
			libraryStatus = true;
		}
		
		if(libraryStatus) {
			LOG.info("Librarian service - saved librarain");
			return librarianrepo.save(librarian);
		}else {
			LOG.info("Library Not Found - provide a valid LibraryId");
			throw new LibraryNotFoundException("Library Not Found");
		}
	}

	@Override
	public List<Librarian> listAll() {
		LOG.info("Librarian service - requesting librarain list");
		List<Librarian> list = librarianrepo.findAll();
		LOG.info("Librarian service - returned librarain list");
		return list;
	}

	@Override
	public List<BookLoan> listOfIssuedBooks(Long librarianId) {
		LOG.info("Librarian service - requesting issued list by librarainId");
		List<BookLoan> list = bookloanrepository.booksIssuedByLibrarian(librarianId);
		LOG.info("Librarian service - returned issued list by librarainId");
		return list;
	}

}
