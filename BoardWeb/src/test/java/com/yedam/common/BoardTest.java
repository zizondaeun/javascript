package com.yedam.common;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.CartVO;

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
		
		//BoardService svc = new BoardServiceImpl();
		//BoardVO vo = svc.getBoard(1);
		//if(vo != null) 
		//	System.out.println(vo.toString());
		//else
		//	System.out.println("조회결과 없음");
		
		//페이징
		//BoardService svc = new BoardServiceImpl();
		//svc.boardList(1).forEach(board -> System.out.println(board));
		
		SqlSession session = DataSource.getInstance().openSession(true); 
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		//목록 가져오기
		CartVO cvo = new CartVO();
		cvo.setNo(3);
		cvo.setQty(1);
		int r = mapper.updateCart(cvo); //updateCart(cvo)-qty건수 변경,//deleteCart(cvo.getNo()
		System.out.println("건수: " + r);
		
		mapper.selectList().forEach(cart -> System.out.println(cart));
		
		//검색 테스트
		/*
		 * SearchVO search = new SearchVO(); search.setBoardNo(540); search.setRpage(3);
		 * 
		 * mapper.replyListPaging(search).forEach(reply -> System.out.println(reply));
		 */
		
		//SearchVO search = new SearchVO();
		//search.setSearchCondition("TW");
		//search.setKeyword("김다은");
		//search.setPage(1);
		
		//mapper.boardListPaging(search).forEach(board -> System.out.println(board));
		}	
		
		
	}

