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

		int currPage = 1;
		if (request.getParameter("page") != null) {
			currPage = Integer.parseInt(request.getParameter("page"));
		}
		Dao dao = new Dao();
		
		List<Demo> list = dao.find(currPage, keyword, tag);

		request.setAttribute("list", list);
		int pages; // 总页数
		
		int count = dao.findCount(keyword); // 查询总记录数
		
		if (count % Demo.PAGE_SIZE == 0) {
			pages = count / Demo.PAGE_SIZE;
		} else {
			pages = count / Demo.PAGE_SIZE + 1;
		}
		
		StringBuffer sb = new StringBuffer();
		// 通过循环构建分页条
		for (int i = 1; i <= pages; i++) {
			if (i == currPage) { // 判断是否为当前页
				sb.append("<li>" + i + "</li>"); // 构建分页条
			} else {
				sb.append("<a href='GetDemo?keyword=" + keyword + "&page=" + i + "'>" + i + "</a>"); // 构建分页条
			}
			sb.append(" ");
		}

		request.setAttribute("bar", sb.toString());

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
