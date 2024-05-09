package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService { //기능구현은 여기서 
	//해당 서비스 인터페이스를 구현하는 구체적인 클래스
	//실제로 BoardService 인터페이스에 선언된 메서드들을 구현하고 비즈니스 로직을 실행함
	SqlSession session = DataSource.getInstance().openSession(true); //맵퍼작업해주는게 session /자동커밋
	BoardMapper mapper = session.getMapper(BoardMapper.class); //BoardMapper가 인터페이스, 인터페이스 이름으로 호출
	//데이터베이스와의 연결을 설정하고, 
	//자동 커밋을 활성화한 상태로 데이터베이스 작업을 수행할 준비를 마치며, 
	//이를 편리하게 수행할 수 있도록 매퍼 인터페이스의 구현체를 가져옴
	
	@Override
	public List<BoardVO> boardList() {
		return mapper.boardList();
	} 
	
	@Override
		public boolean addBoard(BoardVO board) {
			return mapper.insertBoard(board) == 1; //성공했으니까 
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
	//삭제
	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.deleteBoard(boardNo) == 1;
	}

}
