package com.yedam.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;

@WebServlet("/empList.json")
public class EmpListJson extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		//json 문자열
		//{"name": "홍길동", "age": 20} 데이터베이스를 주고받고 할때 문자열이 가장 편한데 텍스트로 주고받기위해 (속성을) 문자열 방식으로 바꾸겠다(서버<->클라이언트) 
		//String json = "[{\"name\": \"홍길동\", \"age\": 20},{\"name\": \"김길동\", \"age\": 21}]";
		EmpDAO edao = new EmpDAO();
		List<Map<String, Object>> list = edao.empList();
		
		String json = "[";
		for(int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			json += "{\"empNo\":" + map.get("사원번호") //이거 공식이야..? 왜 꼭 이렇게 적어야 나오는거야?(pretty print적용)
					+ ",\"empName\":\"" + map.get("사원이름") //json 문자열이라서 이렇게 적는거라고 하심
					+ "\",\"phone\":\"" + map.get("연락처")
					+ "\",\"email\":\"" + map.get("이메일") 
					+ "\"}";
			if((i+1) != list.size()){ //배열이 0 포함하니까 +1 
				json += ","; //끝나는게 아니면 ',' 붙여준다
			 
			}
		}
		json += "]";
		
		resp.getWriter().print(json); //문자출력하는거-json을 ../empList.json로 반환한다
	}
}
