package com.anton.coupons.javaBeans;

public class joinCustomerCoupon {

	private long internalID;
	private long customerID;
	private long couponID;

	public joinCustomerCoupon() {
	}

	public joinCustomerCoupon(long internalID, long customerID, long couponID) {
		setInternalID(internalID);
		setCustomerID(customerID);
		setCouponID(couponID);
	}

	public long getInternalID() {
		return internalID;
	}

	public void setInternalID(long internalID) {
		this.internalID = internalID;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public long getCouponID() {
		return couponID;
	}

	public void setCouponID(long couponID) {
		this.couponID = couponID;
	}

}
