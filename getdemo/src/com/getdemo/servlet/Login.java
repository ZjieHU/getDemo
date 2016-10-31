package com.getdemo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.getdemo.common.Get;
import com.getdemo.dao.Dao;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// »ñÈ¡¹Ø¼ü´Ê
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		String checkpwd = Dao.getPWD(email);
		
		if(checkpwd == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		else{
				request.getRequestDispatcher("/GetDemo").forward(request, response);

		}
	}

}
