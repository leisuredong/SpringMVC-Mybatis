package com.netease.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.netease.entity.Item;
import com.netease.service.Service;
import com.netease.service.ServiceImpl;

import net.sf.json.JSONObject;

@Controller
public class SettleAccountController {
	@RequestMapping(value = "/settleAccount.do", method = RequestMethod.POST)
	public @ResponseBody String createItem(@RequestBody Item[] items, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		Service service = ServiceImpl.getInstance();
		try {
			String currentTime;
			for (Item item : items) {
				currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
				item.setTime(currentTime);
				service.insertItem(item);
				service.updateSold(item.getId());
			}
			modelAndView.addObject("message", 1);

			JSONObject json = JSONObject.fromObject(modelAndView.getModel());
			String strJson = json.toString();
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json;charset=utf-8");
			writer.print(strJson);
			writer.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
	}
}
