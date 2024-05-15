package com.home.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.member.control.JoinControl;
import com.home.member.control.JoinFormControl;
import com.home.product.control.MainControl;
import com.home.product.control.ProductInfoControl;

public class FrontController extends HttpServlet {
	//필드
	Map<String, Control> map;
	
	//생성자
	public FrontController() {
		map = new HashMap<>();
	}
	
	//메소드
	//init-서블릿 초기화 메소드(딱 한번만 호출)
	@Override
	public void init(ServletConfig config) throws ServletException {
		//.do 라는 url 요청이 들어오면, control 클래스의 인스턴스가 실행됨
		map.put("/main.do", new MainControl()); //상품목록
		map.put("/productInfo.do", new ProductInfoControl()); //상품상세화면
		map.put("/joinForm.do", new JoinFormControl()); //이동
		map.put("/join.do", new JoinControl()); //작성
		
	}
	
	//service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); 

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri: " + uri + ", context: " + context);
		String path = uri.substring(context.length());
		System.out.println("path: " + path);
	    
		Control control = map.get(path); //Control control = new -Control()
		control.exec(req, resp); // 여기서 exec는 control 상속받은 -control의 재정의된 exec임
		// 서비스의 req,resp를 가지고 exec를 실행해
	}
	
	//destroy
	@Override
	public void destroy() {
		
	}
}
