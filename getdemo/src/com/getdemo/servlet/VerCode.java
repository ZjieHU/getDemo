package com.getdemo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getdemo.dao.Dao;

@SuppressWarnings("serial")
public class VerCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取关键词
		String email = request.getParameter("email");
		String vercode = request.getParameter("vercode");

		// 根据邮箱查出验证码
		if (Dao.getVerCode(email).equals(vercode.trim())) {

			// 重定位
			request.getRequestDispatcher("setpwd.jsp?email=" + email).forward(request, response);

		} else {

			System.out.println("验证失败，请重新注册");

		}

	}

}
