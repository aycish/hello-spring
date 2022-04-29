package com.example.ioc.before;

public class Main {

	public static void main(String[] args) {
		String url = "www.naver.com/book/it?page=10&size=20&name=spring-boot";

		//Base64 encoding .. DI
		Encoder encoder = new Encoder(new Base64Encoder());
		String result = encoder.encode(url);
		System.out.println("Base64 = " + url);
	}
}
