package com.bjss.assignment.model;

import java.text.DecimalFormat;

public class Goods {

	protected double price = 0;
	
	protected double discountPercent = 0;
	
	
	public Goods(double goodsPrice, double itemDiscountPercent) {
		
		this.price = goodsPrice;
		this.discountPercent = itemDiscountPercent;
	}
	
	
	public double getPrice() {
		
		return this.price;
	}

	public void setPrice(double price) {
		
		this.price = price;
	}
	
	public void setDiscountPercent(float discountPercent) {
		
		this.discountPercent = discountPercent;
	}
	
	public double getdiscountPercent() {
		
		return this.discountPercent;
	}

	public double getRetailPrice() {
		
		double retailPrice = 
				(getdiscountPercent() > 0.0 ? 
							getPrice() * (1.0 - getdiscountPercent()) : getPrice());
		
		return retailPrice;
	}
	
	public double getDiscount() {
		
		double discount = getPrice() - getRetailPrice();

		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		String strDiscount = decimalFormat.format(discount);
		discount = Double.parseDouble(strDiscount);
		
		return discount;
	}
	
}
