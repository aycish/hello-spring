package com.example.hello.post;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.PostRequestDto;

@RestController
@RequestMapping("/papi")
public class PostApiController {

	@PostMapping("/post")
	public void post(@RequestBody Map<String, Object> requestData) {
		System.out.println("---------------------");
		requestData.entrySet().forEach(stringObjectEntry -> {
			System.out.println("[KEY] " + stringObjectEntry.getKey());
			System.out.println("[VALUE] " + stringObjectEntry.getValue());
			System.out.println("---------------------");
		});
	}

	@PostMapping("/post-dto")
	public void postDto(@RequestBody PostRequestDto requestData) {
		System.out.println(requestData);
	}
}
