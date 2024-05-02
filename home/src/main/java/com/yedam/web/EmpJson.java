package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.EmpDAO;
import com.yedam.vo.EmpVO;

@WebServlet("/empsave.json")
public class EmpJson extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//추가(add), 수정(edit), 삭제(delete) 기능(원래는 각각의 기능에 servlet이 있으면 좋아)
		//삭제기능(사원번호 emp.html에서 파라미터 수신)
		String job = req.getParameter("job"); //Parameter 매개변수 job의 매개변수 가져와줘 job에 추가 수정 삭제가 들어갈수있다 
		String eno = req.getParameter("empNo"); //이렇게 3개 왜 위로 보내셨지..?
		String c = req.getParameter("salary");
		String e = req.getParameter("email");
		System.out.println(job);
		System.out.println(eno);
		System.out.println(c);
		System.out.println(e);
		
		EmpDAO edao = new EmpDAO();
		EmpVO evo = new EmpVO();
		
		Map<String, Object> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		
		if(job.equals("add")) {
			String a = req.getParameter("name"); //앞의 a는 그냥 변수이름인거고 뒤가 중요해
			String b = req.getParameter("phone");
			String d = req.getParameter("hire");
			
			evo.setEmail(e);
			evo.setEmpName(a);
			evo.setEmpPhone(b);
			evo.setHireDate(d);
			evo.setSalary(Integer.parseInt(c));
			
			
			if(edao.insertEmp(evo)) {
				//성공했을때
				map.put("retCode", "OK"); //json으로 바꿔주기 위해서
				map.put("retVal", evo);
				
				//System.out.println(evo.toString());
				resp.getWriter().print(gson.toJson(map)); //키:밸류(map)
			}else {
				map.put("retCode", "NG");
				map.put("retVal", null);
				
				resp.getWriter().print(gson.toJson(map));
			}
			//서블릿만들었고..
			
			//수정,삭제
		}else if(job.equals("edit")) {
			evo.setEmpNo(Integer.parseInt(eno)); 
			evo.setSalary(Integer.parseInt(c));
			evo.setEmail(e);
			
			if(edao.updateEmp(evo)) { //성공값 /empDAO와 왔다갔다
				evo = edao.selectEmp(evo.getEmpNo());
				map.put("retCode", "OK"); 
				map.put("retVal", evo);
			}else {
				map.put("retCode", "NG");
				map.put("retVal", null);
			}
			resp.getWriter().print(gson.toJson(map)); 
			
		}else if(job.equals("delete")){
			eno = req.getParameter("empNo"); //getParameter 얘는 무조건 string타입이라 /?뒤의 값이 empNo말하는거같은데..
			
			if(edao.deleteEmp(Integer.parseInt(eno))) { //이렇게 해야지 정수 타입으로 가져올수있음 /true,false if
				//{"retCode": "OK"}
				resp.getWriter().print("{\"retCode\": \"OK\"}"); //(응답)출력스트림
			}else {
				//{"retCode": "NG"}
				resp.getWriter().print("{\"retCode\": \"NG\"}"); 		
			}
		} //end of if

	}
}
