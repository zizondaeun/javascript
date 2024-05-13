package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	//댓글목록
	List<ReplyVO> replyList(int boardNo);
	//댓글삭제
	boolean removeReply(int replyNo);
	//댓글등록
	boolean addReply(ReplyVO rvo);
	
}
