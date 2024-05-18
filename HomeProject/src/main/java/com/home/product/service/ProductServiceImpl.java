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

	@Override
	public boolean addForm(ProductVO product) {
		return mapper.insertProduct(product) == 1;
	}

	@Override
	public boolean modifyProduct(ProductVO product) {
		return mapper.updateProduct(product) == 1;
	}

	@Override
	public boolean removeProduct(int prodNo) {
		return mapper.deleteProduct(prodNo) == 1;
	} 
	
	

}
