package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hello.dto.User;

@Controller
public class PageController {

	@RequestMapping("/main")
	public String main() {
		return "main.html";
	}

	@ResponseBody
	@GetMapping("/user")
	public User user() {
		var user = new User();
		user.setName("unhee");
		user.setAddress("티맥스");
		return user;
	}
}
