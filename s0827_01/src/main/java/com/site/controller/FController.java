package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FController {
	@GetMapping({"/","/index"})
	public String index(@RequestParam(name="flag",defaultValue = "0") int flag,Model model) {
		System.out.println("안녕하세요.");
		System.out.println("반가워요");
		model.addAttribute("flag",flag);
		return "index";
	}
}
