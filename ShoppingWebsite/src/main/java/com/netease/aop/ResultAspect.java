package com.netease.aop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

@Aspect
public class ResultAspect {
	@AfterReturning(value = "execution(* com.netease.controller.*.handleAndPrint(..)) && args(.., response)", returning = "modelAndView")
	private void printResult(ModelAndView modelAndView, HttpServletResponse response) throws IOException {
		JSONObject json = JSONObject.fromObject(modelAndView.getModel());
		String strJson = json.toString();
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json;charset=utf-8");
		writer.print(strJson);
		writer.close();
	}
}
