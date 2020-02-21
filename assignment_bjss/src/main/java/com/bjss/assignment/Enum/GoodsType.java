package com.bjss.assignment.Enum;

public enum GoodsType {

	// One enum value per item type. Add more enum values if more item types are required
	APPLES("apples", 1.0, 0.1), MILK("milk", 1.30), BREAD("bread", 0.8), SOUP("soup", 0.65);
	
	String name;
	double price;
	double discountPercentage=0.0;
	
	
	GoodsType(String name, double price) {

		this.name = name;
		this.price = price ;
	}
	
	GoodsType(String name, double price, double discountPercentage) {

		this.name = name;
		this.price = price ;
		this.discountPercentage = discountPercentage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPrice () {
		return this.price;
	}
	
	public double getDiscountPercentage () {
		return this.discountPercentage;
	}
	
}
