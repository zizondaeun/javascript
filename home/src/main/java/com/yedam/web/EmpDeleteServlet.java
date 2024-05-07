package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;

@WebServlet("/deleteEmp.json")
public class EmpDeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//deleteEmp.json?eno=101
		String eid = req.getParameter("eno"); //eno라는 파마미터를 활용하겠다
		int eno = Integer.parseInt(eid);
		
		EmpDAO edao = new EmpDAO();
		if (edao.deleteEmployee(eno)) { //empDAO 의 deleteEmployee로 가는거
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
		
	}
}
