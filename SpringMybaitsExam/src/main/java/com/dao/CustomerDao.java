package com.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hand.Customer;

@Component
public interface CustomerDao {
	
	public void insetCustomer(Customer customer);
	
	public void deleteCustomer(int customer_id);
	
	public List<Customer> selectCustomer();
}
