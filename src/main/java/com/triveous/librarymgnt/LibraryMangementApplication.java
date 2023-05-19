package com.triveous.librarymgnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LibraryMangementApplication {
	
	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(LibraryMangementApplication.class, args);
		System.out.println("End");
	}
	
	@GetMapping("/")
	public String hello() {
		return "Hello Sridhar";
	}

}
