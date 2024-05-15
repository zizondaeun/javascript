package com.home.member.service;

import org.apache.ibatis.session.SqlSession;

import com.home.common.DataSource;
import com.home.member.mapper.MemberMapper;
import com.home.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	SqlSession session = DataSource.getInstance().openSession(true); 
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public boolean addMember(MemberVO vo) {
		return mapper.insertMember(vo) == 1;
	}

}
