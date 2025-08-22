package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Member;
import com.site.service.MService;

@Controller
public class MController {
	@Autowired MService mService;
	
	@GetMapping("/member/mList")
	public String mList(Model model) {
		List<Member> list = mService.selectAll();
		model.addAttribute("list",list);
		Member member = mService.selectOne();
		model.addAttribute("one",member);
		return "member/mList";
	}
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(Member member,Model model) {
		System.out.println("아이디 : "+member.getId());
		System.out.println("패스워드 : "+member.getPw());
		String id = member.getId();
		String pw = member.getPw();
		
		Member m = mService.selectLogin(id,pw);
		if(m==null) {
			System.out.println("impossible login");
		} else {
			System.out.println("Success Login");
			return "/index";
		}
		
		return "member/login";
	}

}
