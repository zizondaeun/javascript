package com.yedam.myserver.chat.mapper;

import java.util.List;

import com.yedam.myserver.chat.vo.ChatVO;



public interface ChatMapper {
	public List<ChatVO> findAll(ChatVO vo);
	public void persist(ChatVO vo);
} 
