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
public class PublicController {
	@Autowired
	private Service service;

	@RequestMapping(value = "/public.do", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Content content = new Content(request.getParameter("title"), request.getParameter("summary"),
				request.getParameter("image"), request.getParameter("file"), request.getParameter("detail"),
				Integer.valueOf(request.getParameter("price")));
		boolean result = service.insertContent(content);
		if (result) {
//			System.out.println("插入成功");
			modelAndView.addObject("content", content);
			modelAndView.setViewName("./public-success");
		} else {
//			System.out.println("插入失败");
			modelAndView.setViewName("./public");
		}

		return modelAndView;
	}

}
