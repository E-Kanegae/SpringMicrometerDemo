package com.example.ek.prometheus.web.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@Timed
public class HelloContoller {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
