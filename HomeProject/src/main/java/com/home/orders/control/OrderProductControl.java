package com.home.orders.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.orders.service.OrderService;
import com.home.orders.service.OrderServiceImpl;
import com.home.orders.vo.OrderVO;

public class OrderProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pno = req.getParameter("pno");
		String orderCnt = req.getParameter("orderCnt");
		String price = req.getParameter("price");
		String userId = req.getParameter("userId");
		System.out.println("99999");
		
		OrderService svc = new OrderServiceImpl();
		
		OrderVO vo = new OrderVO();
		vo.setProdNo(Integer.parseInt(pno));
		vo.setOrderCnt(Integer.parseInt(orderCnt));
		vo.setPrice(Integer.parseInt(price));
		vo.setUserId(userId);
		
		if(svc.orderProduct(vo)) {
			resp.sendRedirect("main.do"); //여기아닌데
		}else {
			resp.sendRedirect("productInfo.do");
		}
	}

}
