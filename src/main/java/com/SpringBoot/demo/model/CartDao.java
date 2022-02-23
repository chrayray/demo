package com.SpringBoot.demo.model;

import java.util.Map.Entry;

public class CartDao {
	public void addBook(Product product) {
		// 獲取得到購物項
		CartItem cartItem = productMap.get(product.getProduct_id());
		// 判斷購物車是否存在該購物項，如果不存在
		if (cartItem == null) {
			// 建立這個購物項物件
			cartItem = new CartItem();
			// 將使用者傳遞過來的商品作為購物項
			cartItem.setProduct(product);
			// 把該購物項的數量設定為1
			cartItem.setQuantity(1);
			// 把購物項加入到購物車去
			productMap.put(product.getProduct_id(), cartItem);
		} else {
			// 如果存在該購物項，將購物項的數量+1
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	}

	public double getPrice() {
		double totalPrice = 0;
		for (Entry<Integer, CartItem> me : productMap.entrySet()) {
			// 得到每個購物項
			CartItem cartItem = me.getValue();
			// 將每個購物項的錢加起來，就是購物車的總價了！
			totalPrice = cartItem.getPrice();
		}
		return totalPrice;
	}
}
