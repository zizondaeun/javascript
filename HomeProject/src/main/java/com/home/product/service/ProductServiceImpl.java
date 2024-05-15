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
	public List<ProductVO> producList() {
		return mapper.productList();
	} 

}
