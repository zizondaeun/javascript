package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.CartVO;
import com.yedam.vo.CenterVO;
import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	//댓글 목룍
	List<ReplyVO> replyList(int boardNo);
	List<ReplyVO> replyListPaging(SearchVO search); //페이지 기준으로 댓글 5개씩 보여주는거
	//댓글 삭제
	int deleteReply(int replyNo);
	//댓글 등록
	int insertReply(ReplyVO rvo);
	//댓글개수
	int selectCount(int replyNo);
	//댓글 수정
	int updateReply(ReplyVO rvo);
	
	//cart관련(목록, 수정, 삭제)
	List<CartVO> selectList();
	int updateCart(CartVO cvo);
	int deleteCart(int no);
	
	int insertCenter(CenterVO[] array);
}
