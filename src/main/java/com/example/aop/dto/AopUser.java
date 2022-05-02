package com.example.aop.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class AopUser {

	private String id;
	private String pw;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AopUser{" +
			"id='" + id + '\'' +
			", pw='" + pw + '\'' +
			", email='" + email + '\'' +
			'}';
	}
}
