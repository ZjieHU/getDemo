package com.getdemo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.getdemo.bean.Demo;
import com.getdemo.dao.Dao;

@SuppressWarnings("serial")
public class GetDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String email = getCookie(request);
		
		// 获取关键词
		String keyword = request.getParameter("keyword");
		String tag = "立即下载";
		
		Dao dao = new Dao();
		
		List<Demo> list = dao.find(0, keyword, tag);
		

		request.setAttribute("list", list);

		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	public String getCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		
		if(cookies == null) return null;
		
		for(Cookie cook : cookies) {
			if(cook.getName().equals("cookie")) {
				return cook.getValue();
			}
		}
		
		return null;
		
	}
	
}
