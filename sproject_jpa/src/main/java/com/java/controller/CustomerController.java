package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.dto.Board;
import com.java.dto.Member;
import com.java.service.CustomerService;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired CustomerService customerService;
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/customer/view") //상세페이지 열기
	public String view(Board b, Model model) {
		System.out.println("controller bno : "+b.getBno());
		Board board = customerService.findByBno(b.getBno());
		model.addAttribute("board",board);
		return "customer/view";
	}
	
	
	@GetMapping("/customer/list")
	public String list(Model model) {
		//List<Board> controller -> service -> serviceImpl -> Jpa
		//게시글 전체가져오기
		Sort sort = Sort.by(Sort.Order.desc("bgroup"),Sort.Order.asc("bstep"));
		
		List<Board> list = customerService.findAll(sort);
		System.out.println("list 개수 : "+list.size());
		model.addAttribute("list",list);
		return "customer/list";
	}
	
	@GetMapping("/customer/delete") //상세페이지 열기
	public String delete(Board b,RedirectAttributes redirect, Model model) {
		System.out.println("controller delete bno : "+b.getBno());
		if(session.getAttribute("session_id") != null) {
			redirect.addFlashAttribute("flag",-1);
			customerService.deleteById(b.getBno());
			return "redirect:/customer/list";
		} else {
			System.out.println("제대로 된 삭제 URL이 아님");
			return "customer/view";
		}
		
	}
	
	@GetMapping("/customer/write") //상세페이지 열기
	public String write() {
		return "customer/write";
	}
	
	@PostMapping("/customer/write") //상세페이지 열기
	public String write(Board b, RedirectAttributes redirect) {
		//System.out.println("b member id  : "+b.getMember().getId());
		String id = (String) session.getAttribute("session_id");
		Member member = memberService.findById(id);
		b.setMember(member);
		customerService.save(b);
		redirect.addFlashAttribute("flag",1);
		return "redirect:/customer/list";
	}
}