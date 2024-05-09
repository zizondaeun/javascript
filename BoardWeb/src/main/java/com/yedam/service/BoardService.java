package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService { //서비스(Service) 클래스는 비즈니스 로직을 구현
	//서비스가 제공해야 하는 메소드들이 선언됨
	List<BoardVO> boardList(); //목록부르기
	boolean addBoard(BoardVO board); //등록
	BoardVO getBoard(int boardNo); //조회
	int addViewCnt(int boardNo); //조회만 할때
	//수정
	boolean modifyBoard(BoardVO board);
	//삭제
	boolean removeBoard(int board);
}
