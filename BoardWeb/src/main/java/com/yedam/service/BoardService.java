package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardList(); //목록부르기
	boolean addBoard(BoardVO board); //등록
	BoardVO getBoard(int boardNo); //조회
	int addViewCnt(int boardNo); //조회만 할때
	//수정
	boolean modifyBoard(BoardVO board);
	//삭제
	boolean removeBoard(int board);
}
