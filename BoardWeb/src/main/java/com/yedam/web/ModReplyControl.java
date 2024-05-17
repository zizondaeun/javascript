package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ModReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rno = req.getParameter("rno");
		String reply = req.getParameter("reply");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setReplyNo(Integer.parseInt(rno));
		rvo.setReply(reply);
		System.out.println(rvo);

		Map<String, Object> result = new HashMap<>();

		ReplyService svc = new ReplyServiceImpl();

		if (svc.modReply(rvo)) {
			result.put("retCode", "OK");
			// result.put("retVal", rvo);
		} else {
			result.put("retCode", "NG");
			// result.put("retVal", null);
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);

		resp.getWriter().print(json);

	}

}
