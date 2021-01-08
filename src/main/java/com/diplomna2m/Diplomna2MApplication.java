package com.diplomna2m;

import javax.annotation.security.RolesAllowed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Diplomna2MApplication {
	
	@RolesAllowed("*")
	public static void main(String[] args) {
		SpringApplication.run(Diplomna2MApplication.class, args);
	}
	
}
