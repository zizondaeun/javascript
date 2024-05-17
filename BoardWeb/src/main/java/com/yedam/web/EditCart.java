package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.CartVO;

public class EditCart implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String qty = req.getParameter("qty");
		
		CartVO cvo = new CartVO();
		cvo.setNo(Integer.parseInt(no));
		cvo.setQty(Integer.parseInt(qty));
		
		ReplyService svc = new ReplyServiceImpl();
		if(svc.modifyCart(cvo)) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		}else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");			
		}
		
		
	}

}
