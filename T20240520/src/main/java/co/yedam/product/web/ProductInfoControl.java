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

public class ProductInfoControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String path = "WEB-INF/product/productInfo.jsp";
		path = "product/productInfo.tiles";
		
		String pCode = req.getParameter("prodCode");
		
		ProductService svc = new ProductServiceImpl();
		
		ProductVO vo = svc.getProduct(pCode);
		List<ProductVO> list = svc.productList();
		
		req.setAttribute("result", vo);
		req.setAttribute("productList", list);
		
		try {
			req.getRequestDispatcher(path).forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
