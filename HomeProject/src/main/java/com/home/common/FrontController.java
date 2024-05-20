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
import com.home.member.control.LoginControl;
import com.home.member.control.LoginFormControl;
import com.home.member.control.LogoutControl;
import com.home.orders.control.OrderDeleteControl;
import com.home.orders.control.OrderListControl;
import com.home.orders.control.OrderProductControl;
import com.home.product.control.AddFormControl;
import com.home.product.control.AddProductControl;
import com.home.product.control.DeleteControl;
import com.home.product.control.MainControl;
import com.home.product.control.ModifyControl;
import com.home.product.control.ModifyFormControl;
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
		map.put("/productInfo.do", new ProductInfoControl()); //상품상세화면 이동
		//회원가입
		map.put("/joinForm.do", new JoinFormControl()); //회원가입창으로 이동
		map.put("/join.do", new JoinControl()); //회원가입 작성
		//로그인
		map.put("/logForm.do", new LoginFormControl()); //로그인창으로 이동
		map.put("/login.do", new LoginControl()); 
		//로그아웃
		map.put("/logout.do", new LogoutControl()); 
		//관리자용
		map.put("/addForm.do", new AddFormControl()); //상품등록페이지로 이동
		map.put("/addProduct.do", new AddProductControl()); //상품등록
		map.put("/modProductForm.do", new ModifyFormControl()); //상품수정페이지로 이동
		map.put("/updateProduct.do", new ModifyControl()); //상품수정
		map.put("/deleteProduct.do", new DeleteControl()); //상품삭제
		//주문관련
		map.put("/orderProduct.do", new OrderProductControl()); //상품주문페이지로 이동
		map.put("/orderList.do", new OrderListControl()); //주문목록
		map.put("/orderDelete.do", new OrderDeleteControl()); //상품삭제
		
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
