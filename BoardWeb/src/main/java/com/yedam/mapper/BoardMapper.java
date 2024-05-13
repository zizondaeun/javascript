package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardMapper { 
	List<BoardVO> boardList(); //맵퍼쪽의 아이디boardList /목록기능
	List<BoardVO> boardListPaging(SearchVO search); //다섯페이지씩 보여주는(페이징목록)
	int getTotalCnt(SearchVO search); //전체건수 계산/매개값은 없음
	
	int insertBoard(BoardVO board); //insert기능
	BoardVO selectBoard(int boardNo); //조회기능
	int updateViewCnt(int boardNo); //뷰카운트 증가
	int updateBoard(BoardVO board); //실제 수정처리
	int deleteBoard(int boardNo); //삭제처리
	
	//사용자id, pw확인 /@Param 어노테이션을 붙이면 본인이 원하는 명으로 mapper에서 사용할 수 있다 #{}
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	//사용자가 맞는지 확인(기존멤버인지)
	MemberVO selectMember2(String id); //맵퍼에서 문제있을까봐 2
	
}
