package com.SpringBoot.demo.controller;

//以下需要用postman做測試

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.demo.model.Customer;
import com.SpringBoot.demo.model.CustomerRepository;

@RestController
public class CustomerApi {
	@Autowired
	private CustomerRepository cusDao;

	@PostMapping(value = "customer/insert")
	public Customer insertCustomer() {
		// http://localhost:8080/my-app/customer/insert
		Customer cus = new Customer();
		cus.setLevel(5);
		cus.setName("館長");
		Customer res = cusDao.save(cus);
		return res;
	}

	@PostMapping(value = "customer/insert2")
	public Customer insertCustomer(@RequestBody Customer cus) {
		Customer res = cusDao.save(cus);
		return res;
	}

	@PostMapping(value = "customer/insertAll")
	public List<Customer> insertAll(@RequestBody List<Customer> customers) {
		List<Customer> res = cusDao.saveAll(customers);
		return res;
	}

	@GetMapping(value = "customer")
	public Customer getById(@RequestParam Integer id) {
		Optional<Customer> optional = cusDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	@GetMapping(value = "customer/{id}")
	public Customer getById2(@PathVariable Integer id) {
		Optional<Customer> optional = cusDao.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	@GetMapping(value = "customer/page/{pageNumber}")
	public List<Customer> findByPage(@PathVariable Integer pageNumber) {
		// @PathVariable=直接寫在{pageNumber}裡面
		Pageable pgb = PageRequest.of(pageNumber - 1, 2, Sort.Direction.ASC, "id");
		// 從pageNumber - 1(零)開始算，每一頁顯示兩筆資料。
		Page<Customer> page = cusDao.findAll(pgb);

		List<Customer> resCus = page.getContent();

		return resCus;
	}

	@GetMapping(value = "customer/name")
	public List<Customer> findByName(@RequestParam String name) {
		// @RequestParam=後面還要再給值，ex:customer/name?name=館長
		return cusDao.findByName(name);

	}

	@GetMapping(value = "customer/name2")
	public List<Customer> findByName2(@RequestParam String name) {
		// @RequestParam=後面還要再給值，ex:customer/name?name=館長
		return cusDao.findByName2(name);

	}

	@PostMapping(value = "customer/update")
	public boolean updateLevel(Integer id, Integer level) {

		cusDao.updateLevel(id, level);

		return true;

	}

	@GetMapping(value = "customer/level")
	public List<Customer> findBylevel(@RequestParam int level) {
		return cusDao.findByLevel(level);
	}

}
