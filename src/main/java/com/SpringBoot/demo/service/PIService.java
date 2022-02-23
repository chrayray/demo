package com.SpringBoot.demo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.SpringBoot.demo.model.PIRepository;
import com.SpringBoot.demo.model.Product;
import com.SpringBoot.demo.model.ProductImformation;
import com.SpringBoot.demo.model.ProductRepository;
import com.SpringBoot.demo.model.WorkMessages;

@Service
public class PIService {

	@Autowired
	private PIRepository daoPi;

	public void insert(ProductImformation Pi) {
		daoPi.save(Pi);
	}

	public void delete(Integer id) {
		daoPi.deleteById(id);
	}

	public List<ProductImformation> findAllProducts() {
		List<ProductImformation> Pi = daoPi.findAll();

		return Pi;
	}

	public List<ProductImformation> findById(Integer Id) {
		List<ProductImformation> Pi = daoPi.findIById(Id);

		return Pi;
	}

	public ProductImformation findLastHistoryById(Integer Id) {
		ProductImformation Pi = daoPi.findLastHistoryById(Id);

		return Pi;

	}

//	public List<ProductImformation> findAllLastHistory() {
//		List<ProductImformation> Pi = daoPi.findAllLastHistory();
//		return Pi;
//	}

	public void updateInsert(Integer id, Integer stock, String history) {
		daoPi.updateInsert(id, stock, history);
	}
}