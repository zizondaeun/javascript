package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.HttpUtils;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchVO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class MainControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //목록보여주는거
		// main.do => WEB-INF/board/boardList.jsp
		String path = "WEB-INF/board/boardList.jsp";
		path = "board/boardList.tiles"; //타일즈에 적용되도록 각 control에 
		
		SearchVO search = new SearchVO();
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		page = page == null ? "1" : page; //페이지없으면(= page 파라메터가 없더라도) 1페이지를 보여주도록
		search.setPage(Integer.parseInt(page)); 
		search.setKeyword(kw); //목록을 가져오는데 조회조건
		search.setSearchCondition(sc);
		
		BoardService svc = new BoardServiceImpl();
		
		List<BoardVO> list = svc.boardList(search); //목록
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), svc.getTotal(search)); //건수(페이지..) /256
		//System.out.println(pageDTO + "898989");
		System.out.println(svc.getTotal(search) + "9000");
		//jsp 페이지에 정보 전달
		req.setAttribute("boardList", list);
		req.setAttribute("paging", pageDTO);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		//req.getRequestDispatcher(path).forward(req, resp); /이게 있어야 페이지 이동을 하지~!
		HttpUtils.forward(req, resp, path); //페이지이동
	}
	
}
