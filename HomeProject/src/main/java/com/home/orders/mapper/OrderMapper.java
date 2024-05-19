package com.home.orders.mapper;

import java.util.List;

import com.home.orders.vo.OrderVO;

public interface OrderMapper {
	//주문하기
	int insertOrder(OrderVO orders);

	List<OrderVO> selectOrder(String userId);

	int deleteOrder(int ono); 
}
