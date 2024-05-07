package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.EmpDAO;

@WebServlet("/empdatatable.json") //url /json이 잘나오는지 먼저 확인해보는거야
public class EmpDataTableServ extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDAO edao = new EmpDAO();
		List<List<String>> list = edao.getDataTable();
		
		Map<String, Object> map = new HashMap<>();
		map.put("data", list); //배열 안에 배열 data:key, value:[]
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //이쁜 모양으로 출력하려면 setPrettyPrinting()
		System.out.println(gson);
		String json = gson.toJson(map);
		
		//System.out.println(json); //json 이쁘게 나오는지 확인하고 웹에서 확인해보기
		resp.getWriter().println(json);
	}
		
	
}
