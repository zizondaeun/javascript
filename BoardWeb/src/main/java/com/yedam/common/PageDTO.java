package com.yedam.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO { //데이터트랜스포오브젝트..
	//필드선언
	private int page; //현재페이지
	private int startPage, endPage; //현재페이지를 기준으로 시작페이지, 종료페이지
	private boolean prev, next; //이전, 이후 페이지 체크
	
	//생성자 /10개씩하는거 해보기
	public PageDTO(int page, int totalCnt) {
		this.page = page;
		int realEnd = (int) Math.ceil(totalCnt / 5.0);
		
		//현재페이지를 기준으로 보여주겠다 하면 5개씩 보여주겠다
		this.endPage = (int) Math.ceil(page / 5.0) * 5; //(int) Math.ceil(page / 5.0)=1
		//end페이지를 기준으로
		this.startPage = this.endPage - 4; 
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd ? true : false;
	}
	
	//메소드
}
