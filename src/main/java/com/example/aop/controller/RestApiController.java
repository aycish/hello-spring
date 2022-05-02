package com.example.aop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.AopUser;

@RestController
@RequestMapping("/api/aop")
public class RestApiController {

	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		return id + " " + name;
	}

	@PostMapping("/post")
	public AopUser post(@RequestBody AopUser aopUser) {
		return aopUser;
	}

	@Timer
	@DeleteMapping("/delete")
	public void delete() throws InterruptedException {

		Thread.sleep((1000 * 2));
	}

	@Decode
	@PutMapping("/put")
	public AopUser put(@RequestBody AopUser aopUser) {
		System.out.println("put");
		System.out.println(aopUser);
		return aopUser;
	}
}
