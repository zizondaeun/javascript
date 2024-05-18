package com.home.product.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.product.service.ProductService;
import com.home.product.service.ProductServiceImpl;
import com.home.product.vo.ProductVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String no = req.getParameter("pno");
		
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(Integer.parseInt(no));
		req.setAttribute("product", vo);
		
		String path = "WEB-INF/view/product/editForm.jsp";
		path = "product/editForm.tiles";
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
