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
//		查询操作
		List<Customer> customers = cmapper.selectCustomer();
		String address = null ;
		int store_id = 0;
		String first_name = null;
		String last_name = null;
		String email = null;
		for(Customer customer2:customers){
			address = customer2.getAddress().getAddress();
			store_id = customer2.getStore_id();
			first_name = customer2.getFirst_name();
			last_name = customer2.getLast_name();
			email = customer2.getEmail();
		}
		System.out.println("已经保存的数据如下:");
		System.out.println("ID:"+store_id);
		System.out.println("FirstName:"+first_name);
		System.out.println("LastName:"+last_name);
		System.out.println("Email:"+email);
		System.out.println("Address:"+address);
		
//		删除操作
		System.out.println("请输入要删除的Customer 的ID:");
		int temp = sc.nextInt();
		cmapper.deleteCustomer(temp);
		System.out.println("你输入的ID 为"+temp+" 的Customer 已经 删除.");
				
	}
}
