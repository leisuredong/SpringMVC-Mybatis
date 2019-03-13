package com.netease.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.netease.entity.Content;
import com.netease.service.Service;
import com.netease.service.ServiceImpl;

public class PublicController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("Hello SubmitController");
//		System.out.println(request.getParameter("file"));
		ModelAndView modelAndView = new ModelAndView();
		Content content = new Content(request.getParameter("title"), request.getParameter("summary"),
				request.getParameter("image"), request.getParameter("file"), request.getParameter("detail"),
				Integer.valueOf(request.getParameter("price")));
		Service service = ServiceImpl.getInstance();
//		System.out.println("before:"+content.getId());
		boolean result = service.insertContent(content);
//		System.out.println("after:"+content.getId());
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
