package com.anton.coupons.dao;


import java.util.List;

import com.anton.coupons.dao.interfaces.ICustomersDao;
import com.anton.coupons.javaBeans.Coupon;
import com.anton.coupons.javaBeans.Customer;

public class CustomersDao implements ICustomersDao{

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(long customerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(long customerID, Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> getCoupons(long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
