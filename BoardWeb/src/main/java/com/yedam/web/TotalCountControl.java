package com.yedam.web;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class TotalCountControl implements Control{
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException{
		String bno = req.getParameter("bno");
		//service, mapper
		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.getReplyCnt(Integer.parseInt(bno));
		
		//{totalCount: 10}
		resp.getWriter().print("{\"totalCount\": " + cnt + "}");
	}
}
