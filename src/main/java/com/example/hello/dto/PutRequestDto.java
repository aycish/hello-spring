package com.example.hello.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// Deprecated : @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequestDto {

	private String name;
	private int age;

	//하나하나 맵핑하는 방법 : @JsonProperty("car_list")
	private List<CarDto> carList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<CarDto> getCarList() {
		return carList;
	}

	public void setCarList(List<CarDto> carList) {
		this.carList = carList;
	}

	@Override
	public String toString() {
		return "PutRequestDto{" +
			"name='" + name + '\'' +
			", age=" + age +
			", carList=" + carList +
			'}';
	}
}
