package com.getdemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.getdemo.bean.Demo;
import com.getdemo.common.Get;
import com.getdemo.dao.Dao;

@SuppressWarnings("serial")
public class UpdateDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// »ñÈ¡¹Ø¼ü´Ê
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String function = request.getParameter("function");
		String describe = request.getParameter("describe");
		String downcount = request.getParameter("downcount");
		String downName = Get.getRandomString(32) + ".rar";
		String author = request.getParameter("author");
		String time = Get.getTime();

		Demo demo = new Demo();
		demo.setType(type);
		demo.setName(name);
		demo.setFunction(function);
		demo.setDescribe(describe);
		demo.setDownCount(Integer.parseInt(downcount));
		demo.setDownName(downName);
		demo.setUpdateTime(time);
		demo.setAuthor(author);
		demo.setTime(time);

		// ×¢²áÕËºÅ
		Dao.updateDemo(demo);

		PrintWriter out = response.getWriter();
		out.print(downName);
		out.flush();
		out.close();

	}

}
