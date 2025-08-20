package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.service.MService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MController {
	@Autowired MService memberService; //자동으로 객체선언 됨.
	
	@GetMapping("/member/login")
	public String login() {
		System.out.println("get방식으로 들어옴.");
		return "member/login";
	}
	
	
	@PostMapping("/member/login") // Model 형태
	public String login(HttpServletRequest request, Model model) {
		System.out.println("post방식으로 들어옴.");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		model.addAttribute("id",id); //view페이지 데이터 전송
		model.addAttribute("pw",pw);
		return "member/doLogin";
	}	
}
