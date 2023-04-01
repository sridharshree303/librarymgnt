package com.triveous.librarymgnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.Author;

@Repository
public interface Authorrepository extends JpaRepository<Author, Integer> {
	
	public Author findByName(String sname);

}
 