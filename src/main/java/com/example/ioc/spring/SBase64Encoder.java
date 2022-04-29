package com.example.ioc.spring;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class SBase64Encoder implements IEncoderSpring {
	public String encode(String msg) {
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}
}
