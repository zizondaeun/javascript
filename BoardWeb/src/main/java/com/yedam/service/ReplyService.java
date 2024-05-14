package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
	//댓글목록
	List<ReplyVO> replyList(SearchVO search);
	//댓글삭제
	boolean removeReply(int replyNo);
	//댓글등록
	boolean addReply(ReplyVO rvo);
	//댓글건수
	int getReplyCnt(int boardNo);
}
