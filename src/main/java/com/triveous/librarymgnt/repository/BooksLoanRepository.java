package com.triveous.librarymgnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.BookLoan;

@Repository
public interface BooksLoanRepository extends JpaRepository<BookLoan, Long> {
	
}
