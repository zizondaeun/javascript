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
		String path = "product/productInfo.tiles";
		
		String pCode = req.getParameter("pCode");
		//System.out.println(pCode + "9999");
		ProductService svc = new ProductServiceImpl();
		
		ProductVO vo = svc.infoProduct(pCode);
		List<ProductVO> list = svc.likeProduct();
		req.setAttribute("result", vo); //상세정보
		req.setAttribute("list", list); //5개 리스트
		//System.out.println(vo + "1111");
		
		try {
			req.getRequestDispatcher(path).forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
