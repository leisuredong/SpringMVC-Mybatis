package com.netease.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.netease.entity.Content;
import com.netease.service.Service;
import com.netease.service.ServiceImpl;

public class EditController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Service service = ServiceImpl.getInstance();
		int id = Integer.valueOf(request.getParameter("id"));
		Content content = service.getContentById(id);
		modelAndView.addObject("content", content);
		modelAndView.setViewName("./edit");
		return modelAndView;
	}

}
