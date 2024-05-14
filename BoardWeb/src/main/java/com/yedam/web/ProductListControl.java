package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.HttpUtils;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "product/productList.tiles"; //폴더/jsp파일 이름
		//req.getRequestDispatcher(path).forward(req, resp);
		HttpUtils.forward(req, resp, path);
	}

}
