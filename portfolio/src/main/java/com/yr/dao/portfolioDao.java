package com.yr.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yr.vo.Contact;


@Mapper
public interface portfolioDao {
	public void Insert(Contact ins);
}
