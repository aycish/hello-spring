package com.example.hello;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hello.dto.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class HelloApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("------------");
		var objectMapper = new ObjectMapper();

		// obejct -> text
		// ObjectMapper는 get method를 사용하므로 getter를 구현해줘야한다.
		// 내가 작성한 클래스가 ObjectMapper를 사용한다고 한다면, get 메서드를 활용하므로 혼용되지 않도록 주의해야한다.
		var person = new Person("unhee", 30, "010-1234-1234");
		var text = objectMapper.writeValueAsString(person);
		System.out.println(text);

		// text -> object
		// default 생성자를 사용하므로 구현해줘야한다.
		var objectPerson = objectMapper.readValue(text, Person.class);
		System.out.println(objectPerson);
	}
}
