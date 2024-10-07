package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AreaBean;
import com.bean.CityBean;
import com.dao.AreaDao;
import com.dao.CityDao;

@Controller
public class AreaController {

	@Autowired
	CityDao cityDao;

	@Autowired
	AreaDao areaDao;
	
	@GetMapping("newarea")
	public String newArea(Model model) {
		List<CityBean> cities = cityDao.getAllCity();
		//set cities for next jsp -> Model
		model.addAttribute("cities",cities);
		return "NewArea";
	}
	
	@PostMapping("savearea")
	public String saveArea(AreaBean areaBean) {
		areaDao.addArea(areaBean);
		return "Dashboard";
	}
}
