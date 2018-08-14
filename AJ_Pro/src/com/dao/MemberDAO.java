package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public int MemberAdd(SqlSession session, MemberDTO dto) {
		int n = session.insert("com.member.memberAdd",dto);
		return n;
	}
	
	public MemberDTO MemberLogin(SqlSession session, HashMap<String, String> map) {
		MemberDTO n = session.selectOne("com.member.memberLogin",map);
		return n;
	}
	
}
