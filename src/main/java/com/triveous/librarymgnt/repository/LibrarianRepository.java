package com.triveous.librarymgnt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

	@Query("SELECT c FROM Librarian c WHERE c.librarianId = :librarianId")
	public Optional<Librarian> findById(Long librarianId);
}
