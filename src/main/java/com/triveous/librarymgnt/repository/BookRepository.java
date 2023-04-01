package com.triveous.librarymgnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	 public Book findByTitle(String title);
	 
	 @Query("SELECT b FROM Book b WHERE b.library.lid = :libraryId")
	 public List<Book> findByLibraryId(long libraryId); 
}
 