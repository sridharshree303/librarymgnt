package com.triveous.librarymgnt.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.librarymgnt.exception.BookLoanInterruptedException;
import com.triveous.librarymgnt.modal.Book;
import com.triveous.librarymgnt.modal.BookLoan;
import com.triveous.librarymgnt.modal.Librarian;
import com.triveous.librarymgnt.modal.Student;
import com.triveous.librarymgnt.repository.BookRepository;
import com.triveous.librarymgnt.repository.BooksLoanRepository;
import com.triveous.librarymgnt.repository.LibrarianRepository;
import com.triveous.librarymgnt.repository.StudentRepository;

@Service
public class BookLoanServicesImple implements BookLoanServices {
	
	private static final Logger LOG = LoggerFactory.getLogger(BookLoanServicesImple.class);
	
	@Autowired
	private BooksLoanRepository bookloanrepository;
	
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private StudentRepository studentrepository;
	
	@Autowired
	private LibrarianRepository librarianrepository;
	
	@Override
	public  boolean checkBookAvailability(String name) {
		//find the book and quantity
		LOG.info("BookLoan Services - check quantity available");
		Book b = bookrepository.findByTitle(name);
		if(b.getQuantity() > 0) {
			LOG.info("BookLoan Services - Book available in the library");
			return true;
		}else {
			LOG.info("BookLoan Services - Book Not available in the library");
			return false;
		}
	}
	
	@Override
	public BookLoan takeBook(String bookName,long studentId,long librarianId) 
			throws BookLoanInterruptedException {
		
		LOG.info("BookLoan Services - taking book from library");
		
		//create a BookLoan object
		BookLoan bloan = new BookLoan();
		//check input from the parameters are valid or not
		//check book and book quantity
		Book b = bookrepository.findByTitle(bookName);
		boolean book = b == null ? false : true;
		
		//check student id is valid or not
		Optional<Student> s = studentrepository.findById((long)studentId);
		
		
		Student st = s.isEmpty() ? null : s.get();
		boolean student = st == null ? false : true;
		
		//check Librarian id is valid or not
		Optional<Librarian> l = librarianrepository.findById((long)librarianId);
		Librarian lb = l.isEmpty()? null : l.get();
		boolean librarian = lb == null ? false : true;
		
		LOG.info("validating inputs");
		if(book && student && librarian) {
			
			//compare the book quantity
			int bookQuantity = b.getQuantity();
			
			if(bookQuantity > 0) {
				//reduce quantity by 1
				b.setQuantity(bookQuantity-1);
				bookrepository.save(b);
				
				//set object parameters
				bloan.setStudent(st);;
				bloan.setLibrarian(lb);
				bloan.setReturned(false);
				bloan.setBook(b);
				bloan.setLoanDate(LocalDate.now());
				
				BookLoan res = bookloanrepository.save(bloan);
				LOG.info("BookLoan Services - took book from library");
				return res;

			}
		}else {
			LOG.info("Book loan Trasaction failed");
			throw new BookLoanInterruptedException("Book loan trasaction failed");
		}
		return bloan;
	}

	@Override
	public List<BookLoan> listOfTransactions() {
		LOG.info("BookLoan Services - requested library transactions");
		List<BookLoan> list = bookloanrepository.findAll();
		LOG.info("BookLoan Services - returned the library transactions");
		return list;
	} 
}
