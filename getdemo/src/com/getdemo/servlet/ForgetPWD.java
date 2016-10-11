package com.getdemo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getdemo.common.Get;
import com.getdemo.dao.Dao;

@SuppressWarnings("serial")
public class ForgetPWD extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取关键词
		String email = request.getParameter("email");

		// 邮箱是否存在
		if (Dao.checkEmail(email) == true) {

			// 随机验证码
			String randomString = Get.getRandomString(32);

			// 根据邮箱，写入验证码
			Dao.setVerCode(email, randomString);

			// 发送邮件
			System.out.println("邮箱链接  http://www.getdemo.com.cn/VerCode?email=" + email + "?vercode=" + randomString);

			// 重定位
			request.getRequestDispatcher("tip.jsp").forward(request, response);

		} else {

			System.out.println("邮箱未注册");

			// 重定位
			request.getRequestDispatcher("register.jsp").forward(request, response);

		}

	}

}
