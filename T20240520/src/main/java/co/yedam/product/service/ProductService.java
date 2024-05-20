package co.yedam.product.service;

import java.util.List;

import co.yedam.product.ProductVO;

public interface ProductService {
	//상품 목록
	List<ProductVO> productList();
	//상품상세화면
	ProductVO getProduct(String pCode);
}
