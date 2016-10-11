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

		// ��ȡ�ؼ���
		String email = request.getParameter("email");
		String vercode = request.getParameter("vercode");

		// ������������֤��
		if (Dao.getVerCode(email).equals(vercode.trim())) {

			// �ض�λ
			request.getRequestDispatcher("setpwd.jsp?email=" + email).forward(request, response);

		} else {

			System.out.println("��֤ʧ�ܣ�������ע��");

		}

	}

}
