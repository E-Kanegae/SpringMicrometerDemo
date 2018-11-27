package com.example.ek.prometheusdemo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

/**
 *
 * @author etsukanegae
 *
 */
@RestController
@Timed
public class HelloContoller {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
