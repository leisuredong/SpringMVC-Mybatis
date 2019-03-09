package com.netease.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.netease.entity.Content;
import com.netease.service.Service;
import com.netease.service.ServiceImpl;

public class IndexController implements Controller {

	Service userService;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("Hello IndexController!");
		ModelAndView modelAndView = new ModelAndView();
		Service service = ServiceImpl.getInstance();
		List<Object> contents = service.getContent();
		String no_buy = request.getParameter("no-buy");
		if (no_buy != null && Integer.valueOf(request.getParameter("no-buy")) == 1) {
//			System.out.println("no-buy");
			List<Object> nobuyContents = new ArrayList<Object>();
			for (int i = 0; i < contents.size(); i++) {
				Content content = (Content) contents.get(i);
				if (!content.isSold())
					nobuyContents.add(content);
			}
			modelAndView.addObject("contents", nobuyContents);
			modelAndView.addObject("no_buy", 1);
		} else {
			modelAndView.addObject("contents", contents);
		}
//		System.out.println("Bye IndexController!");
		return modelAndView;
	}

	public static void main(String[] args) {
		Service service = ServiceImpl.getInstance();
		List<Object> contents = service.getContent();
		for (Object content : contents) {
			System.out.println(content);
		}
	}
}
