package com.brancoder.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brancoder.demo.dao.MemberRepository;
import com.brancoder.demo.model.MemberAccount;
import com.brancoder.demo.model.MemberAccountJPA;
import com.brancoder.demo.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	
	@Autowired
	DataSource dataSource;
	
	
    @RequestMapping("/hello/")
    public String hello(){

        return "hello";
    }

	@GetMapping("/member/addMemberJDBC")
    public String addMemberJDBC(){
		
    	MemberAccount memberAccount = new MemberAccount();
    	memberAccount.setPassword("12345678");
    	memberAccount.setEmail("test@gmail.com");
    	memberAccount.setCellphone("0912345789");
    	memberAccount.setAddress("台北市");
    	memberService.addMember(memberAccount);
		
        return "addMemberSuccess";
    }  
    
  
}
