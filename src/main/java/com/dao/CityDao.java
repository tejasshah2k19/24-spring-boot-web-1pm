package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CityBean;

@Repository
public class CityDao {

	@Autowired
	JdbcTemplate stmt;

	public void addCity(CityBean cityBean) {
		stmt.update("insert into city (cityName) values (?) ", cityBean.getCityName());
	}

	public List<CityBean> getAllCity() {
		List<CityBean> cities = stmt.query("select * from city order by cityName", new BeanPropertyRowMapper<>(CityBean.class));
		// select * from city -> cityId , cityName => n number of records =>
		// List<CityBean>

		// db -> cityid and cityname ->
		// CityBean:{cityId,cityName}
		// List? we need multiple CityBean
		// List<CityBean>

		// db -> cityId cityName -> List<CityBean> ? how to convert this?=> we will use BeanPropertyRowMapper 
		return cities;

	}
}
