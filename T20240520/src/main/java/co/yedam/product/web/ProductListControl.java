package co.yedam.product.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.ProductVO;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.ProductServiceImpl;

public class ProductListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String path = "WEB-INF/product/productList.jsp";
		path = "product/productList.tiles";
		
		ProductService svc = new ProductServiceImpl();
		
		List<ProductVO> list = svc.productList();
		
		req.setAttribute("productList", list);
		
		try {
			req.getRequestDispatcher(path).forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
