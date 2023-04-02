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
		LOG.info("Start");
		SpringApplication.run(LibraryMangementApplication.class, args);
		LOG.info("Stop");
	}

	//demo API for testing
	@GetMapping("/")
	public String hello() {
		return "Hello Sridhar";
	}

}

//Swagger UI check
//http://localhost:8082/swagger-ui/index.html#


//pending tasks
//Exceptions
//ResposiveEntity and Headers
