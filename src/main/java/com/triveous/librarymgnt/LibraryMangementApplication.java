package com.triveous.librarymgnt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LibraryMangementApplication {
    private static final Logger LOG = LoggerFactory.getLogger(LibraryMangementApplication.class);
    
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

//Swagger UI check
//http://localhost:8082/swagger-ui/index.html#


//pending
//book quantity should be manipulated
//Exceptions
//ResposiveEntity and Headers
