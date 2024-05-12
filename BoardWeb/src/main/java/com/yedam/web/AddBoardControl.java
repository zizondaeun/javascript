package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class AddBoardControl implements Control { 

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //서비스 기능
		//title,content,writer 이 세가지 파라미터를 db에 넣기위함(insert)
		//multipart 요청처리를 위한 처리 (1.request정보 2.저장경로 3.max사이즈 4.인코딩 5.리네임정책)
		String savePath = req.getServletContext().getRealPath("images"); //이미지 파일경로 /젤 상위를 가져옴..
		int maxSize = 5 * 1024 *1024; //최대 5메가
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
		
		String title = mr.getParameter("title"); //addBoard.jsp의 name의 값과 같아야함
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("myImg");
		
		//서비스선언
		BoardService svc = new BoardServiceImpl();
		
		//실제아이디가 맞는지 체크기능
		MemberVO mvo = svc.checkMember(writer);
		if(mvo == null) {
			req.setAttribute("message", "권한이 없습니다");
			req.getRequestDispatcher("WEB-INF/board/addBoard.jsp").forward(req, resp);
			return;
		}
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setImg(img);
		
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
