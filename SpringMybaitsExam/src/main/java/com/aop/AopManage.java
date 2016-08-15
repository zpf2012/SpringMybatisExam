package com.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AopManage {
	
	@Before(value = "execution(* com.dao.Customerdao.*(..))")
	public void BeforeInsertFilmEvent(JoinPoint joinPoint){
		System.out.println("已保存的数据如下：");
		List<Object> customers = Arrays.asList(joinPoint.getArgs());
		System.out.println(customers);
	}
	
	@After(value = "execution(* com.dao.Customerdao.*(..))")
	public void AfterInsertFilmEvent(JoinPoint joinPoint){
		System.out.println("After Insert Customer Data");
	}
}
