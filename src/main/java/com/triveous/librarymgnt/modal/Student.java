package com.triveous.librarymgnt.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false)
    private String sname;
    
    
	public Student() {
		super();
	}


	public Student(Long studentId, String sname) {
		super();
		this.studentId = studentId;
		this.sname = sname;
	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sname=" + sname + "]";
	}
    
}
