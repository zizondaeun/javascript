package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id,pw 파라미터 여기서 만들어 (로그인되면, 안되면)
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		BoardService svc = new BoardServiceImpl();
		MemberVO mvo = svc.login(id,pw);
		
		if(mvo != null) {
			HttpSession session = req.getSession(); //웹 브라우저의 세션을 담으려고..?
			session.setAttribute("logId", mvo.getUserId()); //세션 값이 성공하면 
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("logForm.do");
			//System.out.println("처리실패"); 
		}
	}

}
