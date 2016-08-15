package com.dao;

import java.util.List;

import com.hand.Address;

public interface AddressDao {
	public List<Address> selectAddress(int address_id);
}
