package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import com.site.service.MemberService;
@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	//@GetMapping("/member/login")
	//@RequestMapping(method = RequestMethod.GET,value="/member/login")
	//@RequestMapping(method = RequestMethod.POST,value="/member/login")
	@GetMapping(value="/member/login")
	public String login() {
		System.out.println("get방식으로 들어옴.");
		return "member/login";
	}
	
	@PostMapping(value="/member/login")
	public String login(HttpServletRequest request,Model model) {
		System.out.println("post방식으로 들어옴.");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id:" + id);
		System.out.println("pw:" + pw);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "member/dologin";
	}
	
//	@PostMapping(value="/member/login")
//	public ModelAndView login(HttpServletRequest request) {
//		System.out.println("post방식으로 들어옴.");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		System.out.println("id:" + id);
//		System.out.println("pw:" + pw);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("Member/dologin");
//		mv.addObject("id",id);
//		mv.addObject("pw",pw);
//
//		return mv;
//	}
	
}
