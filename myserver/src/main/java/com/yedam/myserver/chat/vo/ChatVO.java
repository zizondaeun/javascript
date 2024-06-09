package com.yedam.myserver.chat.vo;

import lombok.Data;

@Data
public class ChatVO {
	private String no;		 //번호
	private String sndr;	 //작성자
	private String msg;      //메시지
	private String dttm;     //작성일시
}
