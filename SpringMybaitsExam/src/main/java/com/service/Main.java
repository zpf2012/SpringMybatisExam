package com.service;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.AddressDao;
import com.dao.CustomerDao;
import com.hand.Address;
import com.hand.Customer;

public class Main {
	
	
	public static void main(String[] args) {
//		读取配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("conf/ApplicationContext.xml");
		CustomerDao cmapper = (CustomerDao) context.getBean("CustomerDao");	
		AddressDao amapper = (AddressDao) context.getBean("AddressDao");
		
		
		Customer customer = new Customer();
		Address address = new Address();
		
		customer.setStore_id(1);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入FirstName(first_name):");
		customer.setFirst_name(sc.next());
		System.out.println("请输入LastName(last_name):");
		customer.setLast_name(sc.next());
		System.out.println("请输入Email(email):");
		customer.setEmail(sc.next());
		System.out.println("请输入Address ID:");
		customer.setAddress_id(sc.nextInt());		
		customer.setCreate_date(new Date());
		
		while(true){
			try {
				address = amapper.selectAddress(customer.getAddress_id());
				cmapper.insetCustomer(customer);
			} catch (Exception e) {
				System.out.println("你输入的Address ID 不存在,请重新输入:");
				customer.setAddress_id(sc.nextInt());				
			}
		}
				
	}
}
