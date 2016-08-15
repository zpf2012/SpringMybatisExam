package com.service;

import java.util.Date;
import java.util.List;
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
		
		customer.setStore_id(1);
		customer.setCreate_date(new Date());
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入FirstName(first_name):");
		customer.setFirst_name(sc.next());
		System.out.println("请输入LastName(last_name):");
		customer.setLast_name(sc.next());
		System.out.println("请输入Email(email):");
		customer.setEmail(sc.next());
		System.out.println("请输入Address ID:");
		
		while(true){
			customer.setAddress_id(sc.nextInt());				
			List<Address> address = amapper.selectAddress(customer.getAddress_id());
			if(!address.isEmpty()){
				cmapper.insetCustomer(customer);
				break;
			}else{
				System.out.println("你输入的Address ID 不存在,请重新输入:");							
			}
		}
		
		System.out.println("请输入要删除的Customer 的ID:");
		int temp = sc.nextInt();
		cmapper.deleteCustomer(temp);
		System.out.println("你输入的ID 为"+temp+" 的Customer 已经 删除.");
				
	}
}
