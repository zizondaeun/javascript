package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.ABCControl;
import com.yedam.web.AddEmpControl;
import com.yedam.web.InfoControl;
import com.yedam.web.RegisterControl;

public class FrontController extends HttpServlet{
	//필드선언
	Map<String, Control> map;
	
	//생성자
	public FrontController() {
		map = new HashMap<>();
	}
	//init
	@Override
	public void init(ServletConfig config) throws ServletException {
		//url 패턴과 실행할 control 인터페이스의 구현클래스를 정의 
		map.put("/abc.do", new ABCControl()); ///abc.do가 들어오면 클래스 실행해줘
		map.put("/info.do", new InfoControl());
		map.put("/addEmp.do", new AddEmpControl());
		map.put("/registerEmp.do", new RegisterControl()); //웹 열때 끝에 입력해야 볼수있는거(제한하는거)!!!
	}
	//service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청정보의 한글처리
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri: " + uri + ", context: " + context);
		String path = uri.substring(context.length());
		System.out.println("path: " + path);
		
		Control control = map.get(path); //control = new AddEmpControl
		control.exec(req, resp); //여기서 exec는 control 상속받은 addempcontrol의 재정의된 exec임
		//서비스의 req,resp를 가지고 exec를 실행해
	}
	//destroy
	@Override
	public void destroy() {
		
	}
}
