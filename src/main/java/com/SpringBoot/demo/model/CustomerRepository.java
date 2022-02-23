package com.SpringBoot.demo.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer where name = :name") // hibernate hql語法
	public List<Customer> findByName(@Param(value = "name") String name);
	// JpaRepository 本身沒有的語法，用hibernate寫

	@Query(value = "select * from Customer where name = :name", nativeQuery = true) // sql語法
	public List<Customer> findByName2(@Param(value = "name") String name);
	// 如果要用SQL語法的話，後面記得加上 nativeQuery = true

	@Transactional
	@Modifying
	@Query(value = "update Customer c set c.level = :level where c.id = :id")
	public void updateLevel(@Param("id") Integer id, @Param("level") Integer level);
	// 如果要用update delete的方法的話，記得要加@Modifying

	public List<Customer> findByLevel(int id);
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
}
