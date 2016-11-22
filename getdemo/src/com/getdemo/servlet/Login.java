package com.getdemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getdemo.dao.Dao;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// »ñÈ¡¹Ø¼ü´Ê
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		String checkpwd = Dao.getPWD(email);
		
		PrintWriter pw = response.getWriter();
		
		if(checkpwd == null || checkpwd.equals("")) {
			pw.write("0");
		}
		
		else{
			pw.write(email);
		}
		
		pw.flush();
		
		pw.close();
	}

}
