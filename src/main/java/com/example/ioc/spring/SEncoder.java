package com.example.ioc.spring;

import java.util.Base64;

public class SEncoder {
	private IEncoderSpring iEncoder;

	public SEncoder(IEncoderSpring iEncoder) {
		this.iEncoder = iEncoder;
	}

	public void setIEncoder(IEncoderSpring iEncoder) {
		this.iEncoder = iEncoder;
	}

	public String encode(String msg) {
		return iEncoder.encode(msg);
	}
}
