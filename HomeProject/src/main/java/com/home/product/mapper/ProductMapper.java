package com.home.product.mapper;

import java.util.List;

import com.home.product.vo.ProductVO;

public interface ProductMapper {
	//상품목록기능
	List<ProductVO> productList();
	//상품상세화면
	ProductVO selectProduct(int prodNo);
	//상품등록화면
	int insertProduct(ProductVO product);
	//상품수정화면
	int updateProduct(ProductVO product);
	//상품삭제
	int deleteProduct(int prodNo);
	
	
	
	
}
