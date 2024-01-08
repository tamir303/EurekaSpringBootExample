package com.example.demo;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookClientApplication {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@RequestMapping("/greeting")
	public String greeting() {
		return String.format(
				"Hello from '%s'!", eurekaClient.getApplicationInfoManager().getInfo().getAppName());
	}

	public static void main(String[] args) {
		SpringApplication.run(BookClientApplication.class, args);
	}

}
