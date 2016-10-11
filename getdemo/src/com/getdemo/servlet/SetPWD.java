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

		// ��ȡ�ؼ���
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		// д�����ݿ�
		Dao.setPWD(email, Get.getMD5(pwd));

		// �ض��򵽵�¼ҳ��
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
