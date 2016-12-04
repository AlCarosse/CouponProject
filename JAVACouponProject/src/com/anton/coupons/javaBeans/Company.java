package com.anton.coupons.javaBeans;

import java.util.*;

// Company JavaBean
public class Company {
	// Class fields
	private long companyID;
	private String companEmail;
	private String companyName;
	private String companyPassword;
	List<Coupon> companysCoupons = new ArrayList<Coupon>();

	// Getters and setters
	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}

	public String getCompanyEmail() {
		return companEmail;
	}

	public void setCompanyEmail(String companEmail) {
		this.companEmail = companEmail;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPassword() {
		return companyPassword;
	}

	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}

	public List<Coupon> getCompanysCoupons() {
		return companysCoupons;
	}

	public void setCompanysCoupons(List<Coupon> companysCoupons) {
		this.companysCoupons = companysCoupons;
	}

	// Empty constructor
	public Company() {

	}

	// Constructor using all fields
	public Company(long companyID, String companEmail, String companyName, String companyPassword,
			List<Coupon> companysCoupons) {
		super();
		setCompanyID(companyID);
		setCompanyEmail(companEmail);
		setCompanyName(companyName);
		setCompanyPassword(companyPassword);
		setCompanysCoupons(companysCoupons);
	}

	public Company(long companyID, String companEmail, String companyName, String companyPassword) {
		setCompanyID(companyID);
		setCompanyEmail(companEmail);
		setCompanyName(companyName);
		setCompanyPassword(companyPassword);
	}

	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companEmail=" + companEmail + ", companyName=" + companyName
				+ ", companyPassword=" + companyPassword + ", companysCoupons=" + companysCoupons + "]";
	};

}
