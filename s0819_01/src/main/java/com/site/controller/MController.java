package com.site.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.site.dto.Member;
import com.site.service.MService;
import com.site.service.MServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired MService mService;
    private final MServiceImpl MServiceImpl;

    MController(MServiceImpl MServiceImpl) {
        this.MServiceImpl = MServiceImpl;
    }
    @GetMapping("/login")
	public String login() {
		return "member/login";
	}
    @PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		
		// jsp페이지로 데이터 전송방법
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "member/doLogin";
	}
	
	@PostMapping("/memberInput")
	public String login(Member member,Model model) {
		
		model.addAttribute("member",member);
//		model.addAttribute("id",member.getId());
//		model.addAttribute("pw",member.getPw());
//		model.addAttribute("name",member.getName());
//		model.addAttribute("phone",member.getPhone());
//		model.addAttribute("gender",member.getGender());
		
		return "member/memberResult";
	}
//	@PostMapping("/memberInput")
//	public String login(HttpServletRequest request,@RequestParam(name="id",defaultValue = "aaa") String id,@RequestParam("pw") String pw,
//			@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("gender") String gender,Model model) {
//		
//		model.addAttribute("id",id);
//		model.addAttribute("pw",pw);
//		model.addAttribute("name",name);
//		model.addAttribute("phone",phone);
//		model.addAttribute("gender",gender);
//		
//		return "member/memberResult";
//	}
	
	@GetMapping("/member")
	public String member() {
		return "member/memberInput";
	}
	
	@PostMapping("/member")
	public String member(Member member,Model model) {	
//		System.out.println(Arrays.toString(hobby));
		mService.insertOne(member);
		model.addAttribute("member",member);
		return "member/memberResult";
	}
	
	@GetMapping("/mView")
	public String mView(Model model) {
		// member 정보
//		MServiceImpl mServiceImpl = new MServiceImpl();
//		Member member = mServiceImpl.selectOne();
		// 유관순 정보를 가져와서 member전송하시오.
//		MService mService = new MServiceImpl2();
//		Member member = mService.selectOne();
		
		//스프링이 객체선언을 대행해서 주입(DI)
		Member member = mService.selectOne();
		model.addAttribute("member",member);
		return "member/mView";
	}	
	
	@GetMapping("/mList")
	public String mList(Model model) {
		
		List<Member> list = mService.selectAll();
		System.out.println(list.get(2).getName());
		System.out.println(list.size());
		model.addAttribute("list",list);
		return "member/mList";
	}
}
