package com.brancoder.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brancoder.demo.model.MemberAccountJPA;



public interface MemberRepository  extends JpaRepository<MemberAccountJPA, Long>{
	
	List<MemberAccountJPA> findAll();
	
	List<MemberAccountJPA> findByEmail(String email);

}