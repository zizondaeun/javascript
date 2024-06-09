package com.yedam.myserver.chat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.chat.mapper.ChatMapper;
import com.yedam.myserver.chat.vo.ChatVO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",  maxAge = 3600)
public class ChatController {

	@Autowired ChatMapper mapper;
	
	@GetMapping("/chat")
	public List<ChatVO> chatSelect(ChatVO vo) {
		return mapper.findAll(vo);
	}
	
	/*
	 * @GetMapping("/chat/{no}") public List<ChatVO>
	 * chatSelectNo(@PathVariable("no") String no, ChatVO vo) { vo.setNo(no); return
	 * mapper.findAll(vo); }
	 */
	
	@GetMapping("/chat/{dttm}")
	public List<ChatVO> chatSelectDttm(@PathVariable("dttm") String dttm, ChatVO vo) {
		vo.setDttm(dttm);
		return mapper.findAll(vo);
	}
	
	@PostMapping("/chat")
	public ChatVO todoInsert(ChatVO vo) {
		 mapper.persist(vo);
		 return vo;
	}
}
