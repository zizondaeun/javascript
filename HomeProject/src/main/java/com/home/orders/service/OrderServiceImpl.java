package com.home.orders.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.home.common.DataSource;
import com.home.orders.mapper.OrderMapper;
import com.home.orders.vo.OrderVO;

public class OrderServiceImpl implements OrderService {

	SqlSession session = DataSource.getInstance().openSession(true); //맵퍼작업해주는게 session /자동커밋
	OrderMapper mapper = session.getMapper(OrderMapper.class);
	
	@Override
	public boolean orderProduct(OrderVO orders) {
		return mapper.insertOrder(orders) == 1; 
	}

	@Override
	public List<OrderVO> orderList(String userId) {
		return mapper.selectOrder(userId);
	}

	@Override
	public boolean cancelOrder(int ono) {
		return mapper.deleteOrder(ono) == 1;
	}

}
