package com.fag.booksFag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksFagApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BooksFagApplication.class);
		app.run(args);
	}

}
