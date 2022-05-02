package com.example.aop.aop;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.aop.dto.AopUser;

@Aspect
@Component
public class DecodeAop {

	@Pointcut("execution(* com.example.aop.controller..*.*(..))")
	private void cut() {}


	@Pointcut("@annotation(com.example.aop.annotation.Decode)")
	private void enableDecode() {}

	@Before("cut() && enableDecode()")
	public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
		Object[] args = joinPoint.getArgs();

		for(Object arg : args) {
			if (arg instanceof AopUser) {
				AopUser aopUser = AopUser.class.cast(arg);

				String base64Email = aopUser.getEmail();
				aopUser.setEmail(new String(Base64.getDecoder().decode(base64Email), "UTF-8"));
			}
		}
	}

	@AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
	public void afterReturn(JoinPoint joinPoint, Object returnObj) {
		if (returnObj instanceof AopUser) {
			AopUser aopUser = AopUser.class.cast(returnObj);
			String email = aopUser.getEmail();
			aopUser.setEmail(Base64.getEncoder().encodeToString(email.getBytes(StandardCharsets.UTF_8)));
		}
	}

}
