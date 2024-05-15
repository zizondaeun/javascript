package com.home.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpUtils {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
		
		try {
			String logPath = (String) req.getAttribute("logPath");
			
			HttpSession session = req.getSession();

			//로그인 정보가 없어도 가능
			req.getRequestDispatcher(path).forward(req, resp);					
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
