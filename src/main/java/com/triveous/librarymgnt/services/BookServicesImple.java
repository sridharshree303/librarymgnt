package com.triveous.librarymgnt.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.exception.AuthorNotFoundException;
import com.triveous.librarymgnt.exception.BookInputMismatchException;
import com.triveous.librarymgnt.modal.Author;
import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.Library;
import com.triveous.librarymgnt.repository.Authorrepository;
import com.triveous.librarymgnt.repository.BookRepository;
import com.triveous.librarymgnt.repository.LibraryRepository;

@Service
public class BookServicesImple implements BookServices {

	private static final Logger LOG = LoggerFactory.getLogger(BookServicesImple.class);
	
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private Authorrepository authrepository;
	
	@Autowired
	private LibraryRepository libraryrepository;
	
	@Override
	public Book saveBook(Book book) throws  BookInputMismatchException {
		
		LOG.info("Book service - saving book");
		
		//check authors are valid or not
		List<Author> authors = book.getAuthors();
		boolean authorsStatus = false;
		for(Author auth : authors) {
			Author temp = authrepository.findById(auth.getId());
			if(temp != null) {
				authorsStatus = true;
			}else {
				authorsStatus = false;
			}
		}
		
		//library id is valid or not
		boolean libraryStatus = false;
		Library lib = book.getLibrary();
		Library temp = libraryrepository.findByLid(lib.getLid());
		if(temp != null) {
			libraryStatus = true;
		}
		
		//System.out.println(libraryStatus +"--"+authorsStatus);

		if(libraryStatus && authorsStatus) {
			LOG.info("Book service - saved book");
			return  bookrepository.save(book);
		}else {
			LOG.info("Input mismatched - failed to save book");
			throw new BookInputMismatchException("Book Input mismatched");
		}
	}

	@Override
	public List<Book> listAllBooks() {
		LOG.info("Book service - requesting booklist");
		List<Book> list = new ArrayList<>();
		list = bookrepository.findAll();
		LOG.info("Book service - returning booklist");
		return list;
	}

	@Override
	public Book viewBook(String name) {
		LOG.info("Book service - requesting Book Object");
		Book book = bookrepository.findByTitle(name);
		LOG.info("Book service - returned Book object");
		return book;
	}

}
