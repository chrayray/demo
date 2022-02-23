package com.SpringBoot.demo.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductDB {
	private static Map<Integer, Product> map = new LinkedHashMap<>();

	static {
		map.put(1, new Product(1, "阿瓦隆", 350.0, "多人派對", 4, 8, 13, "Photo/Avalon.jpg", "上架中"));
		map.put(2, new Product(2, "羽人圖錄", 600.0, "多人派對", 2, 5, 13, "Photo/Avalon.jpg", "上架中"));
		map.put(3, new Product(3, "三劍骼", 400.0, "多人派對", 2, 6, 8, "Photo/Avalon.jpg", "上架中"));
		map.put(4, new Product(4, "retry勇者", 500.0, "多人派對", 2, 5, 15, "Photo/Avalon.jpg", "上架中"));
	}

	public static Map<Integer, Product> getAll() {
		return map;
	}
}
