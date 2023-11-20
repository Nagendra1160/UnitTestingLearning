package com.nagendra.UnitTesting.HWController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class UnitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

	@RestController
	public static class HelloWorldController {

		@GetMapping("/Hello-World")
		public String helloWorld()
		{
			return "Hello World";
		}
	}
}
