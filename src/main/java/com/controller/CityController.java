package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CityBean;
import com.dao.CityDao;

@Controller
public class CityController {

	@Autowired
	CityDao cityDao;
	
	@GetMapping("/newcity")
	public String newCity() {
		return "NewCity";
	}

	@PostMapping("/savecity")
	public String saveCirty(CityBean cityBean) {
		cityDao.addCity(cityBean);
		return "Dashboard";
	}
}
