package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@SpringBootApplication
@RestController
public class CustomerClientApplication {
	private RestClient restClient;
	private String bookUrl;

	@Value("${remote.book.url: http://BOOK-CLIENT/books}")
	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
		this.restClient = RestClient.create(bookUrl);
	}

	@GetMapping(path = "takebooks/{count}",
				produces = "application/json")
	public BookBoundary[] listOfBooks(@PathVariable("count") int count) {
		return this.restClient
				.get()
				.uri("/{count}", count)
				.retrieve()
				.body(BookBoundary[].class);
	}


	public static void main(String[] args) {
		SpringApplication.run(CustomerClientApplication.class, args);
	}

}
