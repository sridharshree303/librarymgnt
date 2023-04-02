package com.triveous.librarymgnt.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public BookLoan takeBook(String bookName,long studentId,long librarianId) {
		//find the book 
			//if(book.quantity > 0)
		    //   //logic
			//   // book available and book ID
		    //else{
		    //   //return null; 
		    //}
		//Select a studentId
		//Select a librarianID
		
		LOG.info("BookLoan Services - taking book from library");
		
		//create a BookLoan object
		BookLoan bloan = new BookLoan();
		
		//find the book
		Book b = bookrepository.findByTitle(bookName);
		Optional<Student> s = studentrepository.findById((long)studentId);
		Student st = s.get();
		Optional<Librarian> l = librarianrepository.findById((long)librarianId);
		Librarian lb = l.get();
		
		//LOG.info(b.toString());
		//LOG.info(st.toString());
		//LOG.info(lb.toString());
		
		//find and compare the book quantity
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
			
			LOG.info(bloan.toString());
			BookLoan res = bookloanrepository.save(bloan);
			LOG.info("BookLoan Services - took book from library");
			return res;
			
		}else {
			LOG.info("Book is not Available in the library");
			return null;
		}
	}

	@Override
	public List<BookLoan> listOfTransactions() {
		LOG.info("BookLoan Services - requested library transactions");
		List<BookLoan> list = bookloanrepository.findAll();
		LOG.info("BookLoan Services - returned the library transactions");
		return list;
	} 
}
