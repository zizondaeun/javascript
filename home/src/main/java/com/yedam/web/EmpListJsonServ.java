package com.yedam.web;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.EmpDAO;
import com.yedam.vo.EmpVO;

@WebServlet("/empJson.json")
public class EmpListJsonServ extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사원목록을 json문자열로 출력.
		//Gson 라이브러리 활용해서 json생성
		
		resp.setContentType("text/json;charset=utf-8"); //한글 인코딩 하기위해
		
		EmpDAO edao = new EmpDAO();
		List<EmpVO> elist = edao.selectList(); //elist 라는 자바 객체 컬렉션
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(elist); 
		
		//System.out.println(json);
		resp.getWriter().println(json); //json 형태로 웹브라우저 출력 /한글 인코딩 전이라 위에서
		
		//여기의 반환값을 emp.js로 넘어가(html,servlet,dao 이렇게 필요해)

	}
}

