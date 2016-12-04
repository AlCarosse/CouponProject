package com.anton.coupons.javaBeans;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private long customerID;
	private String customerName;
	private String customerPassword;
	private String email;
	List<Coupon> customersCoupons = new ArrayList<Coupon>();

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Coupon> getCustomersCoupons() {
		return customersCoupons;
	}

	public void setCustomersCoupons(List<Coupon> customersCoupons) {
		this.customersCoupons = customersCoupons;
	}

	public Customer() {

	}

	public Customer(long customerID, String customerName, String customerPassword, String email,
			List<Coupon> customersCoupons) {
		super();
		setCustomerID(customerID);
		setCustomerName(customerName);
		setCustomerPassword(customerPassword);
		setEmail(email);
		setCustomersCoupons(customersCoupons);
	}

	public Customer(long customerID, String customerName, String customerPassword, String email) {
		super();
		setCustomerID(customerID);
		setCustomerName(customerName);
		setCustomerPassword(customerPassword);
		setEmail(email);
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", email=" + email + ", customersCoupons=" + customersCoupons + "]";
	}

}
