package com.home.orders.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.orders.service.OrderService;
import com.home.orders.service.OrderServiceImpl;
import com.home.orders.vo.OrderVO;

public class OrderListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/view/orderList.jsp";
		path = "orders/orderList.tiles";
		
		String userId = req.getParameter("userId");
		System.out.println(userId + "9999");
		OrderService svc = new OrderServiceImpl();
		
		List<OrderVO> list = svc.orderList(userId);
		
		req.setAttribute("orderList", list);
		
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
