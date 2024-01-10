package com.example.demo;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CustomerClientApplication {
	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "orderBooks/{count}", produces = "application/json")
	public BookBoundary[] listOfBooks(@PathVariable("count") int count) {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("BOOK-CLIENT", false);
		String baseUrl = instance.getHomePageUrl();

		String booksEndpoint = baseUrl + "books/" + count;
		ResponseEntity<BookBoundary[]> response = restTemplate.getForEntity(booksEndpoint, BookBoundary[].class);

		System.err.println(response.toString());

		return response.getBody();
	}


	public static void main(String[] args) {
		SpringApplication.run(CustomerClientApplication.class, args);
	}

}
