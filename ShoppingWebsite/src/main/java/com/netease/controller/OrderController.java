package com.netease.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netease.service.Service;

@Controller
public class OrderController {
	@Autowired
	private Service service;

	@RequestMapping(value = "/order.do", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<HashMap<String, String>> orderItems = service.getItem();
		modelAndView.addObject("orderItems", orderItems);
		modelAndView.setViewName("./account");
		return modelAndView;
	}
}
