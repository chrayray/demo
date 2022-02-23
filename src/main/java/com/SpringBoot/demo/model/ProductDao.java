package com.SpringBoot.demo.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query(value = "select * from Product", nativeQuery = true)
	public List<Product> getAll();

	@Query(value = "select * from Product where product_id=:product_id", nativeQuery = true)
	public Product findByproductid(@Param(value = "product_id") String id);

}
