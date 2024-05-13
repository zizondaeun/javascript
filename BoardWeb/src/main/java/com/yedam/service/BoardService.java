package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardService { //서비스(Service) 클래스는 비즈니스 로직을 구현
	//서비스가 제공해야 하는 메소드들이 선언됨
	List<BoardVO> boardList(SearchVO search); //목록부르기 / 페이지정보 널어주면
	int getTotal(SearchVO search); //전체건수(페이지할때)
	
	boolean addBoard(BoardVO board); //등록
	BoardVO getBoard(int boardNo); //조회
	int addViewCnt(int boardNo); //조회만 할때
	//수정
	boolean modifyBoard(BoardVO board);
	//삭제
	boolean removeBoard(int board);
	//로그인
	MemberVO login(String id, String pw);
	//체크멤버(유효한 아이디가 맞는지 확인)
	MemberVO checkMember(String id);
	
	
}
