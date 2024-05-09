package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control { 

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //서비스 기능
		//title,content,writer 이 세가지 파라미터를 db에 넣기위함(insert)
		String title = req.getParameter("title"); //addBoard.jsp의 name의 값과 같아야함
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		//서비스선언
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		if(svc.addBoard(vo)) { //어제의 mapper.insertEmp
			System.out.println("등록성공");
			//페이지 이동: 목록페이지
			resp.sendRedirect("main.do");
		}else {
			System.out.println("등록실패");
			//페이지 재지정
			resp.sendRedirect("addForm.do"); 
		}
	}

}
