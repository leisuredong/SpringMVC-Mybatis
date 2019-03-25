package com.netease.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.netease.service.Service;

@Controller
public class DeleteController {
	@Autowired
	private Service service;

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView handleAndPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.valueOf(request.getParameter("id"));

		ModelAndView modelAndView = new ModelAndView();
		if (service.deleteContent(id)) {
//			System.out.println("删除成功");
			modelAndView.addObject("message", 1);
		} else {
			modelAndView.addObject("message", 0);
		}
		modelAndView.setViewName("./index");
		return modelAndView;
	}
}
