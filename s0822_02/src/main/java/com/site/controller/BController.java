package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {
	
	@Autowired BService bService;
	@GetMapping("/bList")
	public String bList(@RequestParam(name="flag",defaultValue = "0") String flag,Model model) {
		List<Board> list = bService.findAll();
		model.addAttribute("list",list);
		model.addAttribute("flag",flag);
		return "bList";
	}
	
	@GetMapping("/bView")
	public String bView(Board board, Model model) {
		int bno = board.getBno();
		Board bo = bService.findByBno(bno);
		model.addAttribute("board",bo);
		return "bView";
	}
	
	@GetMapping("/bWrite")
	public String bWrite() {
		
		return "bWrite";
	}
	
	@PostMapping("/bWrite")
	public String bWrite(Board board,Model model) {//post 면 board는 받은 data
		System.out.println(board.getBtitle());
		System.out.println(board.getId());
		System.out.println(board.getBcontent());
		System.out.println(board.getBfile());
		bService.save(board);
		return "redirect:/bList?flag=1";
	}
	
	@GetMapping("/bDelete")
	public String bDelete(@RequestParam(name="bno",defaultValue="0") int bno) {
		bService.delete(bno);
		return "redirect:/bList?flag=2";
	}
	
	@GetMapping("/bUpdate")
	public String bUpdate(@RequestParam(name="bno",defaultValue="0") int bno,Model model) {
		System.out.println(bno);
		Board board = bService.findByBno(bno);
		model.addAttribute("board",board);
		return "bWrite";
	}
		
	
}
