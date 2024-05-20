package com.yedam.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.CenterVO;

public class RegisterCenter implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//json문자열 -> 자바 객체로 바꾸고 -> 이 자바 객체를 매퍼 처리
		ServletInputStream sis = req.getInputStream(); //입출력하기 위한 서블릿
		String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8); //라이브러리를 이용해서 스트림을 문자열로 바꾼거
		System.out.println(json);
		
		ObjectMapper mapper = new ObjectMapper(); //자바객체로 바꿔주는 라이브러리
		CenterVO[] centers = mapper.readValue(json, CenterVO[].class);
		
		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.addCenter(centers);
		
		//처리된 건수 반환
		resp.getWriter().print(cnt);
		
		
	}

}
