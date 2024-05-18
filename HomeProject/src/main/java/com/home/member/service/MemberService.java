package com.home.member.service;

import com.home.member.vo.MemberVO;

public interface MemberService {
	//회원가입
	boolean addMember(MemberVO vo);
	//로그인
	MemberVO login(String id, String pw);
	//멤버(id)가 맞는지 체크
	MemberVO checkMember(String id);
	

	
}
