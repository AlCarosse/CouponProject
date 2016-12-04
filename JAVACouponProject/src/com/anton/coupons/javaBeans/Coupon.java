package com.anton.coupons.javaBeans;

public class Coupon {
	private long couponID;
	private String title;
	private long startDate;
	private long endDate;
	private int amount;
	private int couponType;
	private long companyID;
	private String message;
	private float price;
	private String image;

	public long getCouponID() {
		return couponID;
	}

	public void setCouponID(long couponID) {
		this.couponID = couponID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCouponType() {
		return couponType;
	}

	public void setCouponType(int couponType) {
		this.couponType = couponType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Coupon() {

	}

	public Coupon(long couponID, String title, long startDate, long endDate, int amount, int couponType, String message,
			float price, String image, long companyID) {
		super();
		setCouponID(couponID);
		setTitle(title);
		setStartDate(startDate);
		setEndDate(endDate);
		setAmount(amount);
		setCouponType(couponType);
		setMessage(message);
		setCompanyID(companyID);
		setPrice(price);
		setImage(image);
	}



	@Override
	public String toString() {
		return "Coupon [couponID=" + couponID + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", couponType=" + couponType + ", companyID=" + companyID + ", message="
				+ message + ", price=" + price + ", image=" + image + "]";
	}

	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}

}
