package com.SpringBoot.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.demo.model.Product;
import com.SpringBoot.demo.model.ProductDao;

@Service
public class BusinessService {

	@Autowired
	private ProductDao productDao;

	public List<Product> findAll() {
		return productDao.findAll();
	}

	/* 根據商品的id獲取商品 */
	public Product findById(Integer id) {
		Optional<Product> op = productDao.findById(id);

		if (op.isPresent()) {
			return op.get();
		}

		return null;
	}
}
