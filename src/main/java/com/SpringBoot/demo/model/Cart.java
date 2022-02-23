package com.SpringBoot.demo.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {


	private double price;// 代表著購物車的總價

	public Map<Integer, CartItem> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<Integer, CartItem> productMap) {
		this.productMap = productMap;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
//
}
