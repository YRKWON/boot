package com.yr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yr.service.portfolioService;
import com.yr.vo.Contact;

@Controller
public class portfolioController {
	
	@Autowired
	portfolioService service;


	@RequestMapping("/index")
	public String portfolio(Contact ct, Model d){
		return "index1";
	}

	@RequestMapping("/insert")
	public String insert(Contact ct, Model d){
		service.insert(ct);
		return "redirect:/index";
	}
	
	@RequestMapping("/download")
	public void download(Model d, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fname = "cv.pdf";
		File file = new File("uploads/"+fname);
		System.out.println("## viewer오신 것을 환영합니다##");
		System.out.println("전체파일명:"+file.getPath());
		System.out.println("파일명:"+file.getName());
		System.out.println("파일길이:"+(int)file.length());

		response.setContentType("application/download; charset=UTF-8");

		response.setContentLength((int)file.length());

		fname = URLEncoder.encode(fname,"utf-8").replaceAll("\\+", " ");

		response.setHeader("Content-Disposition",
				"attachment;filename=\""+fname+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");

		FileInputStream fis = new FileInputStream(file);
		
		OutputStream out = response.getOutputStream();

		FileCopyUtils.copy(fis, out);

		out.flush();
	}
}
