package com.home.orders.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.orders.service.OrderService;
import com.home.orders.service.OrderServiceImpl;

public class OrderDeleteControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ono = req.getParameter("ono");
		
		OrderService svc = new OrderServiceImpl();
		
		if(svc.cancelOrder(Integer.parseInt(ono))) {
				resp.sendRedirect("orderList.do");
		}else {
				resp.sendRedirect("취소 에러");
		}
	}

}
