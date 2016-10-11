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

		// ��ȡ�ؼ���
		String email = request.getParameter("email");

		// �����Ƿ����
		if (Dao.checkEmail(email) == true) {

			// �����֤��
			String randomString = Get.getRandomString(32);

			// �������䣬д����֤��
			Dao.setVerCode(email, randomString);

			// �����ʼ�
			System.out.println("��������  http://www.getdemo.com.cn/VerCode?email=" + email + "?vercode=" + randomString);

			// �ض�λ
			request.getRequestDispatcher("tip.jsp").forward(request, response);

		} else {

			System.out.println("����δע��");

			// �ض�λ
			request.getRequestDispatcher("register.jsp").forward(request, response);

		}

	}

}
