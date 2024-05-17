package com.yedam.vo;

import lombok.Data;

@Data
public class CartVO {
	private int no; //상품번호
	private String productNm; //상품이름
	private int price; //가격
	private int qty; //수량
}
