package com.triveous.librarymgnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
	
	public Library findByLid(long lid);
}
