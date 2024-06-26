package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.AddBoardControl;
import com.yedam.web.AddFormControl;
import com.yedam.web.AddReplyControl;
import com.yedam.web.BoardInfoControl;
import com.yedam.web.CartList;
import com.yedam.web.DelCart;
import com.yedam.web.EditCart;
import com.yedam.web.LoginControl;
import com.yedam.web.LoginForm;
import com.yedam.web.LogoutControl;
import com.yedam.web.MainControl;
import com.yedam.web.MemberListControl;
import com.yedam.web.ModReplyControl;
import com.yedam.web.ModifyControl;
import com.yedam.web.ModifyFormControl;
import com.yedam.web.ProductListControl;
import com.yedam.web.RegisterCenter;
import com.yedam.web.RemoveControl;
import com.yedam.web.RemoveFormControl;
import com.yedam.web.RemoveReplyControl;
import com.yedam.web.ReplyListControl;
import com.yedam.web.TotalCountControl;

//http://localhost:8080/BoardWeb/main.do
public class FrontController extends HttpServlet { //main.do누르면 frontcontroller실행되도록
	// 필드선언
	Map<String, Control> map;

	// 생성자
	public FrontController() {
		map = new HashMap<>();
	}

	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		// url 패턴과 실행할 control 인터페이스의 구현클래스를 정의
		map.put("/main.do", new MainControl()); //메인컨트롤 이동누르면 505오류떴었는데 메인컨트롤 클래스 만들어주고 경로 지정해주니까 게시글목록으로 이동가능해짐
		//map.put("/boardList.do", new BoardListControl());
		map.put("/addForm.do", new AddFormControl()); //글등록화면
		map.put("/addBoard.do", new AddBoardControl()); //등록기능
		map.put("/boardInfo.do", new BoardInfoControl()); //조회화면/상세화면 /이동
		//수정관련
		map.put("/modBoardForm.do", new ModifyFormControl()); //수정화면 
		map.put("/updateBoard.do", new ModifyControl()); //업데이트랑 목록 /진짜 수정
		//삭제관련
		map.put("/removeBoardForm.do", new RemoveFormControl());
		map.put("/deleteBoard.do", new RemoveControl());
		//로그인 관련
		map.put("/logForm.do", new LoginForm());
		map.put("/login.do", new LoginControl());
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		
		//댓글관련
		map.put("/replyList.do", new ReplyListControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/getTotalCnt.do", new TotalCountControl());
		map.put("/modReply.do", new ModReplyControl());
		
		//관리자권한 
		map.put("/memberList.do", new MemberListControl());
		
		//상품관련
		map.put("/productList.do", new ProductListControl());
		
		//장바구니 관련
		map.put("/cartList.do", new CartList()); //목록
		map.put("/editCart.do", new EditCart()); //수량변경
		map.put("/delCart.do", new DelCart()); //삭제
		
		//센터 데이터 생성
		map.put("/registerCenter.do", new RegisterCenter());
		
		
	}

	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8"); // 요청정보의 한글처리 /filter해둬서 이제 따로 없어도 된대

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri: " + uri + ", context: " + context);
		String path = uri.substring(context.length());
		System.out.println("path: " + path);
	    
		Control control = map.get(path); //Control control = new AddEmpControl()
		control.exec(req, resp); // 여기서 exec는 control 상속받은 addempcontrol의 재정의된 exec임
		// 서비스의 req,resp를 가지고 exec를 실행해
	}

	// destroy
	@Override
	public void destroy() {

	}
}
