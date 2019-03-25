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
public class UpdateController {
	@Autowired
	private Service service;

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		Content content = new Content();
		content.setTitle(request.getParameter("title"));
		content.setSummary(request.getParameter("summary"));
		String image = request.getParameter("image");
		if (image != null && !image.equals("")) {
			content.setImage(request.getParameter("image"));
			content.setFile("");
		} else {
			String file = request.getParameter("file").equals("") ? request.getParameter("filepath")
					: request.getParameter("file");
			if (file != null && !file.equals(""))
				content.setFile(file);
			else
				content.setFile("");
			content.setImage("");
		}
		content.setDetail(request.getParameter("detail"));
		content.setPrice(Integer.valueOf(request.getParameter("price")));

		int id = Integer.valueOf(request.getParameter("id"));
		content.setId(id);
		boolean result = service.updateContent(content);
		if (result) {
			modelAndView.addObject("content", content);
			modelAndView.setViewName("./edit-success");
		} else {
			modelAndView.setViewName("./edit");
		}
		return modelAndView;
	}

}
