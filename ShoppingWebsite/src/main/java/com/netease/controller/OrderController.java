package com.netease.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netease.service.Service;
import com.netease.service.ServiceImpl;

@Controller
public class OrderController {
	@RequestMapping(value = "/order.do", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Service service = ServiceImpl.getInstance();
		List<HashMap<String, String>> orderItems = service.getItem();
		modelAndView.addObject("orderItems", orderItems);
		modelAndView.setViewName("./account");
		return modelAndView;
	}
}
