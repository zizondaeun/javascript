package com.home.orders.service;

import java.util.List;

import com.home.orders.vo.OrderVO;

public interface OrderService {

	boolean orderProduct(OrderVO orders); //주문하기

	List<OrderVO> orderList(String userId); //주문목록

	boolean cancelOrder(int ono); //주문취소


}
