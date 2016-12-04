package com.anton.coupons.dao.interfaces;

import java.util.List;

import com.anton.coupons.exceptions.ApplicationException;
import com.anton.coupons.javaBeans.Coupon;
import com.anton.coupons.javaBeans.Customer;

public interface ICustomersDao {
	public void createCustomer(Customer customer) throws ApplicationException;

	public void removeCustomer(long customerID) throws ApplicationException;

	public void updateCustomer(long customerID, Customer customer) throws ApplicationException;

	public Customer getCustomer(long customerID) throws ApplicationException;

	public List<Coupon> getCouponsByCustomer(long customerID) throws ApplicationException;

	public List<Customer> getAllCustomers() throws ApplicationException;
}
