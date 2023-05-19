package com.triveous.librarymgnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.BookLoan;

@Repository
public interface BooksLoanRepository extends JpaRepository<BookLoan, Long> {
	
	//find student book loans by name or StudentID
	@Query("SELECT c from BookLoan c WHERE c.student.studentId = :studentId")
	public List<BookLoan> booksTookByStudent(Long studentId);
	
	//find librarian book issues name or librarianId
	@Query("SELECT c from BookLoan c WHERE c.librarian.librarianId = :librarianId")
	public List<BookLoan> booksIssuedByLibrarian(Long librarianId);
}
