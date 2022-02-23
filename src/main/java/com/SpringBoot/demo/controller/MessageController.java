package com.SpringBoot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBoot.demo.dto.MessageDto;
import com.SpringBoot.demo.model.WorkMessages;
import com.SpringBoot.demo.service.WorkMessagesService;

@Controller
class MessageController {

	@Autowired
	private WorkMessagesService service;

	@PostMapping(value = "/addMessage")
	public ModelAndView postNewMessage(ModelAndView mav, @Valid @ModelAttribute(name = "workMessages") WorkMessages msg,
			BindingResult rs) {

		if (!rs.hasErrors()) {
			service.insert(msg);
			WorkMessages newMsg = new WorkMessages();
			mav.getModel().put("workMessages", newMsg);
		}

		WorkMessages lastestMsg = service.getLastest();

		mav.getModel().put("lastestMessage", lastestMsg);

		mav.setViewName("messages/addMessage");

		return mav;
	}

	@ResponseBody
	@GetMapping("messages/lastest")
	public WorkMessages getLastest() {
		return service.getLastest();
	}

	@GetMapping("/editMessage")
	public ModelAndView editMessagePage(ModelAndView mav, @RequestParam(name = "id") Integer id) {

		WorkMessages msg = service.findById(id);

		mav.getModel().put("workMessages", msg);

//		mav.addObject("page", page);

		mav.setViewName("messages/editMessage");

		return mav;
	}

	@PostMapping("/editMessage")
	public ModelAndView editMessagePage(ModelAndView mav,
			@Valid @ModelAttribute(name = "workMessages") WorkMessages msg, BindingResult result) {

		mav.setViewName("messages/editMessage");
		if (!result.hasErrors()) {
			// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-persistence.saving-entites
			service.insert(msg);
			mav.setViewName("redirect:/viewMessage");
		}
		return mav;
	}

//	@GetMapping("/deleteMessage")
//	public ModelAndView deleteMessagePage(ModelAndView mav, @RequestParam(name = "id") Integer id) {
//
//		WorkMessages msg = service.findById(id);
//
//		mav.getModel().put("workMessages", msg);
//
////		mav.addObject("page", page);
//
//		mav.setViewName("messages/deleteMessage");
//
//		return mav;
//	}
//
//	@PostMapping("/deleteMessage")
//	public ModelAndView deleteMessagePage(ModelAndView mav,
//			@Valid @ModelAttribute(name = "workMessages") WorkMessages msg, BindingResult result) {
//
//		mav.setViewName("messages/deleteMessage");
//		if (!result.hasErrors()) {
//			// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-persistence.saving-entites
//			service.delete(msg.getId());
//			mav.setViewName("redirect:/viewMessage");
//		}
//		return mav;
//	}
	@GetMapping("/deleteMessage")
	public ModelAndView deleteMessagePage(ModelAndView mav, @RequestParam(name = "id") Integer id) {

		service.delete(id);

		mav.setViewName("redirect:/viewMessage");

		return mav;
	}

	@ResponseBody
	@PostMapping("/api/postMessage")
	public List<WorkMessages> postMessageApi(@RequestBody MessageDto dto) {
		String text = dto.getMsg();

		WorkMessages workMsg = new WorkMessages();
		workMsg.setText(text);

		service.insert(workMsg);

		Page<WorkMessages> page = service.findByPage(1);
		List<WorkMessages> list = page.getContent();

		return list;
	}

}
