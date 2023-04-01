package com.triveous.librarymgnt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("SELECT c from Student c WHERE c.studentId = :studentId")
	public Optional<Student> findById(Long studentId);
}
