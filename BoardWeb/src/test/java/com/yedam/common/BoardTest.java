package com.yedam.common;

import java.util.List;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
		//SqlSession session = DataSource.getInstance().openSession(); //맵퍼작업해주는게 session
		//BoardMapper mapper = session.getMapper(BoardMapper.class); //BoardMapper가 인터페이스, 인터페이스 이름으로 호출
		
		//BoardService svc = new BoardServiceImpl(); //등록기능 test
		//BoardVO vo = new BoardVO();
		//vo.setTitle("등록제목");
		//vo.setContent("등록내용");
		//vo.setWriter("user01");
		
		//if(svc.addBoard(vo)) {
		//	System.out.println("등록성공");
		//}else {
		//	System.out.println("등록실패");
		//}
		
		//List<BoardVO> list = svc.boardList(); //목록 가져오는 기능
		//for(BoardVO board : list) {
		//	System.out.println(board.toString());
		//}
		
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(1);
		if(vo != null) 
			System.out.println(vo.toString());
		else
			System.out.println("조회결과 없음");
		}	
	}
