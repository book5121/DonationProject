package com.springstudy.ch04.dao;

import org.springframework.stereotype.Repository;

@Repository
public class FirstMvcDaoImpl implements FirstMvcDao {

	@Override
	public String getMessage(int no, String id) {
		
		String msg = null;
		
		if(id.equals("spring")) {
			msg = "yes, yes ! - " + no;
		} else {
			msg = "YES, YES ! - " + no;
		}
		
		return msg;
	}
}
