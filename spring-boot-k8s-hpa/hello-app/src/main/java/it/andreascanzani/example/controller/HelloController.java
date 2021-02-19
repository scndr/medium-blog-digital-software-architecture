package it.andreascanzani.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/sayHello")
	public String sayHello() {
		
		double x = 1d;
		for(int i = 0 ; i < 1000000 ; i++) {
			// some logic to consume more cpu
			x += Math.sqrt(x);
		}
		
		return "Hello!";
	}

}
