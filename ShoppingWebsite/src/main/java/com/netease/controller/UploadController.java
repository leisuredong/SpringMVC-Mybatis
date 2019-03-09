package com.netease.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

@Controller
public class UploadController {

	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String uploadPic(MultipartHttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView) throws Exception {
		MultipartFile file = request.getFile("file");
		String path = "D:\\software\\git\\repository\\ShoppingWebsite\\src\\main\\webapp\\resources";
		request.getSession().setAttribute("file", file.getOriginalFilename());

		File filePath = new File(path);
		if (!filePath.exists() && !filePath.isDirectory())
			filePath.mkdir();

		try {
			File targetFile = new File(path, file.getOriginalFilename());
			file.transferTo(targetFile);
			modelAndView.addObject("result", 1);
			modelAndView.addObject("file", file.getOriginalFilename());
			request.getSession().setAttribute("result", 1);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JSONObject json = JSONObject.fromObject(modelAndView.getModel());
		String strJson = json.toString();
//		System.out.println(strJson);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json;charset=utf-8");
		writer.print(strJson);
		writer.close();
		return null;
	}

}
