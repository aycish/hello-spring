package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

	@Pointcut("execution(* com.example.aop.controller..*.*(..))")
	private void cut() {}	// 왜 private으로 지정했을까?


	@Pointcut("@annotation(com.example.aop.annotation.Timer)")
	private void enableTimer() {}

	@Around("cut() && enableTimer()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// 메서드 실행 후, 특정 객체를 반환
		Object result = joinPoint.proceed();

		stopWatch.stop();
		System.out.println("total : " + stopWatch.getTotalTimeSeconds());
	}
}
