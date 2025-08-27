package com.site.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {
	
	@Autowired BService bService;
	@GetMapping("/bList")
	public String bList(@RequestParam(name="page",defaultValue = "1") int page,@RequestParam(name="flag",defaultValue = "0") String flag,Model model) {
		Map<String, Object> map = bService.findAll(page);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("page",map.get("page"));
		model.addAttribute("maxpage",map.get("maxpage"));
		model.addAttribute("startpage",map.get("startpage"));
		model.addAttribute("endpage",map.get("endpage"));
		return "bList";
	}
	
	@GetMapping("/bView/{bno}")
	public String bView(@PathVariable("bno") int bno, Model model) {
		Board bo = bService.findByBno(bno);
		model.addAttribute("board",bo);
		return "bView";
	}
	
	@GetMapping("/bWrite")
	public String bWrite() {
		return "bWrite";
	}
	
	@PostMapping("bWrite")
	public String bWrite(Board b,
			@RequestPart("file") MultipartFile file) {
		b.setBfile(""); //null경우 에러가 나서, 빈공백을 추가
		//파일첨부가 되어 있어야 진행
		if(!file.isEmpty()) {
			// 원본파일이름 가져오기
			String originFileName = file.getOriginalFilename();
			// 동일이름이 생기지 않도록 시간을 이름에 추가
			long time = System.currentTimeMillis();
			// 1.jpg -> 48459848493939_1.jpg
			String uploadName = String.format("%d_%s", time,originFileName);
			// 파일저장위치
			String fileLocation = "c:/upload/";
			File f = new File(fileLocation+uploadName); //c:upload/48459848493939_1.jpg 
			b.setBfile(uploadName); //board객체의 bfile 이름추가
			try { file.transferTo(f); //파일업로드 진행
			} catch (Exception e) { e.printStackTrace(); } 
		}
		// 파일첨부가 없으면 글만 저장
		bService.save(b);
		return "redirect:/bList?flag=1"; //flag=1-글쓰기 성공
	}
	
	@GetMapping("/bDelete/{bno}")
	public String bDelete(@PathVariable("bno") int bno) {
		bService.delete(bno);
		System.out.println(bno);
		return "redirect:/bList?flag=-1";
	}
	
	@GetMapping("/bUpdate/{bno}")
	public String bUpdate(@PathVariable("bno") int bno,Model model) {
		Board board = bService.findByBno(bno);
		model.addAttribute("board",board);
		return "bUpdate";
	}
	
	@PostMapping("/bUpdate")
	public String bUpdate(Board b, @RequestParam("bfile2") String bfile2) {
		// 첨부된 파일이 없으면 기존 첨부된 파일을 업데이트 함.
		if(b.getBfile() == "") {
			b.setBfile(bfile2);
		}
		bService.update(b);
		return "redirect:/bList?flag=2"; //flag=2 : 수정
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("category") String category,@RequestParam("sWord") String sWord,Model model) {
		System.out.println("");
		List<Board> list = bService.findByCaAndsW(category,sWord);
		return "list";
	}
}
