package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Num;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/num")
public class NumController {
	@GetMapping("/numInput")
	public String Input() {
		return "num/numInput";
	}
	
	@PostMapping("/numInput")
	public String Input(Num num,Model model) {
//		int total = num.getKor()+num.getEng()+num.getMath();
//		double avg = total/3.0;
//		model.addAttribute("name",name);
//		model.addAttribute("kor",kor);
//		model.addAttribute("eng",eng);
//		model.addAttribute("total",total);
		num.setTotal(num.getKor()+num.getEng()+num.getMath());
		num.setAvg(num.getTotal()/3.0);
		model.addAttribute("num",num);
		return "num/numResult";
	}
	
}
