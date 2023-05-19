package com.triveous.librarymgnt.modal;

import java.util.Stack;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Book {
	
	@Id
	int id;
	String name ;
	
	public static void main(String[] args) {
		Stack<Integer> stack  = new Stack<>();
		
	}
	
}
