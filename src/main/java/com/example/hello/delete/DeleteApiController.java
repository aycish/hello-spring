package com.example.hello.delete;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delete")
public class DeleteApiController {

	@DeleteMapping("/{userId}")
	public void delete(@PathVariable(name = "userId") String id, @RequestParam String account) {
		System.out.println("Log-in with account " + account +".");
		System.out.println("Contents of user(" + id + ") deleted ..");
	}
}
