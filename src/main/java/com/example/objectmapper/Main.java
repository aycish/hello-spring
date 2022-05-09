package com.example.objectmapper;

import java.util.Arrays;
import java.util.List;

import com.example.objectmapper.dto.Car;
import com.example.objectmapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {

	public static void main(String[] args) throws JsonProcessingException {
		System.out.println("main");

		ObjectMapper objectMapper = new ObjectMapper();

		User user = new User();
		user.setName("홍길동");
		user.setAge(10);

		Car car1 = new Car();
		car1.setName("K5");
		car1.setCarNumber("11가 1111");
		car1.setType("세단");

		Car car2 = new Car();
		car2.setName("Q5");
		car2.setCarNumber("22가 2222");
		car2.setType("SUV");

		List<Car> carList = Arrays.asList(car1, car2);
		user.setCars(carList);

		//System.out.println(user);

		// JSON encoding type은 UTF-8이 기본이므로 주의
		String json = objectMapper.writeValueAsString(user);
		System.out.println(json);

		JsonNode jsonNode = objectMapper.readTree(json);
		String _name = jsonNode.get("name").asText();
		int _age = jsonNode.get("age").asInt();

		System.out.println("name = " + _name);
		System.out.println("age = " + _age);

		// JSON의 한 꼭지는 NODE로 취급하기 때문에, 하기의 예제를 참고하자.
		JsonNode cars = jsonNode.get("cars");
		ArrayNode arraysNode = (ArrayNode)cars;
		List<Car> _cars = objectMapper.convertValue(arraysNode, new TypeReference<List<Car>>() {});
		System.out.println(_cars);

		// JSON의 필드 변경경
		ObjectNode objectNode = (ObjectNode) jsonNode;
		objectNode.put("name", "steve");
		objectNode.put("age", 20);

		System.out.println(objectNode.toString());
	}
}
