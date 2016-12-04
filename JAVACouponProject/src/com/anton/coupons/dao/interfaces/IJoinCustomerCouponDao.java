package com.anton.coupons.dao.interfaces;

import com.anton.coupons.javaBeans.Coupon;
import com.anton.coupons.javaBeans.Customer;

public interface IJoinCustomerCouponDao {

	public void createJoinCustomerCoupon(Customer customer, Coupon coupon);

	public void removeJoinCustomerCoupon(long internalID);

}
