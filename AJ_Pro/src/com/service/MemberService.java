package com.service;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {

	private MemberDAO dao;
	public MemberService() {
		dao = new MemberDAO();
	}
	
	public int MemberAdd(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		
		try {
			n = dao.MemberAdd(session,dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int MemberLogin(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
	
		try {
			n = dao.MemberLogin(session,dto);
		}finally {
			session.close();
		}
		return n;
	}
}
