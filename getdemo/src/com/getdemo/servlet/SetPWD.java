package com.getdemo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getdemo.common.Get;
import com.getdemo.dao.Dao;

@SuppressWarnings("serial")
public class SetPWD extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取关键词
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		// 写入数据库
		Dao.setPWD(email, Get.getMD5(pwd));

		// 重定向到登录页面
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
