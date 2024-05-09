package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService { //기능구현은 여기서
	
	SqlSession session = DataSource.getInstance().openSession(true); //맵퍼작업해주는게 session /자동커밋
	BoardMapper mapper = session.getMapper(BoardMapper.class); //BoardMapper가 인터페이스, 인터페이스 이름으로 호출
	
	@Override
	public List<BoardVO> boardList() {
		return mapper.boardList();
	} 
	
	@Override
		public boolean addBoard(BoardVO board) {
			return mapper.insertBoard(board) == 1;
		}

	@Override
	public BoardVO getBoard(int boardNo) {
		//mapper.updateViewCnt(boardNo); //무조건 실행이 되다보니 조회만 하고싶을때..
		return mapper.selectBoard(boardNo);
	}
	//그냥 조회만 할수있게하려고
	@Override
	public int addViewCnt(int boardNo) {
		return mapper.updateViewCnt(boardNo);
	}
	//진짜 수정기능
	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.deleteBoard(boardNo) == 1;
	}

}
