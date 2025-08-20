package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.dto.BoardDto;
import com.site.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired BService bService;
	
	@GetMapping("/list")
	public String list(Model model) {
		BoardDto boardDto = new bService.selectOne();
		model.addAttribute("boardDto",boardDto);
		return "board/list";
	}
	
	@GetMapping("/view")
	public String view(Model model) {
		BoardDto boardDto = new bService.selectOne();
		model.addAttribute("boardDto",boardDto);
		return "board/view";
	}
}
