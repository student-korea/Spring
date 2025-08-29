package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // Controller중 제일 먼저 실행이 됨.
//@RestController
@Controller	
public class ExceptionController {
	// IllegalArgumentException발생된 에러페이지에 getMessage() 전달함.
	
	@ExceptionHandler(Exception.class)
	public String handleArgumentException(
			Exception e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public String handleArgumentException(
			ArithmeticException e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
	// IllegalArgumentException발생된 에러페이지에 getMessage() 전달함.
	@ExceptionHandler(IllegalArgumentException.class)
	public String handleArgumentException(
			IllegalArgumentException e,Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
}
