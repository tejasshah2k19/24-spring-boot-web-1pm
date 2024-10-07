package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.CityBean;
import com.dao.CityDao;

@Controller
public class AreaController {

	@Autowired
	CityDao cityDao;

	@GetMapping("newarea")
	public String newArea(Model model) {
		List<CityBean> cities = cityDao.getAllCity();
		//set cities for next jsp -> Model
		model.addAttribute("cities",cities);
		return "NewArea";
	}
}
