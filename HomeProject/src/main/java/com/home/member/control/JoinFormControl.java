package com.home.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;

public class JoinFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/view/member/joinForm.jsp";
		path = "member/joinForm.tiles";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
