package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CalcBean;

@Controller
public class CalcController {
	
	//jsp open 
	@GetMapping("/inputcalc")
	public String inputCalc() {
		
		return "InputCalc";//jsp 
	}

	//logic 
	@PostMapping("/addition")
	public String addition(CalcBean calc) {

		//read -> bean 
		System.out.println(calc.getN1()+calc.getN2());
		return "OutputCalc";//output 
	}
}
