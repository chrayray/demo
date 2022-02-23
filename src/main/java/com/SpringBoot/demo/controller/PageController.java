package com.SpringBoot.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBoot.demo.model.Product;
import com.SpringBoot.demo.model.ProductImformation;
import com.SpringBoot.demo.model.WorkMessages;
import com.SpringBoot.demo.service.BusinessService;
import com.SpringBoot.demo.service.PIService;
import com.SpringBoot.demo.service.ProductService;
import com.SpringBoot.demo.service.WorkMessagesService;

@Controller
public class PageController {

	@Autowired
	private WorkMessagesService service;

	@Autowired
	private ProductService serviceP;

	@Autowired
	private BusinessService businessS;

	@Autowired
	private PIService servicePI;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/about")
	public String aboutPage() {
		return "messages/about";
	}

	@GetMapping("/addMessage")
	public ModelAndView addMessagePage(ModelAndView mav) {

		mav.setViewName("messages/addMessage");

		WorkMessages msg = new WorkMessages();

		WorkMessages lastestMsg = service.getLastest();

		mav.getModel().put("workMessages", msg);
		mav.getModel().put("lastestMessage", lastestMsg);

		return mav;
	}

	@GetMapping("/viewMessage")
	public ModelAndView viewMessagePage(ModelAndView mav,
			@RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {
		mav.setViewName("messages/viewMessage");

		Page<WorkMessages> page = service.findByPage(pageNumber);

//		mav.getModel().put("page", page);

		mav.addObject("page", page);

		return mav;
	}

	@GetMapping("/ajaxMessage")
	public ModelAndView viewAjax(ModelAndView mav) {
		mav.setViewName("messages/ajaxPage");
		return mav;
	}

	@GetMapping("/viewProducts")
	public ModelAndView viewMessagePage1(ModelAndView mav,
			@RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {
		mav.setViewName("messages/viewProducts");

		Page<Product> P = serviceP.findByPage(pageNumber);

//		mav.getModel().put("page", page);

		mav.addObject("P", P);

		return mav;
//		return null;
	}

	@GetMapping("/addProduct")
	public ModelAndView addProductPage(ModelAndView mav) {

		mav.setViewName("messages/addProduct");

		Product product = new Product();

		mav.getModel().put("P", product);

		return mav;
	}

	@GetMapping("/list")
	public ModelAndView ListProductPage(ModelAndView mav) {
		BusinessService businessService = new BusinessService();
		List<Product> products = businessService.findAll();

		mav.addObject("products", products);
		mav.setViewName("messages/list");
		return mav;
	}
}