package com.anton.coupons.dao.interfaces;

import java.util.List;

import com.anton.coupons.exceptions.ApplicationException;
import com.anton.coupons.javaBeans.Company;
import com.anton.coupons.javaBeans.Coupon;

public interface ICompanysDao {
	public void createCompany(Company company) throws ApplicationException;

	public void removeCompany(long companyID);

	public void updateCompany(long companyID, Company company);

	public Company getCompany(long companyID);

	public List<Coupon> getCoupons(long companyID);

	public List<Company> getAllCompanies();

	public boolean login(String companyName, String companyPassword);

}
