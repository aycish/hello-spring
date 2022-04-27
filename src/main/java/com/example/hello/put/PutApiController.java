package com.example.hello.put;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.PutRequestDto;

@RestController
@RequestMapping("/api/put")
public class PutApiController {

	@PutMapping("/put")
	public void put(@RequestBody PutRequestDto putRequestDto) {
		System.out.println(putRequestDto);
	}

	@PutMapping("/put-response")
	public PutRequestDto putResponse(@RequestBody PutRequestDto putRequestDto) {
		System.out.println(putRequestDto);
		return putRequestDto;
	}

	@PutMapping("/{userId}")
	public PutRequestDto putResponse(@RequestBody PutRequestDto putRequestDto, @PathVariable Long userId) {
		System.out.println("Welcome .. user(" + userId + ") ...");
		System.out.println(putRequestDto);
		return putRequestDto;
	}
}
