package gr.pr.udemy.rest.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestControllerDemo {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!!";
	}

}
