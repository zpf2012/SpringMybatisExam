package com.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.AddressDao;
import com.dao.CustomerDao;
import com.hand.Address;

public class AddressImpl implements AddressDao{
	
	String resource = "conf/Configuration.xml";
	Reader reader = null;
	SqlSessionFactory mapper = new SqlSessionFactoryBuilder().build(reader);
	SqlSession session;
	
	public List<Address> selectAddress(int address_id) {
		
			try {
				reader = Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			session = mapper.openSession();
			List<Address> address = session.selectOne("selectAddress", address_id);
			
			session.close();
			
			return address;
		
	}
}
