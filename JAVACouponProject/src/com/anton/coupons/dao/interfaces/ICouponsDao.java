package com.anton.coupons.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.anton.coupons.exceptions.ApplicationException;
import com.anton.coupons.javaBeans.Coupon;

public interface ICouponsDao {
	public void createCoupon(Coupon coupon) throws ApplicationException, ClassNotFoundException, SQLException;

	public void removeCoupon(long couponID) throws ApplicationException;

	public void updateCoupon(long couponID, Coupon coupon) throws ApplicationException;

	public Coupon getCoupon(long couponID) throws ApplicationException;

	public List<Coupon> getCouponsByType(int couponType) throws ApplicationException;

	public List<Coupon> getAllCoupons() throws ApplicationException;

	public List<Coupon> getCouponsByCompanyID(int companyID) throws ApplicationException;

}
