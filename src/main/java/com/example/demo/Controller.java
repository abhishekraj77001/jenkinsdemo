package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/")
public class Controller {

	@GetMapping("health")
	public String healthCheck()
	{
		return "Application is up and running...!!";
	}
}

