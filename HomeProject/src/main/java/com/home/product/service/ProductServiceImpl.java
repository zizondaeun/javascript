package com.home.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.home.common.DataSource;
import com.home.product.mapper.ProductMapper;
import com.home.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService {
	
	SqlSession session = DataSource.getInstance().openSession(true); 
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> productList() {
		return mapper.productList();
	}

	@Override
	public ProductVO getProduct(int prodNo) {
		return mapper.selectProduct(prodNo);
	} 
	
	

}
