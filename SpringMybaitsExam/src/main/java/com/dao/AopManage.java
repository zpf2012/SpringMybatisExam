package com.dao;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hand.Customer;


@Order(1)
@Aspect
@Component
public class AopManage {
	
	@Before("execution(public void insetCustomer(..))")
	public void BeforeInsertFilmEvent(JoinPoint joinPoint){
		System.out.println("Before Insert Customer Data:");
		System.out.println("已保存的数据如下：");
		List<Object> customers = Arrays.asList(joinPoint.getArgs());
		System.out.println(customers);
	}
	
	@After("execution(public void insetCustomer(..))")
	public void AfterInsertFilmEvent(JoinPoint joinPoint){
		System.out.println("After Insert Customer Data");
	}
}
