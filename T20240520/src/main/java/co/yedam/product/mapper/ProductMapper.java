package co.yedam.product.mapper;

import java.util.List;

import co.yedam.product.ProductVO;

public interface ProductMapper {

	List<ProductVO> selectList();

	ProductVO selectProduct(String pCode);

}
