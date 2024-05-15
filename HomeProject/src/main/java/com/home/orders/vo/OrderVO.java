package com.home.orders.vo;

import lombok.Data;

@Data
public class OrderVO {
	private int orderNo; //주문번호
	private int prodNo; //상품번호
	private int orderCnt; //주문개수
	private int price; //주문금액
	private String userId; //회원아이디
}
