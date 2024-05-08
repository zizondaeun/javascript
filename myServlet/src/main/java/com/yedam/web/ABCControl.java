package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.EmpMapper;
import com.yedam.vo.EmployeeVO;

public class ABCControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8"); //한글도 나오게
		//System.out.println("abc 호출됨");
		//String param1 = req.getParameter("name"); //요청정보
		//String param2 = req.getParameter("age");
		String eno = req.getParameter("eno");
		
		SqlSession session = DataSource.getInstance().openSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		
		EmployeeVO evo = mapper.getEmployee(Integer.parseInt(eno)); //eno가 스트링타입이라 int타입으로 변경필요해서
		
		PrintWriter out = resp.getWriter(); //getWriter가 사용자 화면/응답정보
		out.print("<p>사원번호: " + evo.getEmployeeId() + "</p>"); //http://localhost:8080/mySevlet/abc.do?name=Hong&age=20
		out.print("<p>이름: " + evo.getFirstName() + "-" + evo.getLastName() + "</p>"); //서블렛에서는 보통 태그 안써
		
		
	}
}
