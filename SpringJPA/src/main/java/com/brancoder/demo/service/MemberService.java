package com.brancoder.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brancoder.demo.dao.MemberDao;
import com.brancoder.demo.model.MemberAccount;



@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;

	public void addMember(MemberAccount memberAccount) {
		memberDao.addMember(memberAccount);
	}
}
