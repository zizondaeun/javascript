package com.home.product.vo;

import lombok.Data;

@Data
public class ProductVO {
	private int prodNo; //상품번호
	private String pordName; //상품이름
	private int prodPrice; //상품가격
	private String prodEx; //상품설명
	private String prodImg; //상품이미지
}
