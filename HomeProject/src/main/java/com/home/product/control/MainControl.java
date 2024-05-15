package com.home.product.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.common.HttpUtils;
import com.home.product.service.ProductService;
import com.home.product.service.ProductServiceImpl;
import com.home.product.vo.ProductVO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ssss");
		// main.do => WEB-INF/view/product/productList.jsp
		String path = "WEB-INF/view/product/productList.jsp";
		path = "product/productList.tiles"; //타일즈에 적용되게 각 control에 한다는데 이경로가 맞나?
		
		ProductService svc = new ProductServiceImpl();
		
		List<ProductVO> list = svc.producList(); //상품목록 부르기
		
		req.setAttribute("productList", list);
		
		HttpUtils.forward(req, resp, path);
		
	}

}
