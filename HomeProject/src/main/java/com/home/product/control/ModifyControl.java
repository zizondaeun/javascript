package com.home.product.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.common.Control;
import com.home.product.service.ProductService;
import com.home.product.service.ProductServiceImpl;
import com.home.product.vo.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 5 * 1024 * 1024;
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String no = mr.getParameter("pno");
		String name = mr.getParameter("name");
		String price = mr.getParameter("price");
		String ex = mr.getParameter("ex");
		String img = mr.getFilesystemName("img");
		
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		vo.setProdNo(Integer.parseInt(no));
		vo.setProdName(name);
		vo.setProdPrice(Integer.parseInt(price));
		vo.setProdEx(ex);
		vo.setProdImg(img);
		//System.out.println(vo);
		
		if(vo.getProdImg() == null) {
			vo.setProdImg("1");
		}
		
		if(svc.modifyProduct(vo)) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("수정 에러");
		}
		
	}

}
