package com.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(1)
@Aspect
@Component
public class AopManage {
	
	@Before("execution(* selectCustomer())")
	public void BeforeInsertFilmEvent(JoinPoint joinPoint){
		System.out.println("Before Insert Customer Data:");
	}
	
	@After("execution(* selectCustomer())")
	public void AfterInsertFilmEvent(JoinPoint joinPoint){
		System.out.println("After Insert Customer Data");
	}
}
