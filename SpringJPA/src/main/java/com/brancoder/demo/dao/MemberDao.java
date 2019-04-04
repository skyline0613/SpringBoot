package com.brancoder.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brancoder.demo.model.MemberAccount;


//新增Repository類
@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void addMember(MemberAccount memberAccount){
		System.out.println("EXCUTE INSERT MEMBER");
		int idVal= (Integer)jdbcTemplate.queryForObject("select next_val as id_val from hibernate_sequence for update", Integer.class);
		
		  
		  jdbcTemplate.update("update hibernate_sequence set next_val= ? where next_val=?"
			  		+ "",idVal+1,idVal);		  
	  jdbcTemplate.update("INSERT INTO MEMBER_ACCOUNT(ID,ACCOUNT,PASSWORD, EMAIL, ADDRESS,CELLPHONE,CREATE_DATE) "
	  		+ "VALUES (?,?,?,?,?,?,NOW())",idVal+1,memberAccount.getAccount() ,memberAccount.getPassword(), memberAccount.getEmail(),
	  		memberAccount.getAddress(),memberAccount.getCellphone());
  }
}

