package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.member;
import com.site.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MController {
	
	@Autowired MService mService;
	@Autowired HttpSession httpsesion;
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(member m,Model model) {
		member member = mService.findByIdAndPw(m);
		if(member.getId() != null) {
			System.out.println("로그인 되었습니다.");
		}else {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "member/login";
	}
}
