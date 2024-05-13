package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //이거는 화면만 열어주는거
		String path = "WEB-INF/board/addBoard.jsp"; //보드 밑에 addBoard.jsp만듦
		path = "board/addBoard.tiles"; //보드의 하위 addBoard.tiles를 열어줘/타일쓰려고
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
