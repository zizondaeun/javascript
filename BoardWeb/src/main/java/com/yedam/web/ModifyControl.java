package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno, title, content 파라메터 이렇게 3개가 넘어옴
		//수정이 완료되면 목록으로 이동
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setTitle(title);
		vo.setContent(content);

		if(svc.modifyBoard(vo)) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("modBoardForm.do"); 
		}
	}

}
