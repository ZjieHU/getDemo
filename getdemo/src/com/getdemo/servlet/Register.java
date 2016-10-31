package com.getdemo.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getdemo.bean.User;
import com.getdemo.dao.Dao;

public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 鑾峰彇鍙傛暟
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		
		if(Dao.checkEmail(email)) {
			//濡傛灉鐢ㄦ埛瀛樺湪
			
			PrintWriter pw = response.getWriter();
			
			pw.println(0);
		}else {
			User user = new User();
			
			user.setEmail(email);
			
			user.setPwd(pwd);
			
			user.setTime(getCurrentDate());
			
			Dao.register(user);
			
			PrintWriter pWriter = response.getWriter();
			
			pWriter.println(1); //鐢ㄦ埛鎴愬姛鐧诲綍
			
			setReffer(response,user.getEmail(),user.getPwd());
		}
	}
	
	private String getCurrentDate() {
		Date now = new Date(); 
	
		SimpleDateFormat dateFormat = new 
				SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//鍙互鏂逛究鍦颁慨鏀规棩鏈熸牸寮�
	
		return dateFormat.format(now);
	}
	
	private void setReffer(final HttpServletResponse response,
			final String userName, final String password) {
		final String sSession = userName;
		
	    Cookie oItem;  
	    
	    oItem = new Cookie("cookie", sSession);  
	    
	    oItem.setMaxAge(3600 * 24 * 365);
	    
	    response.addCookie(oItem);
	}
}
