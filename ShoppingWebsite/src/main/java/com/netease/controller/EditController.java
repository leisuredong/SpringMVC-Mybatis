package com.netease.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.netease.entity.Content;
import com.netease.service.Service;
import com.netease.service.ServiceImpl;

@Controller
public class EditController {

	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
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
