package com.yedam.web;

import java.io.IOException;
import java.net.URLEncoder;

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
		req.setCharacterEncoding("utf-8");
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardVO vo = new BoardVO();		
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setTitle(title);
		vo.setContent(content);

		BoardService svc = new BoardServiceImpl();
		String encodeKW = URLEncoder.encode(kw, "UTF-8"); //한글 encoding 처리 /keyword가 영어일때는 url에 값이 넘어가는데 한글일때는 값이 안넘어가서 추가한거
		if(svc.modifyBoard(vo)) { //수정
			resp.sendRedirect("main.do?page=" + page + "&searchCondition=" + sc + "&keyword=" + encodeKW); //질의문자형(query string)
		}else {
			resp.sendRedirect("처리 중 에러"); 
		}
	}

}
