package com.triveous.librarymgnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.librarymgnt.modal.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
