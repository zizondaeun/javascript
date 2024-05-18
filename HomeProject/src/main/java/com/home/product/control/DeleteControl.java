package com.home.product.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.product.service.ProductService;
import com.home.product.service.ProductServiceImpl;

public class DeleteControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("pno");

		ProductService svc = new ProductServiceImpl();
		
		if(svc.removeProduct(Integer.parseInt(no))) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("삭제 에러");
		}
	}

}
