package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/greet")
	public String greet(Model model) {
		model.addAttribute("msg","Good morning...!!");
		return "index";
	}
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("msg","Welcome using Thymeleaf");
		return "index";
	}
}
