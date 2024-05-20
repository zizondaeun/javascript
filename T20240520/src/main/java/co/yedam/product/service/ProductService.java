package co.yedam.product.service;

import java.util.List;

import co.yedam.product.ProductVO;

public interface ProductService {

	List<ProductVO> productList();

	ProductVO infoProduct(String pCode);

	List<ProductVO> likeProduct();
}
