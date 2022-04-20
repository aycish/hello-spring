package com.example.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

	@GetMapping(path = "/hello")
	public String getHello() {
		return "get Hello!";
	}

	// old : @RequestMapping(path = "/hi", method = RequestMethod.GET)
	@GetMapping("/hi")
	public String hi() {
		return "Hi!";
	}

	/* http://localhost:9090/api/get/path-variable/{name} */
	@GetMapping("/path-variable/{name}")
	public String pathVariable(@PathVariable(name = "name") String pathName) {
		/* @PatchVariable 명과 변수 명을 맵핑 시킬 때, name 파라미터를 지정하여 맵핑한다. */
		System.out.println("PathVariable : " + pathName);
		return pathName;
	}

	/* http://localhost:9090/api/get/query-param?user=unhee&email=aycish07@gmail.com&age=30 */
	@GetMapping("/query-param")
	public String queryParam(@RequestParam String user, @RequestParam String email, @RequestParam int age) {
		System.out.println("User : " + user + "\n" +
		                   "Email : " + email + "\n" +
		                   "Age : " + age);
		return "Well-Done";
	}

	/* http://localhost:9090/api/get/query-param?user=unhee&email=aycish07@gmail.com&age=30 */
	@GetMapping("/query-param-map")
	public String queryParamMap(@RequestParam Map<String, String> queryParam) {

		StringBuilder sb = new StringBuilder();

		queryParam.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
		});

		return sb.toString();
	}

	@GetMapping("/query-param-dto")
	public String queryParamObject(UserRequest userRequest) {
		System.out.println(userRequest.toString());
		return userRequest.toString();
	}
}

