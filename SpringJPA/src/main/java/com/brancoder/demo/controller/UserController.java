package com.brancoder.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brancoder.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/MyFirstPage")
	public String greeting(@RequestParam(value = "title", required = false, defaultValue = "brancoder") String title,
			Model model) {
		model.addAttribute("name", title);
		return "index";
	}
	private String message = "鐵人賽第七天加油!!!";
	 
	@GetMapping("/user/")
	public String index(Map<String, Object> model) {
	 	model.put("ID", userService.getUserId());
		return "index";
	}
}