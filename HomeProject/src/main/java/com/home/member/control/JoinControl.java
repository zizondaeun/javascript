package com.home.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.member.service.MemberService;
import com.home.member.service.MemberServiceImpl;
import com.home.member.vo.MemberVO;

public class JoinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		System.out.println(id);
		
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pw);
		vo.setUserName(name);
		vo.setUserPhone(phone);
		
		MemberService svc = new MemberServiceImpl();
		
		if(svc.addMember(vo)) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("joinForm.do");
		}
		
	}

}
