package com.home.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.common.Control;
import com.home.member.service.MemberService;
import com.home.member.service.MemberServiceImpl;
import com.home.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		MemberVO vo = svc.login(id,pw);
		
		if(vo != null) { //vo가 값이 있으면
			HttpSession session = req.getSession(); //req의 세션을 가져와서 세션에 담아
			session.setAttribute("logId", vo.getUserId()); //세션 속성을 vo의 아이디..
			//관리자인지 일반회원인지 구분
			if(vo.getUserResp().equals("Admin")) //vo의 권한이 관리자이면
				//resp.sendRedirect("admin.do"); //관리자의 회원목록창으로
				resp.sendRedirect("main.do"); //관리자의 일단은 메인으로 가..
			else
				resp.sendRedirect("main.do"); //일반회원이면 메인화면으로
		}else {
			resp.sendRedirect("logForm.do"); //로그인정보가 없으면 다시 로그인창으로
		}
	}

}
