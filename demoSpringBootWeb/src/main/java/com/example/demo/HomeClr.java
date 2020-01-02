package com.example.demo;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class HomeClr {

	@RequestMapping("/")
	String home() {
		return "my first spring project!";
	}
	
//	public static void main(String[] args) {
//		SpringApplication.run(HomeClr.class, args);
//	}
	@RequestMapping("/greet")
	String greets() {
		return "i like ,my first spring project!";
	}
	
}
