package com.netease.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.netease.entity.Content;
import com.netease.service.Service;

@Controller
public class EditController {
	@Autowired
	private Service service;

	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.valueOf(request.getParameter("id"));
		Content content = service.getContentById(id);
		modelAndView.addObject("content", content);
		return modelAndView;
	}

}
