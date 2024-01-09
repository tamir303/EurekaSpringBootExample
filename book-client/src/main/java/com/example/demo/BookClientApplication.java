package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
@RestController
public class BookClientApplication {

	@RequestMapping(
			path = "/books/{count}"
			, produces = "application/json")
	public BookBoundary[] getBooks(@PathVariable("count") int count) {
		return IntStream.range(0, count)
				.mapToObj(BookBoundary::new)
				.toArray(BookBoundary[]::new);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookClientApplication.class, args);
	}

}
