package com.example.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.User;

@RestController
@RequestMapping("/api/response")
public class ResponseApiController {

	// TEXT
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}

	// JSON
	// request -> object mapper -> object -> method -> object -> object mapper -> json -> response
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		return user; // 200 Ok
	}

	@PutMapping("/json-put")
	public ResponseEntity<User> put(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
