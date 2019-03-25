package com.netease.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.netease.entity.User;
import com.netease.service.Service;
import com.netease.util.MD5;

@Controller
public class LoginController {
	@Autowired
	private Service service;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView handleAndPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		User user = new User();

		user = service.getUser(1);
		String username_db = user.getUsername();
		String password_db = user.getPassword();
		if (username_db.equals(username) && MD5.md5(password_db).equals(password)) {
//			System.out.println("买家登录成功");
			modelAndView.addObject("message", 1);
			request.getSession().setAttribute("currentUser", user);
		} else {
			user = service.getUser(2);
			username_db = user.getUsername();
			password_db = user.getPassword();
			if (username_db.equals(username) && MD5.md5(password_db).equals(password)) {
//				System.out.println("卖家登录成功");
				modelAndView.addObject("message", 1);
				request.getSession().setAttribute("currentUser", user);
			} else {
//				System.out.println("登录失败");
				modelAndView.addObject("message", 0);
			}
		}

		return modelAndView;
	}
}
