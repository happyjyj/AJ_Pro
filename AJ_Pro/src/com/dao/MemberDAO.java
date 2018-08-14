package com.dao;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public int MemberAdd(SqlSession session, MemberDTO dto) {
		int n = session.insert("com.member.memberAdd",dto);
		return n;
	}
	
	public int MemberLogin(SqlSession session, MemberDTO dto) {
		int n = session.selectOne("com.member.memberLogin",dto);
		return n;
	}
	
}
