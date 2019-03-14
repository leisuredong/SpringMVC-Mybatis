package com.netease.controller;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.netease.entity.Content;
import com.netease.service.Service;
import com.netease.service.ServiceImpl;

@Controller
public class IndexController {

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Service service = ServiceImpl.getInstance();
		List<Object> contents = service.getContent();
		String no_buy = request.getParameter("no-buy");
		if (no_buy != null && Integer.valueOf(request.getParameter("no-buy")) == 1) {
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
		return modelAndView;
	}
}
