package com.home.product.service;

import java.util.List;

import com.home.product.vo.ProductVO;

public interface ProductService {
	//service가 제공해야할 메소드 선언
	List<ProductVO> productList(); //상품목록

	ProductVO getProduct(int prodNo); //상품상세화면
	
	
}
