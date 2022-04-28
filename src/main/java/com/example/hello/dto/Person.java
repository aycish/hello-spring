package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private String name;
	private int age;

	@JsonProperty("phone_number")
	private String phoneNumber;

	public Person() {
		this.name = null;
		this.age = 0;
		this.phoneNumber = null;
	}

	public Person(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" +
			"name='" + name + '\'' +
			", age=" + age +
			", phoneNumber='" + phoneNumber + '\'' +
			'}';
	}
}
