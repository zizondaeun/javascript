package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper { 
	List<BoardVO> boardList(); //맵퍼쪽의 아이디boardList /목록기능
	int insertBoard(BoardVO board); //insert기능
	BoardVO selectBoard(int boardNo); //조회기능
	int updateViewCnt(int boardNo); //뷰카운트 증가
	int updateBoard(BoardVO board); //실제 수정처리기능
	int deleteBoard(int boardNo); //삭제기능
}
