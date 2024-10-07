package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AreaBean;

@Repository
public class AreaDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void addArea(AreaBean areaBean) {
		jdbcTemplate.update("insert into area (areaName,cityId) values (?,?)",areaBean.getAreaName(),areaBean.getCityId());
	}

}
