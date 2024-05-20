package com.home.product.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.common.HttpUtils;
import com.home.product.service.ProductService;
import com.home.product.service.ProductServiceImpl;
import com.home.product.vo.ProductVO;

public class ProductInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//순서 product.jsp를 만들고 컨트롤을 만드는건지ㅇㅇㅇ
		String pno = req.getParameter("pno");
		//System.out.println(pno);
		
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(Integer.parseInt(pno));
		
		req.setAttribute("result", vo); 

		String path = "WEB-INF/view/product/product.jsp";
		path = "product/product.tiles";
		
		HttpUtils.forward(req, resp, path);
		
		
	}

}
