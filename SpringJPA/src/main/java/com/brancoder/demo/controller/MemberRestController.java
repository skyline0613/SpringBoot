package com.brancoder.demo.controller;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brancoder.demo.dao.MemberRepository;
import com.brancoder.demo.model.MemberAccountJPA;

@RestController
public class MemberRestController {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	DataSource dataSource;

	
	
	@Transactional(readOnly = true)
	@GetMapping("/memberAccountRest/listMember")
	public List<MemberAccountJPA> getMemberList(){

		return memberRepository.findAll();	
	}
    
	@GetMapping("/memberAccountRest/addMember")
    public MemberAccountJPA addMember(){
		

		MemberAccountJPA memberAccount = new MemberAccountJPA();
		memberAccount.setAddress("Taipei");
		memberAccount.setCellphone("0912123456");
		memberAccount.setPassword("123456");
		memberAccount.setEmail("xyz@gmail.com");
		memberAccount.setCreateDate(new Date());
		memberAccount = memberRepository.save(memberAccount);
		
        return memberAccount;
    }    
}
