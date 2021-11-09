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
	
}
