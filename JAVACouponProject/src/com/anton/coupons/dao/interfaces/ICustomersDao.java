package com.anton.coupons.dao.interfaces;

import java.util.List;

import com.anton.coupons.javaBeans.Coupon;
import com.anton.coupons.javaBeans.Customer;

public interface ICustomersDao {
	public void createCustomer(Customer customer);

	public void removeCustomer(long customerID);

	public void updateCustomer(long customerID, Customer customer);

	public Customer getCustomer(long customerID);

	public List<Coupon> getCoupons(long customerID);

	public List<Customer> getAllCustomers();
}
