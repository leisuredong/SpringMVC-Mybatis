package com.netease.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.netease.service.Service;
import com.netease.service.ServiceImpl;

import net.sf.json.JSONObject;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("Hello DeleteController");
		int id = Integer.valueOf(request.getParameter("id"));
//		System.out.println(id);
		Service service = ServiceImpl.getInstance();

		ModelAndView modelAndView = new ModelAndView();
		if (service.deleteContent(id)) {
//			System.out.println("删除成功");
			modelAndView.addObject("message", 1);
			JSONObject json = JSONObject.fromObject(modelAndView.getModel());
			String strJson = json.toString();
//			System.out.println(strJson);
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json;charset=utf-8");
			writer.print(strJson);
			writer.close();
		} else {
			modelAndView.addObject("message", 0);
		}
		return null;
	}
}
