package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.EmpMapper;
import com.yedam.vo.EmployeeVO;

public class InfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //사용자가 요청한 정보를 갖고 있는 객체:req
		System.out.println("info 호출됨");
		// /info.do를 입력하면 실행하는 클래스(FrontController의)
		//서블릿의 정보 -> jsp 페이지 출력(페이지 재지정)
		//info.do -> info.jsp 요청 재지정
		//전달해야할 값은 req에 담아
		req.setAttribute("req", req);
		req.setAttribute("name", "홍길동");
		
		SqlSession session = DataSource.getInstance().openSession(true); //true 가 커밋
		EmpMapper mapper = session.getMapper(EmpMapper.class); //목록가져오는 기능
		List<EmployeeVO> list = mapper.selectEmp(); //전체목록 다 가져오는기능 /맵퍼에서 호출한게 여기로 와 그리고 list에 담는거지
		req.setAttribute("elist", list); //list가 반환해주는 값을 "elist"가 받아
		
		//System.out.println("address: " + req);
		RequestDispatcher rd = req.getRequestDispatcher("info.jsp"); //요청을 다시 내보내는 메소드 /("info.jsp")재지정할 페이지
		rd.forward(req, resp);
	}

}
