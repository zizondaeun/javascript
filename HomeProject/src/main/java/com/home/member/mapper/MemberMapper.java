package com.home.member.mapper;

import org.apache.ibatis.annotations.Param;

import com.home.member.vo.MemberVO;

public interface MemberMapper {
	//등록기능
	int insertMember(MemberVO vo);
	//로그인 id,pw맞는지 확인
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	//멤버가 맞는지 확인(id)
	MemberVO selectMember2(String id);

}
