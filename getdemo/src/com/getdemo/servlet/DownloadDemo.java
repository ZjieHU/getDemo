package com.getdemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.getdemo.bean.Demo;
import com.getdemo.bean.Source;
import com.getdemo.bean.User;
import com.getdemo.dao.Dao;

public class DownloadDemo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownloadDemo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String email = null;
		
		String id = request.getParameter("id");
		
		email = request.getParameter("email");
		
		PrintWriter pw = response.getWriter();
		
		User user = Dao.GetDemoUser(email);
		
		if(email == null) {
			
			pw.write("0");  //不予下载
			
		}else if(user.getDownOK() != null && !user.getDownOK().equals("null")) {
			
			Source source = Dao.getSource(id);
			
			if(source.getAddress() != null && !source.getAddress().equals("null")) {
				
				pw.write(source.getAddress());  //给予下载

			} else {
				pw.write("1");  //不予下载
			}
			
		}else {
			
			pw.write("0");  //不予下载
		
		}
		
		pw.flush();
		
		pw.close();
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
