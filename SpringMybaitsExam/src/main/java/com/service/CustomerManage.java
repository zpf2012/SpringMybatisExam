package com.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.CustomerDao;
import com.hand.Customer;

public class CustomerManage implements CustomerDao {

	String resource = "conf/MybatisConfig.xml";
	Reader reader = null;
	SqlSessionFactory mapper = new SqlSessionFactoryBuilder().build(reader);
	SqlSession session;

	public void insetCustomer(Customer customer){
		try {
			reader = Resources.getResourceAsReader(resource);
			session = mapper.openSession();
			session.update("insertCustomer", customer);
			session.commit();
		} catch (IOException e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}


}
