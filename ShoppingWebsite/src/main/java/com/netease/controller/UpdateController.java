package com.netease.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.netease.entity.Content;
import com.netease.service.Service;
import com.netease.service.ServiceImpl;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
//		System.out.println("image:" + request.getParameter("image"));
//		System.out.println("file:" + request.getParameter("file"));
//		System.out.println("filepath:" + request.getParameter("filepath"));

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
//		System.out.println(content);

		Service service = ServiceImpl.getInstance();
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
