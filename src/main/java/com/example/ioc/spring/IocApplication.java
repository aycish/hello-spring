package com.example.ioc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run((IocApplication.class), args);

		ApplicationContext context = ApplicationContextProvider.getContext();

		SBase64Encoder base64Encoder = context.getBean(SBase64Encoder.class);
		SUrlEncoder urlEncoder = context.getBean(SUrlEncoder.class);

		SEncoder encoder = new SEncoder(base64Encoder);

		String url = "www.naver.com/book/it?page=10&size=20&name=spring-boot";
		String result = encoder.encode(url);
		System.out.println("base64Result = " + result);

		encoder.setIEncoder(urlEncoder);
		String urlResult = encoder.encode(url);
		System.out.println("urlResult = " + urlResult);
	}
}
