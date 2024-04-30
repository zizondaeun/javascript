package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;

//웹 프로그램 -> url 실행 -> 서블릿(java)
//init(최초실행) -> service(실행) -> destroy(종료시) :우린 서비스 메소드에만 구현했음
//제어의 역전 
@WebServlet("/empList.action") //웹에 http://localhost:8080/home에 붙여넣으면 자바코드 실행됨-데이터베이스 정보를 가져와서 
public class EmpListServlet extends HttpServlet { //servlet 클래스 서블릿이 무엇인가,왜
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //요청과 응답
		//web browser에 출력
		//출력하는 컨텐트 타입
		resp.setContentType("text/html;charset=utf-8"); //text/html;charset=utf-8
		PrintWriter out = resp.getWriter(); //문자기반의 스트림(출력스트림)
		
		EmpDAO edao = new EmpDAO();
		List<Map<String, Object>> list = edao.empList();
		for(Map<String, Object> map : list) {
			System.out.println("----------------");
			System.out.println("사원번호: " + map.get("사원번호") + ", 사원이름: " + map.get("사원이름")); //이거는 콘솔창에 나오는거고
			out.print("<p>사원번호: " + map.get("사원번호") + "</p>"); //서버에 나오게끔
			out.print("<p>사원이름: " + map.get("사원이름") + "</p>"); 
			out.print("<p>연락처: " + map.get("연락처") + "</p>"); 
		}
		System.out.println("end of list.");
	}
}
