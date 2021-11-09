package com.yr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.portfolioDao;
import com.yr.vo.Contact;


@Service
public class portfolioService {
	
	@Autowired(required=false)
	public portfolioDao dao;

	public void insert(Contact ins) {
		dao.Insert(ins);
		System.out.println("여기까지왔음");
	}

}
