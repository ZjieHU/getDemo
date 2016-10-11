package com.getdemo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");

		// 获取关键词
		String keyword = request.getParameter("keyword");
		System.out.println("+++++++++++++++" + keyword);
		String tag = "立即下载";

		// HttpSession
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		if (!"".equals(email)) {

			tag = "未登录，不可下载";

		} else {

			if (Dao.checkDownOK(email) == false) {

				tag = "未充值，不可下载";

			}

		}

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

}
