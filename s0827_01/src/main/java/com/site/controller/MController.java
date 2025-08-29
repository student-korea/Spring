package com.site.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.Member;
import com.site.service.MService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {

	@Autowired MService mService;
	@Autowired HttpSession session;
	
	@GetMapping("/login")
	public String login(){
		return "member/login";
	}
	@PostMapping("/login")
	public String login(HttpServletResponse response,RedirectAttributes redirect,Member m,Model model){
		String id = m.getId();
		String pw = m.getPw();
		String url = "";
		Member member = mService.findByIdAndPw(id,pw);
		System.out.println(member);
		if(member.getId() == null) {
			System.out.println("아이디 또는 패스워드가 없습니다. 다시 입력하세요.");
			redirect.addFlashAttribute("flag","1"); // redirect시 변수전달가능
			url = "redirect:/member/login";
		}else {
			System.out.println("로그인 성공.");
			session.setAttribute("session_id", member.getId());
			session.setAttribute("session_name", member.getName());
			redirect.addFlashAttribute("flag","1"); // redirect시 변수전달가능
			url = "redirect:/";
		}
		
		System.out.println("member : "+member);
		
		return url;
	}
	
	@GetMapping("/insert01")
	public String insert(){
		return "member/insert01";
	}
	@GetMapping("/insert02")
	public String insert02(){
		return "member/insert02";
	}
	
	@PostMapping("/member/insert02") //회원가입02 저장
	public String insert02(
			@RequestParam("phone1") String phone1,
			@RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3, Member m
			) {
		
		//Member - id,pw,name,phone,gender,hobby
		// Member 저장
		String phone = phone1+"-"+phone2+"-"+phone3;
		m.setPhone(phone);
		mService.save(m);
		System.out.println("MemberController : 회원정보 저장");
		return "redirect:/member/insert03";
	}
	
	//ajax -> json데이터 전송
	@ResponseBody
	@PostMapping("/idBtn") // 중복id확인
	public String idBtn(Member m) {
		System.out.println("controller id : "+m.getId());
		Member member = mService.findById(m.getId());
		String flag="";
		if(member.getId() != null) {
			flag = "-1";
		}else {
			flag = "1";
		}
		
		return flag;
	}
	
	@GetMapping("/logout") //로그아웃
	public String logout(RedirectAttributes redirect) {
		session.invalidate(); //섹션모두삭제
		redirect.addFlashAttribute("flag","-1");
		return "redirect:/";
	}
		
	@GetMapping("/update") //회원정보수정
	public String update(@RequestParam("id") String id,Model model) {
		Member member =mService.findById(id);
		model.addAttribute("member",member);
		return "member/update";
	}
	
	@PostMapping("/update") //회원정보수정
	public String update(@RequestParam("phone1") String phone1,
			@RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3,
			Member m,RedirectAttributes redirect) {
		String phone = phone1+"-"+phone2+"-"+phone3;
		m.setPhone(phone);
		mService.save(m);
		redirect.addFlashAttribute("flag","2");
		
		return "redirect:/";
	}
	
	@GetMapping("/member/delete") //회원정보삭제
	public String delete(RedirectAttributes redirect) {
		String url = "";
		if (session.getAttribute("session_id") != null) {
			String id = (String)session.getAttribute("session_id");
			System.out.println("삭제 id : "+id);
			// 회원정보 삭제
			mService.delete(id);
			
			session.invalidate();
			redirect.addFlashAttribute("flag","3"); // 회원정보가 삭제되었습니다.
		}else {
			redirect.addFlashAttribute("flag","-2"); // 로그인이 되어 있지 않습니다. 로그인후 진행하세요.
		}
		return "redirect:/";
	}
	
	@GetMapping("/list") //회원정보리스트
	public String list(@PageableDefault(page=0,size=10)
						 @SortDefaults({ @SortDefault(sort="gender",direction = Sort.Direction.DESC),
						 @SortDefault(sort="name",direction = Sort.Direction.ASC)
							}) Pageable pageable,Model model) {
		Page<Member> memberPage = mService.findAll(pageable);
		
		List<Member> list = memberPage.getContent(); //페이지 정보없이 List만 가져오기
		System.out.println(memberPage);
		int nowPage = memberPage.getPageable().getPageNumber()+1; //현재페이지는 0부터 시작이여서 +1
		int maxPage = memberPage.getTotalPages()-1; //마지막 페이지
		int startPage = ((nowPage-1)/10)*10 + 1;
		int endPage = Math.min(startPage+10-1,memberPage.getTotalPages()-1);
		model.addAttribute("list",list);
		model.addAttribute("nowPage",nowPage);
		model.addAttribute("maxPage",maxPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		// List<Member> controller -> service -> serviceImpl -> Jpa
//		List<Member> list = mService.findAll();
//		model.addAttribute("list",list);
		return "member/list";
	}
}
