package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CurrencyBean;

@Controller
public class CurrencyController {

	@GetMapping("/inputcurr")
	public String inputCurrency() {
		return "InputCurr";
	}

	@PostMapping("/convert")
	public String convert(CurrencyBean currencyBean, Model model) {
		// read -> bean
		// validation
		boolean isError = false;
		if (currencyBean.getAmount() == null) {
			isError = true;
			model.addAttribute("amountError", "Please Enter amount");
		}

		
		if (isError == true) {
			return "InputCurr";
		} else {

			// convert inr -> usd
			Float usdPrice = 82.50F;
			Float usdAmount = currencyBean.getAmount() / usdPrice;
			System.out.println("USD => " + usdAmount);
			// set the data into model so that jsp can get back
			model.addAttribute("usdAmount", usdAmount);

			return "ConvertResult";
		}
	}
}
