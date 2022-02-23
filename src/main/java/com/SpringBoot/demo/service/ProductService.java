package com.SpringBoot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.SpringBoot.demo.model.Product;
import com.SpringBoot.demo.model.ProductRepository;
import com.SpringBoot.demo.model.WorkMessages;

@Service
public class ProductService {

	@Autowired
	private ProductRepository dao;

	public void insert(Product product) {
		dao.save(product);
	}

	public Product findById(Integer id) {
		Optional<Product> op = dao.findById(id);

		if (op.isPresent()) {
			return op.get();
		}

		return null;
	}

	public void delete(Integer id) {
		dao.deleteById(id);
	}

	public List<Product> findAllProducts() {
		List<Product> product = dao.findAll();

		return product;
	}

	public Page<Product> findByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.DESC, "productId");

		return dao.findAll(pgb);
	}

	

}