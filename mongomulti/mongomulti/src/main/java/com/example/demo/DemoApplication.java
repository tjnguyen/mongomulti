package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemoApplication {
	
	public static void main(String[] args) {
		
		System.out.println(" thu demo");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	
         

}
