package com.yedam.myserver.users.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.users.mapper.UserMapper;
import com.yedam.myserver.users.vo.UserVO;

@CrossOrigin(origins = "*", allowedHeaders = "*",  maxAge = 3600)
@RestController
public class UserController {

	@Autowired UserMapper mapper;
	
	@GetMapping("/userSelectAll")
	public List<UserVO> userSelect() {
		return mapper.find();
	}
	
	@GetMapping("/userSelect")
	public UserVO userSelectList(UserVO vo) {
		return mapper.findById(vo);
	}
		
	@PostMapping("/userInsert")
	public UserVO userInsert(UserVO vo) {
		 mapper.persist(vo);
		 return vo;
	}
	
	@PutMapping("/userUpdate")
	public UserVO userUpdate(@RequestBody UserVO vo) {
		 mapper.merge(vo);
		 return vo;
	}	
	@GetMapping("/userDelete")
	public UserVO userDelete(UserVO vo) {
		 mapper.remove(vo);
		 return vo;
	}		
}
