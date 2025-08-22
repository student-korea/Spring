package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.dto.Stuscore;
import com.site.service.SService;

@Controller
public class SController {
	
	@Autowired SService sService;
	
	@GetMapping("/stuscore/slist")
	public String slist(Model model) {
		List<Stuscore> list = sService.selectAll();
		
		model.addAttribute("list",list);
		return "stuscore/slist";
	}
}
