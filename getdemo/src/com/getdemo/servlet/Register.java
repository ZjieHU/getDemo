package com.getdemo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getdemo.bean.User;
import com.getdemo.common.Get;
import com.getdemo.dao.Dao;
import com.getdemo.email.SendEmail;

@SuppressWarnings("serial")
public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// ��ȡ�ؼ���
		String email = request.getParameter("email");

		// �����Ƿ����
		if (Dao.checkEmail(email) == true) {

			// �ض�λ
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {

			// �����֤��
			String randomString = Get.getRandomString(32);

			User user = new User();
			user.setEmail(email);
			user.setVercode(randomString);
			user.setDownOK("0");
			user.setTime(Get.getTime());

			// ע���˺�
			Dao.register(user);

			// �����ʼ�
			try {
				new SendEmail().runSendEmail(email, "http://www.getdemo.com.cn/VerCode?email=" + email + "&vercode=" + randomString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// �ض�λ
			request.getRequestDispatcher("tip.jsp").forward(request, response);

		}

	}

}
