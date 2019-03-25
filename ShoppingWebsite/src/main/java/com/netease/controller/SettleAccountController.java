package com.netease.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.netease.entity.Item;
import com.netease.service.Service;

@Controller
public class SettleAccountController {
	@Autowired
	private Service service;

	@RequestMapping(value = "/settleAccount.do", method = RequestMethod.POST)
	public @ResponseBody ModelAndView handleAndPrint(@RequestBody Item[] items, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			String currentTime;
			for (Item item : items) {
				currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
				item.setTime(currentTime);
				service.insertItem(item);
				service.updateSold(item.getId());
			}
			modelAndView.addObject("message", 1);
			modelAndView.setViewName("./account");
		} catch (Exception e) {

		}
		return modelAndView;
	}
}
