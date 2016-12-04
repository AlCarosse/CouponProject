package com.anton.coupons.dao;

import java.util.List;

import com.anton.coupons.dao.interfaces.ICompanysDao;
import com.anton.coupons.exceptions.ApplicationException;
import com.anton.coupons.javaBeans.Company;
import com.anton.coupons.javaBeans.Coupon;

public class CompanysDao implements ICompanysDao {

	@Override
	public void createCompany(Company company) throws ApplicationException{
		

	}

	@Override
	public void removeCompany(long companyID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCompany(long companyID, Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getCompany(long companyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> getCoupons(long companyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String companyName, String companyPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
