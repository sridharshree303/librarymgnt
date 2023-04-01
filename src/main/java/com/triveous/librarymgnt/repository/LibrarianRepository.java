package com.triveous.librarymgnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

}
